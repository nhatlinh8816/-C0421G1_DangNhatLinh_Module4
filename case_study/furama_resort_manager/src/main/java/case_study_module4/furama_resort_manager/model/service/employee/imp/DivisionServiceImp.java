package case_study_module4.furama_resort_manager.model.service.employee.imp;

import case_study_module4.furama_resort_manager.model.entity.employee.Degree;
import case_study_module4.furama_resort_manager.model.entity.employee.Division;
import case_study_module4.furama_resort_manager.model.repository.employee.DegreeRepo;
import case_study_module4.furama_resort_manager.model.repository.employee.DivisionRepo;
import case_study_module4.furama_resort_manager.model.service.employee.DegreeService;
import case_study_module4.furama_resort_manager.model.service.employee.DivisionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DivisionServiceImp implements DivisionService {
    @Autowired
    private DivisionRepo divisionRepo;
    @Override
    public List<Division> findAll() {
        return divisionRepo.findAll() ;
    }
}
