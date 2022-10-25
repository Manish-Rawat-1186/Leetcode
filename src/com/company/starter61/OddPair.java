package com.company.starter61;

import java.util.Scanner;

public class OddPair {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int a = input.nextInt();
        while (a-- >0){
            int b = input.nextInt();
            int c = input.nextInt();
            int d = input.nextInt();
            if ((b+c) % 2 != 0 || (c+d)%2 != 0 || (b+d)%2 != 0) System.out.println("yes");
            else System.out.println("no");
        }

    }
}
