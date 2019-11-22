package interpreter;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class CitySelectorTest {

    @Test
    public void selectNames() {
        List<City> cities = Arrays.asList(
                new City("Budapest", "", 1_752_704),
                new City("Debrecen", "Hajdú-Bihar", 201_981),
                new City("Szeged", "Csongrád", 161_137),
                new City("Miskolc", " Borsod-Abaúj-Zemplén", 157_177),
                new City("Pécs", "Baranya", 144_675)
        );

        List<String> names = new CitySelector(cities).selectNames("#this.?[population gt 200000].![name]");
        assertThat(names, equalTo(Arrays.asList("Budapest", "Debrecen")));
    }
}
