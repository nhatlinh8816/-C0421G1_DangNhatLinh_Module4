package case_study_module4.furama_resort_manager.model.service.employee;

import case_study_module4.furama_resort_manager.model.entity.employee.User;
import java.util.List;

public interface UserService {
    List<User> findAll();
    User findById(int id);
}
