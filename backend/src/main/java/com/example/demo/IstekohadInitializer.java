package com.example.demo;


import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;


// https://seatmaps.com/airlines/aa-american-airlines/boeing-737-800/ - võtsin lennuki konfiguratsioon sealt.

@Component
public class IstekohadInitializer implements CommandLineRunner {
    @Autowired
    LennudRepository lennudRepository;

    @Autowired
    IstekohadRepository istekohadRepository;

    @Override
    public synchronized void run(String... args) throws Exception {
        List<Lennud> lennud = lennudRepository.findAll();

        for (Lennud l : lennud) { // täitab istekohad, ja neende
            System.out.println(l);
            for (int rida = 1; rida < 25; rida++) {
                if (rida < 5) {
                    for (int koht = 1; koht < 5; koht++) {
                        boolean underWindow = koht == 1 || koht == 4;
                        boolean legSpace = true;
                        boolean closeToExit = false;
                        Istekohad istekohad = new Istekohad(rida, koht, false, underWindow, legSpace, closeToExit, l);
                        istekohadRepository.save(istekohad);
                    }
                }else {
                    for (int koht = 1; koht < 7; koht++) {
                        boolean underWindow = koht == 1 || koht == 6;
                        boolean legSpace = rida == 5 || rida == 13 || rida == 14;
                        boolean closeToExit = rida == 12 || rida == 13 || rida == 14;
                        Istekohad istekohad = new Istekohad(rida, koht, false, underWindow, legSpace, closeToExit, l);
                        istekohadRepository.save(istekohad);
                    }
                }
            }

        }
    }
}
