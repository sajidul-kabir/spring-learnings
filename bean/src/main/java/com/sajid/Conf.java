package com.sajid;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class Conf {


    @Bean
    public String vehicleName(){
        return new Vehicle("Bus").getVehicleName();
    }

    @Bean
    public Vehicle getVehicle(String vehicleName){
        return new Vehicle(vehicleName);
    }
}
