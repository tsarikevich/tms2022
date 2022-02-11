package com.tms.service;

import com.tms.model.CargoTransport;
import com.tms.model.CivilTransport;
import com.tms.model.MillitaryTransport;
import com.tms.model.PassengerTransport;

public class Main {
    public static void main(String[] args) {
        MillitaryTransport suMilitary = MillitaryTransport.builder()
                .horsePower(1000)
                .maxSpeed(2500)
                .weight(15000)
                .model("СУ-29")
                .wingspan(11.36)
                .minimumRunwayLength(120)
                .isEjectionSystem(true)
                .numberOfRockets(4)
                .build();
        System.out.println(suMilitary.getInfo());
        System.out.println("----------------------------------------------");
        CivilTransport boeingCivil = CivilTransport.builder()
                .horsePower(300)
                .maxSpeed(988)
                .weight(180000)
                .model("Боинг-787")
                .wingspan(64.35)
                .numberOfPassenger(300)
                .minimumRunwayLength(400)
                .isBusinessClass(true)
                .build();
        System.out.println(boeingCivil.getInfo());
        System.out.println("----------------------------------------------");
        CargoTransport citroenCargo = CargoTransport.builder()
                .horsePower(70)
                .maxSpeed(120)
                .weight(4500)
                .model("Citroen")
                .numberOfWheels(4)
                .fuelConsumption(12.5)
                .loadCapacity(2)
                .build();
        System.out.println(citroenCargo.getInfo());
        System.out.println("----------------------------------------------");
        PassengerTransport toyotaPassenger = PassengerTransport.builder()
                .horsePower(181)
                .maxSpeed(200)
                .weight(2100)
                .model("Toyota")
                .numberOfWheels(4)
                .fuelConsumption(7.8)
                .bodyType("седан")
                .numberOfPassengers(5)
                .build();
        System.out.println(toyotaPassenger.getInfo());
        toyotaPassenger.groundTransportInfo();
        citroenCargo.groundTransportInfo();
        citroenCargo.checkCapacity();
        boeingCivil.checkNumberOfPassengers();
        suMilitary.shot();
        suMilitary.shot();
        suMilitary.shot();
        suMilitary.shot();
        suMilitary.shot();
        suMilitary.shot();
        suMilitary.ejection();
        suMilitary.ejection();
    }
}
