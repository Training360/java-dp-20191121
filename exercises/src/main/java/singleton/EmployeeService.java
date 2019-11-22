package singleton;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class EmployeeService {

    private List<String> employees = new ArrayList<>();

    public void addEmployee(String name) {
        employees.add(name);
    }

    public List<String> listEmployees() {
        return Collections.unmodifiableList(employees);
    }
}
