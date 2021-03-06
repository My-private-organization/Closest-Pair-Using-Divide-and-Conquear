package com.company;

public class HousePair {

    private House house1, house2;
    private double distance;

    public HousePair() {
        distance = Double.MAX_VALUE;
    }

    public House getHouse1() {
        return house1;
    }

    public void setHouse1( House house1 ) {
        this.house1 = house1;
    }

    public House getHouse2() {
        return house2;
    }

    public void setHouse2( House house2 ) {
        this.house2 = house2;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance( double distance ) {
        this.distance = distance;
    }
}
