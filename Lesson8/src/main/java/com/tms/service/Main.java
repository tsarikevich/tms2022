package com.tms.service;

import com.tms.model.Bouquet;
import com.tms.model.Flower;
import com.tms.util.Constants;

public class Main {
    public static void main(String[] args) {
//        Flower flower=new Flower(Constants.HERBERA);
//        System.out.println(flower);
        Flower ROSE = new Flower(Constants.ROSE, "15");
        Flower LILY = new Flower(Constants.LILY, "7");
        Flower ASTER = new Flower(Constants.ASTER, "5");
        Flower HERBERA = new Flower(Constants.HERBERA, "5");
        Flower tulip = new Flower(Constants.TULIP, "11");
        Flower carnation = new Flower(Constants.CARNATION, "8");
        Flower[] flowersForBuquet1 = {HERBERA, ROSE, ASTER};
        Bouquet bouquet1 = new Bouquet(flowersForBuquet1);
        System.out.println(bouquet1);

    }

}
