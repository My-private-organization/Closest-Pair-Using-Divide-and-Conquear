package com.company;

public class ClosestPair {

    public static double distanceBetweenTwoHouse( House house1, House house2 ) {
        return Math.sqrt(Math.pow((house1.x() - house2.x()), 2) + Math.pow((house1.y() - house2.y()), 2));
    }



}
