package com.example;

public class Recursion {
    static public int factorial(int n) {
        if (n == 1) return n;
        return n * factorial(n - 1);
    }

    static int fact(int n)
    {
        int result;
        if (n == 1)
            return 1;
        result = fact(n - 1) * n;
        return result;
    }
}
