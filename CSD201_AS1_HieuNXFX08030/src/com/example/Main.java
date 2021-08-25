package com.example;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        int selectOption = 1;
        while (selectOption != 0) {
            Scanner sc = new Scanner(System.in);
            String data = FileTask.readFile(FileTask.INPUT).trim();
            int value;
            MenuInterface.createBreakLine();
            MenuInterface.log("Select one of there option below: ");
            MenuInterface.createMenuOption();
            MenuInterface.createBreakLine();
            MenuInterface.log("Your choice: ");
            selectOption = sc.nextInt();
            if (selectOption == 0) {
                MenuInterface.log("Bye");
            } else {
                switch (selectOption) {
                    case 1 -> {
                        MenuInterface.log("Choice: 1");
                        MenuInterface.log("Input number of elements: ");
                        int n = sc.nextInt();
                        int[] arr = new int[n];
                        System.out.println("Input your array from keyboard:");
                        for (int i = 0; i < n; i++) {
                            arr[i] = sc.nextInt();
                        }
                        FileTask.writeToFile(FileTask.INPUT, MenuInterface.arrayToString(arr));
                    }
                    case 2 -> {
                        MenuInterface.log("Choice: 2");
                        if (data.equals("")) {
                            MenuInterface.log("You haven't inputted the array");
                            break;
                        }
                        MenuInterface.log("The array you have inputted: " + data);
                    }
                    case 3 -> {
                        MenuInterface.log("Choice: 3 - Bubble Sort");
                        if (data.equals("")) {
                            MenuInterface.log("You haven't inputted the array");
                            break;
                        }
                        Algorithm.bubbleSort(MenuInterface.stringToArray(data));
                        /*
                            Calculate run time
                         */
                        calcRuntime("bubble", data);
                    }
                    case 4 -> {
                        MenuInterface.log("Choice: 4 - Selection Sort");
                        if (data.equals("")) {
                            MenuInterface.log("You haven't inputted the array");
                            break;
                        }
                        Algorithm.selectionSort(MenuInterface.stringToArray(data));
                        /*
                            Calculate run time
                         */
                        calcRuntime("selection", data);
                    }
                    case 5 -> {
                        MenuInterface.log("Choice: 5 - Insertion Sort");
                        if (data.equals("")) {
                            MenuInterface.log("You haven't inputted the array");
                            break;
                        }
                        Algorithm.insertionSort(MenuInterface.stringToArray(data));
                        /*
                            Calculate run time
                         */
                        calcRuntime("insertion", data);
                    }
                    case 6 -> {
                        MenuInterface.log("Choice: 6");
                        MenuInterface.log("Linear Search");
                        if (data.equals("")) {
                            MenuInterface.log("You haven't inputted the array");
                            break;
                        }
                        MenuInterface.log("Please enter the value: ");
                        value = sc.nextInt();
                        Algorithm.linearSearch(MenuInterface.stringToArray(data), value);
                    }
                    case 7 -> {
                        MenuInterface.log("Choice: 7");
                        MenuInterface.log("Binary Search");
                        if (data.equals("")) {
                            MenuInterface.log("You haven't inputted the array");
                            break;
                        }
                        /*
                            Sort the array before searching, using the insertion sort for this
                         */
                        int[] sortedArr = MenuInterface.stringToArray(data);
                        Algorithm.insertionSortDouble(sortedArr);
                        MenuInterface.log("The array after sorting: " + MenuInterface.arrayToString(sortedArr));
                        MenuInterface.log("Please enter the value of the number you want to search: ");
                        value = sc.nextInt();
                        int result = Algorithm.binarySearch(sortedArr, value);
                        if (result == -1) {
                            MenuInterface.log("Couldn't find the index of element with value is " + value + " in the sorted array");
                        } else {
                            MenuInterface.log("Found the value with index: " + result);
                        }
                        FileTask.writeToFile(FileTask.FIFTH_OUTPUT_FILE, String.valueOf(result));
                        MenuInterface.log("Successfully wrote to the file, you can check for file " + FileTask.FIFTH_OUTPUT_FILE + " for detail");
                        MenuInterface.createBreakLine();
                    }
                    default -> MenuInterface.log("Please enter a number with range from 0 to 7");
                }
            }
        }
        FileTask.readFile(FileTask.INPUT);
    }

    static void calcRuntime(String sortType, String stringArr) {
        long startTime = System.nanoTime();
        int[] arr = MenuInterface.stringToArray(stringArr);
        switch (sortType) {
            case "bubble":
                Algorithm.bubbleSortDouble(arr);
            case "selection":
                Algorithm.selectionSortDouble(arr);
            default:
                Algorithm.insertionSortDouble(arr);
        }
        long duration = (System.nanoTime() - startTime)/1000;
        MenuInterface.log("Run time: " + duration + " milliseconds");
        MenuInterface.createBreakLine();
    }
}
