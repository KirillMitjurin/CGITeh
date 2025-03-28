package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;

// Klass mis lennud ja lisab neid andmebaasile.
@Component
public class LennudInitializer implements CommandLineRunner {

    @Autowired
    private LennudRepository lennudRepository;
    // Geneererisin neid lennud AI-ga.

    @Override
    public void run (String...args) throws Exception{
        Lennud lennud1 = new Lennud("Tallinn", "Riga", 150.0f, LocalDate.of(2025, 6, 15), LocalTime.of(10, 0), LocalTime.of(11, 0), "airBaltic", "BT301", Duration.ofHours(1));
        lennudRepository.save(lennud1);

        Lennud lennud5 = new Lennud("Tallinn", "Berlin", 220.0f, LocalDate.of(2025, 6, 15), LocalTime.of(12, 30), LocalTime.of(15, 0), "Lufthansa", "LH881", Duration.ofHours(2).plusMinutes(30));
        lennudRepository.save(lennud5);

        Lennud lennud6 = new Lennud("Tallinn", "London", 300.0f, LocalDate.of(2025, 6, 25), LocalTime.of(15, 45), LocalTime.of(18, 45), "Ryanair", "FR902", Duration.ofHours(3));
        lennudRepository.save(lennud6);

        Lennud lennud2 = new Lennud("Helsinki", "Stockholm", 200.0f, LocalDate.of(2025, 7, 20), LocalTime.of(14, 30), LocalTime.of(15, 20), "Finnair", "AY803", Duration.ofMinutes(50));
        lennudRepository.save(lennud2);

        Lennud lennud7 = new Lennud("Helsinki", "Amsterdam", 280.0f, LocalDate.of(2025, 7, 25), LocalTime.of(11, 15), LocalTime.of(14, 0), "KLM", "KL1102", Duration.ofHours(2).plusMinutes(45));
        lennudRepository.save(lennud7);

        Lennud lennud3 = new Lennud("Paris", "Rome", 250.0f, LocalDate.of(2025, 8, 10), LocalTime.of(9, 15), LocalTime.of(11, 30), "Air France", "AF1204", Duration.ofHours(2).plusMinutes(15));
        lennudRepository.save(lennud3);

        Lennud lennud8 = new Lennud("Paris", "Madrid", 230.0f, LocalDate.of(2025, 8, 15), LocalTime.of(13, 0), LocalTime.of(14, 50), "Iberia", "IB3401", Duration.ofHours(1).plusMinutes(50));
        lennudRepository.save(lennud8);

        Lennud lennud4 = new Lennud("London", "New York", 700.0f, LocalDate.of(2025, 9, 5), LocalTime.of(16, 45), LocalTime.of(0, 45), "British Airways", "BA177", Duration.ofHours(8));
        lennudRepository.save(lennud4);

        Lennud lennud9 = new Lennud("London", "Dubai", 550.0f, LocalDate.of(2025, 9, 10), LocalTime.of(10, 0), LocalTime.of(17, 0), "Emirates", "EK004", Duration.ofHours(7));
        lennudRepository.save(lennud9);
    }
}
