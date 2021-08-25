package com.example;

import java.io.FileNotFoundException;

public class Algorithm {

    static void bubbleSort(int[] array) throws FileNotFoundException {
        FileTask.clearFile(FileTask.FIRST_OUTPUT_FILE);
        MenuInterface.createBreakLine();

        for (int i = 0; i < array.length; i++) {
            for (int j = array.length - 1; j > i; j--) {
                if (array[j] < array[j - 1]) {
                    swap(array, j, j - 1, FileTask.FIRST_OUTPUT_FILE);
                }
            }
        }

        MenuInterface.log("Successfully wrote to the file, you can check for file " + FileTask.FIRST_OUTPUT_FILE + " for detail");
        MenuInterface.createBreakLine();
    }

    static void selectionSort(int[] array) throws FileNotFoundException {
        FileTask.clearFile(FileTask.SECOND_OUTPUT_FILE);
        MenuInterface.createBreakLine();

        for (int i = 0; i < array.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < array.length; j++) {
                /*
                    Search for the position of minimum element for swapping
                 */
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }
            swap(array, i, minIndex, FileTask.SECOND_OUTPUT_FILE);
        }

        MenuInterface.log("Successfully wrote to the file, you can check for file " + FileTask.SECOND_OUTPUT_FILE + " for detail");
        MenuInterface.createBreakLine();
    }

    static void insertionSort(int[] arr) throws FileNotFoundException {
        FileTask.clearFile(FileTask.THIRD_OUTPUT_FILE);
        MenuInterface.createBreakLine();

        for (int i = 1; i < arr.length; i++) {
            int ele = arr[i];
            int j = i;
            /*
                decrease the position until index >= 0 and the element at that position is still bigger than the element at i index
             */
            while (j - 1 >= 0 && arr[j - 1] > ele) {
                /*
                    push all the element to the next position, and insert the element at index "i" to the founded element
                 */
                arr[j] = arr[j - 1];
                arr[j - 1] = ele;
                j--;
                MenuInterface.log(MenuInterface.arrayToString(arr));
                FileTask.appendToFile(FileTask.THIRD_OUTPUT_FILE, MenuInterface.arrayToString(arr));
            }
        }

        MenuInterface.log("Successfully wrote to the file, you can check for file " + FileTask.THIRD_OUTPUT_FILE + " for detail");
        MenuInterface.createBreakLine();
    }

    static void linearSearch(int[] arr, int value) {
        String result = "";

        /*
            loop for all the elements in the array, if the element is greater than value, push the element in the result array
         */
        for (int element: arr) {
            if (element > value) {
                result = result + " " + element;
            }
        }

        MenuInterface.log(new StringBuilder().append("Result: ").append(result).toString());
        FileTask.appendToFile(FileTask.FOURTH_OUTPUT_FILE, result.trim());
        MenuInterface.log("Successfully wrote to the file, you can check for file " + FileTask.FOURTH_OUTPUT_FILE + " for detail");
        MenuInterface.createBreakLine();
    }

    static int binarySearch(int[] sortArr, int value) {
        int middle;
        int left = 0;
        int right = sortArr.length - 1;

        while (left <= right) {
            // Select the middle index
            middle = (left + right) / 2;

            /*
                If value greater than the middle element, it must be in the right part of sorted array and vice versa
             */
            if (sortArr[middle] == value) {
                return middle;
            } else if (value > sortArr[middle]) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }
        /*
            return -1 if couldn't find the index of value in sorted array
         */
        return -1;
    }

    static void swap(int[] arr, int i, int j, String fileName) {
        var temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        /*
            Only log and print to file if there was any change
         */
        MenuInterface.log(MenuInterface.arrayToString(arr));
        FileTask.appendToFile(fileName, MenuInterface.arrayToString(arr));
    }

    /*
        There methods below is the copy of the sort and swap functions above, just for calculating the running time of each sort method, so they don't print anything to the console or text to file to save time
     */
    static void swapDouble(int[] arr, int i, int j) {
        var temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    static void bubbleSortDouble(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = array.length - 1; j > i; j--) {
                if (array[j] < array[j - 1]) {
                    swapDouble(array, j, j - 1);
                }
            }
        }
    }

    static void selectionSortDouble(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }
            swapDouble(array, i, minIndex);
        }
    }

    static void insertionSortDouble(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int ele = arr[i];
            int j = i;
            while (j - 1 >= 0 && arr[j - 1] > ele) {
                arr[j] = arr[j - 1];
                arr[j - 1] = ele;
                j--;
            }
        }
    }
}
