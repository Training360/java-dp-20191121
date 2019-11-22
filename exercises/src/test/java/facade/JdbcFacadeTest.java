package facade;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.Optional;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = Configuration.class)
public class JdbcFacadeTest {

    @Autowired
    private DataSource dataSource;

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void testQueryForObjectTooMany() {
        expectedException.expect(IllegalStateException.class);
        expectedException.expectMessage("Too many results");
        JdbcFacade facade = new JdbcFacade(dataSource);

        facade.queryForObject("select id, name, lat, lon from locations",
                rs -> {
                    try {
                        return new Location(rs.getLong("id"),
                                rs.getString("name"),
                                rs.getDouble("lat"),
                                rs.getDouble("lon"));
                    } catch (SQLException sqle) {
                        throw new IllegalStateException("Error selecting", sqle);
                    }
                }).get();
    }

    @Test
    public void testQueryForObjectEmpty() {
        JdbcFacade facade = new JdbcFacade(dataSource);

        Optional<Location> result = facade.queryForObject("select id, name, lat, lon from locations where name = 'Foo'",
                rs -> {
                    try {
                        return new Location(rs.getLong("id"),
                                rs.getString("name"),
                                rs.getDouble("lat"),
                                rs.getDouble("lon"));
                    } catch (SQLException sqle) {
                        throw new IllegalStateException("Error selecting", sqle);
                    }
                });

        assertFalse(result.isPresent());
    }

    @Test
    public void testQueryForObject() {
        JdbcFacade facade = new JdbcFacade(dataSource);

        Location location = facade.queryForObject("select id, name, lat, lon from locations where name = 'Budapest'",
                rs -> {
                    try {
                        return new Location(rs.getLong("id"),
                                rs.getString("name"),
                                rs.getDouble("lat"),
                                rs.getDouble("lon"));
                    } catch (SQLException sqle) {
                        throw new IllegalStateException("Error selecting", sqle);
                    }
                }).get();

        assertThat(location.getName(), equalTo("Budapest"));
        assertThat(location.getLat(), equalTo(47.4979));
    }
}
