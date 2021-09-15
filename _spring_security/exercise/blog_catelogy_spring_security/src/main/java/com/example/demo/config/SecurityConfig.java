package com.example.demo.config;

import com.example.demo.service.MyUserDetailsServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.rememberme.InMemoryTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private MyUserDetailsServiceImp myUserDetailsServiceImp;

    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        return new  BCryptPasswordEncoder();
    }
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(myUserDetailsServiceImp).passwordEncoder(passwordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .formLogin()
                .loginPage("/login")
                .defaultSuccessUrl("/blog/list").permitAll()
        .and()
                .authorizeRequests().antMatchers("/home").permitAll()
                .antMatchers("/blog/create","/blog/edit/{id}","/blog/delete/{id}").hasRole("USER")
                .anyRequest().permitAll() ;
        http.authorizeRequests().and().rememberMe().tokenRepository(this.persistentTokenRepository())
                .tokenValiditySeconds(30);
    }

    //config remember me
    public PersistentTokenRepository persistentTokenRepository(){
        InMemoryTokenRepositoryImpl memoryTokenRepository = new InMemoryTokenRepositoryImpl();
        return memoryTokenRepository;
    }
}
