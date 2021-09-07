package com.example.demo.model.repository;

import com.example.demo.model.entity.Code;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CodeRepo extends JpaRepository<Code,Integer> {
    Code findByCode(String code);
}
