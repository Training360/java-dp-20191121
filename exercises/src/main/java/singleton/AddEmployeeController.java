package singleton;

import org.springframework.stereotype.Controller;

@Controller
public class AddEmployeeController {

    private final EmployeeService employeeService;

    public AddEmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    public void addEmployee(String name) {
        employeeService.addEmployee(name);
    }

}
