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

        System.out.println(SecondClosestPair.closestRecursive(houseListXSorted, houseListYSorted, houseListXSorted.size()));

        House h1 = SecondClosestPair.getSecondClosestPair().getHouse1();
        House h2 = SecondClosestPair.getSecondClosestPair().getHouse2();

        System.out.println(h1);
        System.out.println(h2);
        System.out.println(SecondClosestPair.getSecondClosestPair().getDistance());
    }
}
