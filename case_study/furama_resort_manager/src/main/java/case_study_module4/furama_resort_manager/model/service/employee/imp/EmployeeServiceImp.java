package case_study_module4.furama_resort_manager.model.service.employee.imp;

import case_study_module4.furama_resort_manager.model.entity.employee.Employee;
import case_study_module4.furama_resort_manager.model.repository.employee.EmployeeRepo;
import case_study_module4.furama_resort_manager.model.service.employee.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImp implements EmployeeService {
    @Autowired
    private EmployeeRepo employeeRepo;
    @Override
    public Page<Employee> findAll(Pageable pageable) {
        return employeeRepo.findAll(pageable);
    }

    @Override
    public void save(Employee employee) {
        employeeRepo.save(employee);
    }

    @Override
    public void remove(Employee employee) {
        employeeRepo.delete(employee);
    }

    @Override
    public Employee findById(int id) {
        return employeeRepo.findById(id).get();
    }

    @Override
    public Page<Employee> findByNameContains(String name, Pageable pageable) {
        return employeeRepo.findByNameContains(name, pageable);
    }

}
