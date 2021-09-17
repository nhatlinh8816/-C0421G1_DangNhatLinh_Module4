package case_study_module4.furama_resort_manager.model.repository.employee;

import case_study_module4.furama_resort_manager.model.entity.employee.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User,Integer> {
    User findByAccount(String account);
}
