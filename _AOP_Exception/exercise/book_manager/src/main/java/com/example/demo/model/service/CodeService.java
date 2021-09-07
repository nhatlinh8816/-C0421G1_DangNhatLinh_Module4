package com.example.demo.model.service;

import com.example.demo.model.entity.Code;

public interface CodeService {
    void save(Code code);
    void delete(Code code);
    Code findByCode(String code);
}
