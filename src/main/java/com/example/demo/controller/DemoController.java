package com.example.demo.controller;

import java.util.List;

import com.example.demo.domain.Demo;
import com.example.demo.service.DemoService;

import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/demo/")
@Tag(name = "admin")
public class DemoController {

    @Autowired
    private DemoService demoService;

    @GetMapping("/list")
    public List<Demo> getList() {
        return demoService.getList();
    }

    @GetMapping("/search/{key}")
    public List<Demo> search(@PathVariable("key") String keyText) {
        return demoService.search(keyText);
    }

    @PostMapping("/save")
    public void save(@RequestBody Demo demo) {
        demoService.save(demo);
    }

    @PostMapping("/save-all")
    public void saveAll(@RequestBody List<Demo> demos) {
        demoService.saveAll(demos);
    }

    @PostMapping("/delete")
    public void delete(@RequestBody Demo demo) {
        demoService.delete(demo);
    }

    @PostMapping("/delete-all")
    public void deleteAll() {
        demoService.deleteAll();
    }
    
}
