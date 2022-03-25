package sebCzabak.EmployeeList.model;

import lombok.AllArgsConstructor;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@CrossOrigin("http://localhost:4200")
public class EmployeeController {
    private final EmployeeService employeeService;


    @GetMapping(path = "/employees")
    public List<Employee> getAllEmployees(){
        return employeeService.getALLEmployees();
    }

    @PostMapping(path="/addNewEmployee")
    public void addNewEmployee(@RequestBody Employee employee){
        employeeService.addNewEmployee(employee);

    }

    @DeleteMapping(path = "/deleteEmployee/{employeeId}")
    public void deleteEmployee(@PathVariable ("employeeId")Long employeeId){
        employeeService.deleteEmployee(employeeId);
    }
}
