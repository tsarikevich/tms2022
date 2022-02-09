package com.tms.service;

import com.tms.model.FlowerMarket;
import com.tms.util.Constants;

public class Main {
    public static void main(String[] args) {
        FlowerMarket flowerMarket = new FlowerMarket(Constants.allFlowers);
        System.out.println(flowerMarket.getBouquet(Constants.ROSE, Constants.CARNATION, Constants.LILY, Constants.ROSE, Constants.TULIP, Constants.HERBERA));
        System.out.println(flowerMarket.getBouquet(Constants.TULIP, Constants.ASTER, Constants.HERBERA));
        System.out.println(flowerMarket.getBouquet(Constants.LILY, Constants.ASTER, Constants.CARNATION));
        System.out.println(flowerMarket.getBouquet(Constants.ROSE, Constants.ROSE, Constants.ROSE));
        System.out.println(flowerMarket.getBouquet(Constants.CARNATION, Constants.CARNATION, Constants.ROSE));
        System.out.println(flowerMarket.getBouquet(Constants.ROSE, Constants.ROSE, Constants.ROSE));
        System.out.println("Количество всех проданных цветов- " + FlowerMarket.allContFlower + ", на сумму - " + FlowerMarket.allCostFlower + " руб.");

    }

}
