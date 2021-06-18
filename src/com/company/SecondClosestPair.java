package com.company;

import java.util.ArrayList;
import java.util.List;

public class SecondClosestPair {

    private static final HousePair closestPair = new HousePair();
    private static final HousePair secondClosestPair = new HousePair();

    private static double distanceBetweenTwoHouse( House house1, House house2 ) {
        return Math.sqrt(Math.pow((house1.x() - house2.x()), 2) +
                Math.pow((house1.y() - house2.y()), 2));
    }

    private static double calculateTheStripCase( List<House> houseArrayList, double minDistance ) {

        double minValue = minDistance;
        int size = houseArrayList.size();

        for (int i = 0; i < size; i++) {
            for (int j = i + 1; j < Math.min(size, i + 1 + 7); j++) {

                House house1 = houseArrayList.get(i);
                House house2 = houseArrayList.get(j);
                double distance = distanceBetweenTwoHouse(house1, house2);

                updateSecondClosest(house1, house2, distance);
                minValue = Math.min(minDistance, distance);
            }
        }

        return minValue;
    }

    private static void updateSecondClosest( House house1, House house2, double distance ) {
        if (distance < closestPair.getDistance()) {
            secondClosestPair.setHouse1(closestPair.getHouse1());
            secondClosestPair.setHouse2(closestPair.getHouse2());
            secondClosestPair.setDistance(closestPair.getDistance());

            closestPair.setHouse1(house1);
            closestPair.setHouse2(house2);
            closestPair.setDistance(distance);
        } else if (distance < secondClosestPair.getDistance() && distance > closestPair.getDistance()) {
            secondClosestPair.setHouse1(house1);
            secondClosestPair.setHouse2(house2);
            secondClosestPair.setDistance(distance);
        }
    }

    private static double calculateDistanceDirectly( List<House> houseArrayList, int startIndex, int endIndex ) {

        double result = Double.MAX_VALUE;

        for (int i = startIndex; i < endIndex; i++) {
            for (int j = i + 1; j < endIndex; j++) {

                House house1 = houseArrayList.get(i);
                House house2 = houseArrayList.get(j);
                double distance = distanceBetweenTwoHouse(house1, house2);

                updateSecondClosest(house1, house2, distance);
                result = Math.min(result, distance);
            }
        }

        return result;
    }

    public static double closestRecursive( List<House> houseListXSorted, List<House> houseListYSorted,
                                           int startIndex, int endIndex ) {

        if ((endIndex - startIndex) <= 3) {
            return calculateDistanceDirectly(houseListXSorted, startIndex, endIndex);
        }

        int midPoint = (startIndex + endIndex) / 2;
        House midHouse = houseListXSorted.get(midPoint);

        double distanceLeft = closestRecursive(houseListXSorted, houseListYSorted, startIndex, midPoint);
        double distanceRight = closestRecursive(houseListXSorted, houseListYSorted, midPoint, endIndex);
        double minDistance = Math.min(distanceLeft, distanceRight);

        ArrayList<House> arrayList3 = new ArrayList<>();

        for (int i = startIndex; i < endIndex; i++) {
            if (Math.abs(houseListYSorted.get(i).x() - midHouse.x()) < minDistance) {
                arrayList3.add(houseListYSorted.get(i));
            }
        }

        return Math.min(minDistance, calculateTheStripCase(arrayList3, minDistance));

    }

    public static HousePair getSecondClosestPair() {
        return secondClosestPair;
    }
}
