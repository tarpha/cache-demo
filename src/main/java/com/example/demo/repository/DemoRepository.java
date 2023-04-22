package com.example.demo.repository;

import java.util.List;

import com.example.demo.domain.Demo;

import org.springframework.data.jpa.repository.JpaRepository;

public interface DemoRepository extends JpaRepository<Demo, Long> {

    public List<Demo> findByKeyText(String keyText);
    
}
