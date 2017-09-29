package com.eo.giflib;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by evansowino on 29/09/2017.
 */
@EnableAutoConfiguration
@ComponentScan
public class AppConfig {
    public static void main(String[] args) {
        // Call method in the Spring Boot library to run the application creating a new application context
        SpringApplication.run(AppConfig.class, args);
    }
}
