package com.example.japworkshop;

import com.example.japworkshop.service.InitService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@RequiredArgsConstructor
public class JapWorkshopApplication implements CommandLineRunner {

//    private final InitService initService;

    public static void main(String[] args) {

        SpringApplication.run(JapWorkshopApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
//        initService.createSimpleData();
    }
}
