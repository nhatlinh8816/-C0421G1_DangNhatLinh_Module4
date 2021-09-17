package case_study_module4.furama_resort_manager.model.service.employee;

import case_study_module4.furama_resort_manager.model.entity.employee.Degree;
import case_study_module4.furama_resort_manager.model.entity.employee.Division;

import java.util.List;

public interface DivisionService {
    List<Division> findAll();
}
