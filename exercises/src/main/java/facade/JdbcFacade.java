package facade;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;
import java.util.function.Function;

public class JdbcFacade {

    private DataSource dataSource;

    public JdbcFacade(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public <T> Optional<T> queryForObject(String select, Function<ResultSet, T> extractor) {
        try (
                Connection c = dataSource.getConnection();
                PreparedStatement ps = c.prepareStatement(select);
                ResultSet rs = ps.executeQuery()
        )
        {
            if (rs.next()) {
                Optional<T> result = Optional.of(extractor.apply(rs));

                if (rs.next()) {
                    throw new IllegalStateException("Too many results");
                }
                return result;
            }
            else {
                return Optional.empty();

            }
        }
        catch (SQLException sqle) {
            throw new IllegalStateException("Error select", sqle);
        }

    }
}
