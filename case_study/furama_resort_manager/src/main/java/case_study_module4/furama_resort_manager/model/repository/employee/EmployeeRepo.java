package case_study_module4.furama_resort_manager.model.repository.employee;

import case_study_module4.furama_resort_manager.model.entity.employee.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepo extends JpaRepository<Employee,Integer> {
    Page<Employee> findByNameContains (String name, Pageable pageable);

}
