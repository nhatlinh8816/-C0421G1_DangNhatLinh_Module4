package model.service;

import model.entity.SmartPhone;

import java.util.Optional;

public interface SmartPhoneService {
    Iterable<SmartPhone> findAll();

    Optional<SmartPhone> findById(int id);

    SmartPhone save(SmartPhone smartPhone);

    void remove(int id);
}
