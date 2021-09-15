package com.example.demo.service;

import com.example.demo.model.MyUserDetail;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepo;
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
