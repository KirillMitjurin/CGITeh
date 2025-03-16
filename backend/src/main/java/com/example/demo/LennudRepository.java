package com.example.demo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


// Repository, et kätte saada lennud.
@Repository
public interface LennudRepository extends JpaRepository <Lennud, Long> {
}
