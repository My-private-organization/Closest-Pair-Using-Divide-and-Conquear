package com.company;

import java.util.ArrayList;
import java.util.List;

public class SecondClosestPair {

    private static HousePair closestPair = new HousePair();
    private static HousePair secondClosestPair = new HousePair();

    private static double distanceBetweenTwoHouse( House house1, House house2 ) {
        return Math.sqrt(Math.pow((house1.x() - house2.x()), 2) +
                Math.pow((house1.y() - house2.y()), 2));
    }

    private static double calculateTheStripCase( List<House> houseArrayList, int size, double minDistance ) {

        double minValue = minDistance;

        for (int i = 0; i < size; i++) {
            for (int j = i + 1; j < Math.min(size, i + 1 + 7); j++) {

                double distance = distanceBetweenTwoHouse(houseArrayList.get(i), houseArrayList.get(j));

                if (distance < minDistance) {

                    if (distance < closestPair.getDistance()) {
                        secondClosestPair.setHouse1(closestPair.getHouse1());
                        secondClosestPair.setHouse2(closestPair.getHouse2());
                        secondClosestPair.setDistance(closestPair.getDistance());

                        closestPair.setHouse1(houseArrayList.get(i));
                        closestPair.setHouse2(houseArrayList.get(j));
                        closestPair.setDistance(distance);
                    }

                    minValue = distance;

                } else if (distance < secondClosestPair.getDistance() && distance > closestPair.getDistance()) {
                    secondClosestPair.setHouse1(houseArrayList.get(i));
                    secondClosestPair.setHouse2(houseArrayList.get(j));
                    secondClosestPair.setDistance(distance);
                }
            }
        }

        return minValue;
    }

    private static double calculateDistanceDirectly( List<House> houseArrayList, int count ) {

        double result = Integer.MAX_VALUE;

        for (int i = 0; i < count; i++) {
            for (int j = i + 1; j < count; j++) {

                double distance = distanceBetweenTwoHouse(houseArrayList.get(i), houseArrayList.get(j));

                if (distance < result) {

                    if (distance < closestPair.getDistance()) {
                        secondClosestPair.setHouse1(closestPair.getHouse1());
                        secondClosestPair.setHouse2(closestPair.getHouse2());
                        secondClosestPair.setDistance(closestPair.getDistance());

                        closestPair.setHouse1(houseArrayList.get(i));
                        closestPair.setHouse2(houseArrayList.get(j));
                        closestPair.setDistance(distance);
                    }

                    result = distance;

                } else if (distance < secondClosestPair.getDistance() && distance > closestPair.getDistance()) {
                    secondClosestPair.setHouse1(houseArrayList.get(i));
                    secondClosestPair.setHouse2(houseArrayList.get(j));
                    secondClosestPair.setDistance(distance);
                }
            }
        }

        return result;
    }

    public static double closestRecursive( List<House> houseListXSorted, List<House> houseListYSorted,
                                           int count ) {
        if (count <= 3) {
            return calculateDistanceDirectly(houseListXSorted, houseListXSorted.size());
        }

        int midPoint = count / 2;
        House midHouse = houseListXSorted.get(midPoint);

        ArrayList<House> newHouseX1 = new ArrayList<>();
        ArrayList<House> newHouseX2 = new ArrayList<>();
        int size = houseListXSorted.size();

        for (int i = 0; i < midPoint; i++) {
            newHouseX1.add(houseListXSorted.get(i));
        }

        for (int i = midPoint; i < size; i++) {
            newHouseX2.add(houseListXSorted.get(i));
        }

        double distanceLeft = closestRecursive(newHouseX1, houseListYSorted, midPoint);
        double distanceRight = closestRecursive(newHouseX2, houseListYSorted, count - midPoint);

        double minDistance = Math.min(distanceLeft, distanceRight);

        ArrayList<House> arrayList3 = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            if (Math.abs(houseListYSorted.get(i).x() - midHouse.x()) < minDistance) {
                arrayList3.add(houseListYSorted.get(i));
            }
        }

        return Math.min(minDistance, calculateTheStripCase(arrayList3, arrayList3.size(), minDistance));

    }

    public static HousePair getSecondClosestPair() {
        return secondClosestPair;
    }
}
