package com.example.demo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class IstekohadKontroller {

    @Autowired
    IstekohadRepository istekohadRepository;

    @GetMapping("/istekohad")
    public List<Istekohad> getAllIstekohad(@RequestParam("lennudId") Long lennudId){
        return istekohadRepository.findByLennudId(lennudId);
    }

}
