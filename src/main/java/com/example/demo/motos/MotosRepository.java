package com.example.demo.motos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MotosRepository
        extends JpaRepository<Motos, Long> {

    @Query("SELECT m FROm Motos m WHERE m.model = ?1")
    Optional<Motos> findMotosByModel(String model);
}
