package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@RestController
@RequestMapping("/api")
public class LennudKontroller {

    @Autowired
    private LennudRepository lennudRepository;

    @GetMapping("/lennud")
    public List<Lennud> getAllLennud(){
        return lennudRepository.findAll();
    }

}
