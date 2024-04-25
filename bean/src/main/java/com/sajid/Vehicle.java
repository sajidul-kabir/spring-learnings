package com.sajid;


public class Vehicle {
     String vehicleName;

    public void setVehicleName(String vehicleName) {
        this.vehicleName = vehicleName;
    }

    public Vehicle(String vehicleName) {
        this.vehicleName = vehicleName;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "vehicleName='" + vehicleName + '\'' +
                '}';
    }

    public String getVehicleName() {
        return vehicleName;
    }

    public Vehicle() {
    }

}
