package case_study_module4.furama_resort_manager.model.repository.employee;

import case_study_module4.furama_resort_manager.model.entity.employee.Degree;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DegreeRepo extends JpaRepository<Degree,Integer> {
}
