package com.example.sort;

import java.util.Scanner;

public class Sort {
    static void swap(int[] arr, int i, int j) {
        var temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    static void bubbleSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = array.length - 1; j > i; j--) {
                if (array[j] < array[j - 1]) {
                    swap(array, j, j- 1);
                }
            }
        }
    }

    static void selectionSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }
            swap(array, i, minIndex);
        }
    }

    static void insertionSort(int[] arr) {
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

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of elements you want to store: ");
        int n = sc.nextInt();
        int[] array = new int[n];
        System.out.println("Input your array from keyboard:");
        for (int i = 0; i < n; i++) {
            array[i] = sc.nextInt();
        }

        // bubbleSort(array);
        // selectionSort(array);
        insertionSort(array);

        System.out.println("New array after sorted");
        for (int j : array) {
            System.out.println(j);
        }
    }
}
