package com.tanishq.care;

import com.tanishq.care.util.FileUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
@EntityScan("com.tanishq.care")
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
        //call
        System.out.println("Application started successfully.");

    }
}
