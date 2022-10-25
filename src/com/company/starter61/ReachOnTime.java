package com.company.starter61;

import java.util.Scanner;

public class ReachOnTime {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int a = input.nextInt();
        for (int i = 1; i <= a; i++) {
            int b = input.nextInt();
            if (b >= 30 ) System.out.println("yes");
            else System.out.println("no");
        }
    }

}
