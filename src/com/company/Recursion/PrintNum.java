package com.company.Recursion;

public class PrintNum {
    public static void main(String[] args) {
        num(0, 7);
    }

    private static void num(int i, int n) {
        if (i > n) return;
        num(i+1, n);
        System.out.println(i);
    }
}
