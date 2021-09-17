package case_study_module4.furama_resort_manager.model.repository.employee;


import case_study_module4.furama_resort_manager.model.entity.employee.Position;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PositionRepo extends JpaRepository<Position,Integer> {
}
