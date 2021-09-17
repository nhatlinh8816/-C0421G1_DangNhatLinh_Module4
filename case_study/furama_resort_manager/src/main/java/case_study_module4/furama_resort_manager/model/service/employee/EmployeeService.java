package case_study_module4.furama_resort_manager.model.service.employee;

import case_study_module4.furama_resort_manager.model.entity.employee.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface EmployeeService {
    Page<Employee> findAll(Pageable pageable);
    void save(Employee employee);
    void remove(Employee employee);
    Employee findById(int id);
    Page<Employee> findByNameContains(String name, Pageable pageable);
}
