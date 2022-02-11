package com.tms.service;

import com.tms.model.CargoTransport;
import com.tms.model.CivilTransport;
import com.tms.model.MillitaryTransport;
import com.tms.model.PassengerTransport;

public class Main {
    public static void main(String[] args) {
        MillitaryTransport suMillitary = new MillitaryTransport(1000, 2500, 6000, "СУ-29", 11.36, 120, true, 4);
        System.out.println(suMillitary.getInfo());
        System.out.println("----------------------------------------------");
        CivilTransport boeingCivil = new CivilTransport(300, 988, 180000, "Боинг-787", 64.3, 350, 300, true);
        System.out.println(boeingCivil.getInfo());
        System.out.println("----------------------------------------------");
        CargoTransport citroenCargo = new CargoTransport(70, 120, 4500, "Citroen", 4, 12.5, 2);
        System.out.println(citroenCargo.getInfo());
        System.out.println("----------------------------------------------");
        PassengerTransport toyotaPassenger = new PassengerTransport(181, 200, 2100, "Toyota", 4, 7.8, "седан", 5);
        System.out.println(toyotaPassenger.getInfo());
        toyotaPassenger.groundTransportInfo();
        citroenCargo.groundTransportInfo();
        citroenCargo.checkCapacity();
        boeingCivil.checkNumberOfPassengers();
        suMillitary.shot();
        suMillitary.shot();
        suMillitary.shot();
        suMillitary.shot();
        suMillitary.shot();
        suMillitary.shot();
        suMillitary.ejection();
        suMillitary.ejection();
    }
}
