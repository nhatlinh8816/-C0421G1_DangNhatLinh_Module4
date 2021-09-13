package jquerry.demo.model.repository;

import jquerry.demo.model.entity.SmartPhone;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SmartPhoneRepo extends JpaRepository<SmartPhone,Integer> {

}
