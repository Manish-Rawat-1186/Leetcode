package com.company.Recursion;

import java.util.ArrayList;
import java.util.Arrays;

public class SortArray {
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>(
                Arrays.asList(5,1,0,2)
        );
        arr = sort(arr);
        System.out.println(arr);
    }

    private static ArrayList<Integer> sort(ArrayList<Integer> arr) {
        //base condition
        if (arr.size() == 1) return arr;

        //hypothesis
        int temp = arr.get(arr.size() -1);
        arr.remove(arr.size() -1);
        sort(arr);

        insert(arr, temp);
        return arr;
    }

    private static ArrayList<Integer> insert(ArrayList<Integer> arr, int temp) {
        //base condition
        if (arr.size() == 0 || temp >= arr.get(arr.size() -1)){
            arr.add(temp);
            return arr;
        }

        //Hypothesis
        int val = arr.get(arr.size() -1);
        arr.remove(arr.size() -1);
        insert(arr,temp);

        //Induction all magic happen here
        arr.add(val);
        return arr;

    }
}
