package com.example;

public class MenuInterface {
    private static final String[] options = {
            "1. Input", "2. Output", "3. Bubble sort", "4. Selection sort", "5. Insertion sort",
            "6. Search > value", "7. Search = value", "0. Exit"
    };

    static void createMenuOption() {
        for (String option : options) {
            System.out.println(option);
        }
    }

    static void createBreakLine() {
        System.out.println("==================================");
    }

    static void log(String text) {
        System.out.println(text);
    }

    static String arrayToString(int[] arr) {
        String result = "";
        for (int ele: arr) {
            result = result + " " + ele;
        }
        return result.trim();
    }

    static int[] stringToArray(String str) {
        String[] arrStr = str.split(" ");
        int size = arrStr.length;
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = Integer.parseInt(arrStr[i]);
        }
        return arr;
    }
}
