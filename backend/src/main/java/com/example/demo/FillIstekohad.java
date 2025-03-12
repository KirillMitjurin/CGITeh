package com.example.demo;


import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Random;


public class FillIstekohad {
    public static void main(String[] args) {
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            float p = random.nextFloat(0, 1);
            boolean occupied = p <= 0.3;
            System.out.println(occupied);
        }
    }

}
