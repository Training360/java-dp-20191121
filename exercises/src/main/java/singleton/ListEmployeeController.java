package singleton;

import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class ListEmployeeController {

    private final EmployeeService employeeService;

    public ListEmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    public List<String> listEmployees() {
        return employeeService.listEmployees();
    }
}
