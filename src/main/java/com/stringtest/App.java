package com.stringtest;

import java.util.stream.*;
import java.io.File;
import java.util.*;

/* Rami Tests */
public class App {
    static String[] names;

    public static void main(String[] args) {
        // just for checking the path of the test.txt file
        System.out.println("Working Directory = " + System.getProperty("user.dir"));
        /* 
         * 
         * 
         * 
         * 
         */
        int[] numOfNames = { 10, 100, 1000, 10000, 100000 };
        for (int num : numOfNames) {
            names = new String[num];
            addNames(num, names); // add names from file to array
            long t2 = testCollect();
            long t1 = testReduce();
            System.out.println();
            System.out.println("Number of names to be tested and joined: " + num);
            if (t1 > t2) {
                System.out.println("### Collect is faster by " + (t1 - t2) + " milliseconds");
            } else {
                System.out.println("### Reduce is faster by " + (t2 - t1) + " milliseconds");
            }
        }
    }

    // add names from file to array
    public static void addNames(int numOfNames, String[] names) {

        try {
            Scanner sc = new Scanner(new File("src\\main\\java\\com\\stringtest\\test.txt"));
            for (int i = 0; i < numOfNames; i++) {
                names[i] = sc.nextLine();
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static long testReduce() {
        Date date1 = new Date();

        Stream.of(names).reduce((e1, e2) -> e1 + e2).get();
        Date date2 = new Date();
        return date2.getTime() - date1.getTime();
    }

    public static long testCollect() {
        Date date1 = new Date();
        Stream.of(names).collect(() -> new StringBuilder(), (e1, e2) -> e1.append(e2), (e1, e2) -> e1.append(e1));
        Date date2 = new Date();
        return date2.getTime() - date1.getTime();
    }
}
