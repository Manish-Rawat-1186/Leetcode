package com.company.Recursion;

import java.util.ArrayList;
import java.util.Arrays;

public class TakeNotTake {
    public static void main(String[] args) {
        int[] arr = {3,2,1};
//        printAllsub(0,new ArrayList<Integer>(), arr);
        sumOfK(0, new ArrayList<>(),arr, 0, 3 );
    }

    private static void printAllsub(int i, ArrayList<Integer> ans, int[] arr) {
        if (i >= 3) {
            System.out.println(ans);
            return;
        }

        //take
        ans.add(arr[i]);
        printAllsub(i+1, ans, arr);
        //not take
        ans.remove(ans.size() - 1);
        printAllsub(i+1, ans , arr);
    }
    //kth sum
    private static void sumOfK(int i, ArrayList<Integer> ans, int[] arr, int sum, int k){
        if (i >= 3 && sum == k){
            System.out.println(ans);
            return;
        }
        ans.add(arr[i]);
        sumOfK(i+1, ans, arr, sum+arr[i], k);

        ans.remove(ans.size() -1);
        sumOfK(i+1, ans, arr, sum-arr[i], k);
    }
}
