package com.example.demo;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/lennud/api")
@CrossOrigin
public class LennudKontroller {

    @GetMapping
    public List<Lennud> getLennud(){
        List<Lennud> lennuds = new ArrayList<>();
        Lennud lend_1 = new Lennud(0, "Tallinn", 100);
        Lennud lend_2 = new Lennud(1, "Viin", 300);
        lennuds.add(lend_1);
        lennuds.add(lend_2);

        return lennuds;
    }

}
