package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main( String[] args ) throws FileNotFoundException {

        File file = new File("input.txt");
        Scanner scanner = new Scanner(file);

        int n = scanner.nextInt();

        List<House> houseListXSorted = new ArrayList<>();
        List<House> houseListYSorted = new ArrayList<>();

        while (scanner.hasNextLine()) {
            House house = new House(scanner.nextInt(), scanner.nextInt());
            houseListXSorted.add(house);
            houseListYSorted.add(house);
        }

        houseListXSorted.sort(Comparator.comparingInt(House::x));
        houseListYSorted.sort(Comparator.comparingInt(House::y));



    }
}
