package tech.getarrays.emplyeemanager.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.getarrays.emplyeemanager.model.Employee;

import java.util.Optional;

public interface EmployeeRepo extends JpaRepository<Employee, Long> {
    void deleteEmployeeById(Long id);

    Optional<Employee> findEmployeeById(Long id);
}
