package com.example.demo;

import jakarta.persistence.Entity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {

    @Autowired
    private LennudRepository lennudRepository;

    @Override
    public void run (String...args) throws Exception{
        lennudRepository.deleteAll();
        Lennud lend_1 = new Lennud("Tallinn", "Stockholm", 100);
        Lennud lend_2 = new Lennud ("Tallinn","Viin", 300);
        lennudRepository.saveAndFlush(lend_1);
        lennudRepository.saveAndFlush(lend_2);
    }
}
