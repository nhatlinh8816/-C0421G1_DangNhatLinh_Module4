package jquerry.demo.model.service;

import jquerry.demo.model.entity.SmartPhone;
import jquerry.demo.model.repository.SmartPhoneRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SmartPhoneServiceImp implements SmartPhoneService {
    @Autowired
    SmartPhoneRepo smartPhoneRepo;

    @Override
    public Iterable<SmartPhone> findAll() {
        return smartPhoneRepo.findAll();
    }

    @Override
    public Optional<SmartPhone> findById(int id) {
        return smartPhoneRepo.findById(id);
    }

    @Override
    public SmartPhone save(SmartPhone smartPhone) {
        return smartPhoneRepo.save(smartPhone);
    }

    @Override
    public void remove(int id) {
        smartPhoneRepo.deleteById(id);
    }
}
