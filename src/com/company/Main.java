package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {

    public static void main( String[] args ) throws FileNotFoundException {

        File file = new File("input.txt");
        Scanner scanner = new Scanner(file);

        int n = scanner.nextInt();

        List<House> houseListXSorted = new ArrayList<>();
        List<House> houseListYSorted = new ArrayList<>();

        int i = 0;

        while (scanner.hasNextLine()) {
            House house = new House(scanner.nextInt(), scanner.nextInt(), i++);
            houseListXSorted.add(house);
            houseListYSorted.add(house);
        }

        houseListXSorted.sort(Comparator.comparingInt(House::x));
        houseListYSorted.sort(Comparator.comparingInt(House::y));

        SecondClosestPair.closestRecursive(houseListXSorted, houseListYSorted, 0,
                houseListXSorted.size() - 1);

        House h1 = SecondClosestPair.getSecondClosestPair().getHouse1();
        House h2 = SecondClosestPair.getSecondClosestPair().getHouse2();

        System.out.println(h1.index() + " " + h2.index());
        System.out.printf("%.4f", SecondClosestPair.getSecondClosestPair().getDistance());
    }
}
