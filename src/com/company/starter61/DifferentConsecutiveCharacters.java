package com.company.starter61;

import java.util.Scanner;

public class DifferentConsecutiveCharacters {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int a = input.nextInt();
        for (int i = 1; i <= a; i++) {
            int b = input.nextInt();
            String str = input.next();
            int count = 0;
            for (int j = 1; j < str.length(); j++) {
                if (str.charAt(j) == str.charAt(j-1)) count++;
            }
            System.out.println(count);
        }
    }
}
