package model.service;

import model.entity.SmartPhone;
import model.repository.SmartPhoneRepo;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SmartPhoneServiceImp implements SmartPhoneService {
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
