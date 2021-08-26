package com.example.sort;

import java.util.Arrays;
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

    static int partitionFunc(int[] arr, int left, int right) {
        int leftPointer = left;
        int rightPointer = right - 1;
        int pivot = arr[right];
        for (int i = leftPointer; i <= rightPointer; i++) {
            if (arr[i] <= pivot) {
                swap(arr, leftPointer, i);
                leftPointer++;
            }
        }
        swap(arr, leftPointer, right);
        return leftPointer;
    }

    public static void quickSort(int[] arr, int left, int right) {
        if (right - left <= 0) {
            return;
        } else {
            int partition = partitionFunc(arr, left, right);
            quickSort(arr, left, partition - 1);
            quickSort(arr, partition + 1, right);
        }
    }

    public static void shellSort(int[] arr) {
        int interval = 0;
        /*
            Tính giá trị khoảng (interval)
         */
        while (interval < arr.length / 3) {
            interval = interval * 3 + 1;
        }

        while (interval > 0) {
            for (int outer = interval; outer < arr.length; outer++) {
                /* chọn giá trị để chèn */
                int valueToInsert = arr[outer];
                int inner = outer;
                /* Dịch chuyển phần tử sang phải */
                while (inner > interval - 1 && arr[inner - interval] >= valueToInsert) {
                    arr[inner] = arr[inner - interval];
                    inner = inner - interval;
                }
                /* Chèn giá trị vào vị trí trên */
                arr[inner] = valueToInsert;
            }
            /* Tinhs toán lại giá trị của interval */
            interval = (interval - 1) / 3;
        }
    }

    public static int[] mergeSort(int[] arr) {
        if (arr.length == 1) {
            return arr;
        }
        int[] leftArr, rightArr;
        if (arr.length > 2) {
            leftArr = Arrays.copyOfRange(arr, 0, arr.length / 2 + 1);
            rightArr = Arrays.copyOfRange(arr, arr.length / 2 + 1, arr.length);
        } else {
            leftArr = Arrays.copyOfRange(arr, 0, 1);
            rightArr = Arrays.copyOfRange(arr, 1, 2);
        }
        leftArr = mergeSort(leftArr);
        rightArr = mergeSort(rightArr);

        return merge(leftArr, rightArr);
    }

    /* method for adding a new element to the end position array, for merge sort */
    static void addItem(int[] arr, int item) {
        for (int i = 0; i < arr.length - 1; i++) {
            arr[i] = arr[i + 1];
        }
        arr[arr.length - 1] = item;
    }

    /* method for remove the first element of an array */
    static void removeFirstItem(int[] arr) {
        int i = 0;
        while (i < arr.length - 1) {
            arr[i] = arr[i + 1];
            i++;
        }
        arr[i] = Integer.MAX_VALUE;
    }


    /* Method to merged 2 arrays */
    static int[] merge(int[] left, int[] right) {
        int[] result = new int[left.length + right.length];
        Arrays.fill(result, Integer.MAX_VALUE);
        while (left[0] != Integer.MAX_VALUE && right[0] != Integer.MAX_VALUE) {
            if (left[0] > right[0]) {
                addItem(result, right[0]);
                removeFirstItem(right);
            } else {
                addItem(result, left[0]);
                removeFirstItem(left);
            }
        }

        while (left[0] != Integer.MAX_VALUE) {
            addItem(result, left[0]);
            removeFirstItem(left);
        }

        while (right[0] != Integer.MAX_VALUE) {
            addItem(result, right[0]);
            removeFirstItem(right);
        }
        return result;
    }

    static void logArray(int[] arr) {
        for (int j : arr) {
            System.out.print(j + " ");
        }
        System.out.println();
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
        // quickSort(array, 0, array.length - 1);
        // shellSort(array);
        int[] result = mergeSort(array);

        System.out.println("New array after sorted");
        for (int j : result) {
            System.out.println(j);
        }
    }
}
