package com.example.demo.service;

import java.util.List;

import com.example.demo.domain.Demo;
import com.example.demo.repository.DemoRepository;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class DemoService {

    @Autowired
    private DemoRepository demoRepository;
    
    @Cacheable("list")
    public List<Demo> getList() {
        log.info("getList called");
        return demoRepository.findAll();
    }

    @Cacheable(value = "list", key = "#keyText")
    public List<Demo> search(String keyText) {
        log.info("search called");
        return demoRepository.findByKeyText(keyText);
    }

    @CacheEvict(value = "list", allEntries = true)
    public void save(Demo demo) {
        demoRepository.save(demo);
    }

    @CacheEvict(value = "list", allEntries = true)
    public void saveAll(List<Demo> demos) {
        demoRepository.saveAll(demos);
    }

    @CacheEvict(value = "list", key = "#demo.id")
    public void delete(Demo demo) {
        demoRepository.delete(demo);
    }

    @CacheEvict(value = "list", allEntries = true)
    public void deleteAll() {
        demoRepository.deleteAll();
    }

}
