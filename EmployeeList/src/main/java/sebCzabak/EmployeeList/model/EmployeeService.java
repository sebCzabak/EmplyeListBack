package sebCzabak.EmployeeList.model;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public List<Employee> getALLEmployees() {
        return employeeRepository.findAll();
    }

    public void addNewEmployee(final Employee employee) {
        Optional<Employee> employeeOptional = employeeRepository.findByEmail(employee.getEmail());
        if (employeeOptional.isPresent()) {
            throw new IllegalStateException("Email taken");
        }
        employeeRepository.save(employee);
    }

    public void deleteEmployee(final Long employeeId) {
        Optional<Employee> employeeOptional = employeeRepository.findById(employeeId);
        if (employeeOptional.isPresent()) {
            employeeRepository.deleteById(employeeId);
        } else {
            throw new IllegalStateException("Employee with id " + employeeId + " doesn't exists!");
        }
    }
}