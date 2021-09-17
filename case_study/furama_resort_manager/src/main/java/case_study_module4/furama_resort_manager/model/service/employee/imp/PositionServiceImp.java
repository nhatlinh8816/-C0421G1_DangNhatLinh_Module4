package case_study_module4.furama_resort_manager.model.service.employee.imp;

import case_study_module4.furama_resort_manager.model.entity.employee.Position;
import case_study_module4.furama_resort_manager.model.repository.employee.PositionRepo;
import case_study_module4.furama_resort_manager.model.service.employee.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PositionServiceImp implements PositionService {
    @Autowired
    private PositionRepo positionRepo;
    @Override
    public List<Position> findAll() {
        return positionRepo.findAll();
    }
}
