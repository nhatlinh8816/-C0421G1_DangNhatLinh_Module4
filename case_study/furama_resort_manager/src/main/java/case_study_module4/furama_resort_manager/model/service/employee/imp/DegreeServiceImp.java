package case_study_module4.furama_resort_manager.model.service.employee.imp;

import case_study_module4.furama_resort_manager.model.entity.employee.Degree;
import case_study_module4.furama_resort_manager.model.repository.employee.DegreeRepo;
import case_study_module4.furama_resort_manager.model.service.employee.DegreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DegreeServiceImp implements DegreeService {
    @Autowired
    private DegreeRepo degreeRepo;
    @Override
    public List<Degree> findAll() {
        return degreeRepo.findAll();
    }
}
