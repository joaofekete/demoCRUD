package com.example.demo.motos;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import static java.time.Month.*;

@Configuration
public class MotosConfig {

    @Bean
    CommandLineRunner commandLineRunner(MotosRepository repository){
        return args -> {
            Motos r1 = new Motos(
                    "R1",
                    "Yamaha",
                    LocalDate.of(1998, JANUARY, 1),
                    998
            );
            Motos cbr1000rr = new Motos(
                    "cbr1000rr",
                    "Honda",
                    LocalDate.of(2003, JANUARY, 1),
                    999
            );

            repository.saveAll(
                    List.of(r1, cbr1000rr)
            );

        };
    }

}
