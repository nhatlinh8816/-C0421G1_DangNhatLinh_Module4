package case_study_module4.furama_resort_manager.model.service.employee;


import case_study_module4.furama_resort_manager.model.entity.employee.MyUserDetail;
import case_study_module4.furama_resort_manager.model.entity.employee.User;
import case_study_module4.furama_resort_manager.model.repository.employee.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class MyUserDetailsServiceImp implements UserDetailsService {
    @Autowired
    UserRepo userRepo;
    @Override
    public UserDetails loadUserByUsername(String account) throws UsernameNotFoundException {
        User user =  userRepo.findByAccount(account);
        if (user==null){
            throw new UsernameNotFoundException("User nam "+ user+ "not found");
        }
        return new MyUserDetail(user);
    }
}
