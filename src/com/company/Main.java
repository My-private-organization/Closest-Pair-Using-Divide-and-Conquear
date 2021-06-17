package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    public static void main( String[] args ) throws FileNotFoundException {

        File file = new File("input.txt");
        Scanner scanner = new Scanner(file);

        int n = scanner.nextInt();

        int[] arrX = new int[n];
        int[] arrY = new int[n];

        int i = 0;

        while (scanner.hasNextLine()) {
            arrX[i] = scanner.nextInt();
            arrY[i] = scanner.nextInt();
            i++;
        }


    }
}
