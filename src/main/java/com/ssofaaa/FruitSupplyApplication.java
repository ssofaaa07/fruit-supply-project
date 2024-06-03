package com.ssofaaa;

import com.ssofaaa.repositories.FruitRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.filter.HiddenHttpMethodFilter;

@SpringBootApplication
public class FruitSupplyApplication {
    public static void main(String[] args) {
        SpringApplication.run(FruitSupplyApplication.class, args);
    }

    @Bean
    HiddenHttpMethodFilter hiddenHttpMethodFilter() {
        return new HiddenHttpMethodFilter();
    }
}
