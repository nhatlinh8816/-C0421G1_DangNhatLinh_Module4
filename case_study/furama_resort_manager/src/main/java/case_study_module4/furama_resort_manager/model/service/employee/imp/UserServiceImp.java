package case_study_module4.furama_resort_manager.model.service.employee.imp;


import case_study_module4.furama_resort_manager.model.entity.employee.User;
import case_study_module4.furama_resort_manager.model.repository.employee.UserRepo;
import case_study_module4.furama_resort_manager.model.service.employee.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImp implements UserService {
    @Autowired
    UserRepo userRepo;
    @Override
    public List<User> findAll() {
        return userRepo.findAll();
    }

    @Override
    public User findById(int id) {
        return userRepo.findById(id).get();
    }
}
