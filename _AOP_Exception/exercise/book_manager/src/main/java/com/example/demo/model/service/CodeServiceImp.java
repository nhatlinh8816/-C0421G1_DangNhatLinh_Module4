package com.example.demo.model.service;

import com.example.demo.model.entity.Code;
import com.example.demo.model.repository.CodeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CodeServiceImp implements CodeService {
    @Autowired
    private CodeRepo codeRepo;

    @Override
    public void save(Code code) {
        codeRepo.save(code);
    }

    @Override
    public void delete(Code code) {
        codeRepo.delete(code);
    }

    @Override
    public Code findByCode(String code) {
        return codeRepo.findByCode(code);
    }
}
