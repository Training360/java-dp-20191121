package facade;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.sql.DataSource;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = Configuration.class)
public class JdbcTemplateTest {

    @Autowired
    private DataSource dataSource;

    @Test
    public void testQuery() {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        Location location = jdbcTemplate.queryForObject("select id, name, lat, lon from locations where name = 'Budapest'",
                (rs, i) -> new Location(rs.getLong("id"),
                        rs.getString("name"),
                        rs.getDouble("lat"),
                        rs.getDouble("lon")));

        assertThat(location.getName(), equalTo("Budapest"));
        assertThat(location.getLat(), equalTo(47.4979));

    }
}
