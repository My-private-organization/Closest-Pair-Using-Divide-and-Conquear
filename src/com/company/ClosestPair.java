package com.company;

import java.util.ArrayList;
import java.util.List;

public class ClosestPair {

    private static double distanceBetweenTwoHouse( House house1, House house2 ) {
        return Math.sqrt(Math.pow((house1.x() - house2.x()), 2) + Math.pow((house1.y() - house2.y()), 2));
    }

    private static double calculateCase3( List<House> houseArrayList, int size, double minDistance ) {

        double minValue = minDistance;

        for (int i = 0; i < size; i++) {
            for (int j = i + 1; j < Math.min(size, i + 1 + 7); j++) {
                minValue = Math.min(minValue, distanceBetweenTwoHouse(houseArrayList.get(i), houseArrayList.get(j)));
            }
        }

        return minValue;
    }

    private static double bruteForce( List<House> houseArrayList, int count ) {
        double result = Integer.MAX_VALUE;

        for (int i = 0; i < count; i++) {
            for (int j = i + 1; j < count; j++) {
                result = Math.min(result, distanceBetweenTwoHouse(houseArrayList.get(i), houseArrayList.get(j)));
            }
        }

        return result;
    }

    public static double closestRecursive( List<House> houseListXSorted, List<House> houseListYSorted,
                                           int count ) {
        if (count <= 3) {
            return bruteForce(houseListXSorted, houseListXSorted.size());
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

        return Math.min(minDistance, calculateCase3(arrayList3, arrayList3.size(), minDistance));

    }

}
