package singleton;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Arrays;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = Configuration.class)
public class EmployeeTest {

    @Autowired
    private AddEmployeeController addEmployeeController;

    @Autowired
    private ListEmployeeController listEmployeeController;

    @Test
    @DirtiesContext
    public void addAndListEmployee() {
        addEmployeeController.addEmployee("John Doe");
        assertThat(listEmployeeController.listEmployees(), equalTo(Arrays.asList("John Doe")));
    }

    @Test
    @DirtiesContext
    public void addAndListMoreEmployee() {
        addEmployeeController.addEmployee("John Doe");
        addEmployeeController.addEmployee("Jack Doe");
        assertThat(listEmployeeController.listEmployees(), equalTo(Arrays.asList("John Doe", "Jack Doe")));
    }
}
