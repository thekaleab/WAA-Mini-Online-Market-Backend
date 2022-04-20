package com.example.waaonlineminimarketbackend;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.event.EventListener;



@SpringBootApplication
public class WaaOnlineMiniMarketBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(WaaOnlineMiniMarketBackendApplication.class, args);

    }
    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }



}
