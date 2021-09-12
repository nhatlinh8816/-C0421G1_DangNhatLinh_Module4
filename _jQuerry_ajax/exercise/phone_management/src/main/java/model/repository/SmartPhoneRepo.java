package model.repository;

import model.entity.SmartPhone;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SmartPhoneRepo extends JpaRepository<SmartPhone,Integer> {

}
