package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


// klass Istekoha koha hoidmiseks.
@Repository
public interface IstekohadRepository extends JpaRepository<Istekohad, Long> {
    List<Istekohad> findByLennudId(long id);


}
