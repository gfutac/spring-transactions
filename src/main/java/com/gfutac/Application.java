package com.gfutac;

import com.gfutac.demo.Demo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application implements CommandLineRunner {

    @Autowired
    private Demo demo;

    public static void main(String[] args){
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        demo.transaction_unchecked();
        // demo.transaction_checked_without_rollback();
        // demo.transaction_checked_with_rollback();
    }
}
