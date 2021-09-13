package tech.getarrays.emplyeemanager.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.getarrays.emplyeemanager.exception.UserNotFoundException;
import tech.getarrays.emplyeemanager.model.Employee;
import tech.getarrays.emplyeemanager.repo.EmployeeRepo;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class EmployeeService {
    private final EmployeeRepo employeeRepo;

    @Autowired
    public EmployeeService(EmployeeRepo employeeRepo){
        this.employeeRepo = employeeRepo;
    }

    //Insert
    public Employee addEmployee(Employee employee){
        employee.setEmployeeCode(UUID.randomUUID().toString());
        return employeeRepo.save(employee);
    }

    //Select * from
    public List<Employee> findAllEmployees(){
        return employeeRepo.findAll();
    }

    //Update
    public Employee updateEmployee(Employee employee){
        return employeeRepo.save(employee);
    }

    public Employee findEmployeeById(Long id){
        return employeeRepo.findEmployeeById(id)
                .orElseThrow(() -> new UserNotFoundException("User by id " + id + " was not found"));
    }

    //Delete
    public void deleteEmployee(Long id){
        employeeRepo.deleteEmployeeById(id);
    }
}
