package com.company.dp.String;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {
    public static void main(String[] args) {
        String s = "aab";
        List<List<String>> lists = new ArrayList<>();
        fcr(s,lists,new ArrayList<>(), 0);
        System.out.println(lists);
    }

    private static void fcr(String s, List<List<String>> lists, ArrayList<String> list, int start) {
        if (start == s.length()){
            lists.add(new ArrayList<>(list));
            return;
        }
        for (int i = start; i < s.length(); ++i) {
            if (isPalindrome(s, start, i)){
                list.add(s.substring(start,i+1));
                fcr(s,lists,list,i+1);
                list.remove(list.size() -1);
            }
        }
    }

    private static boolean isPalindrome(String substring,int start , int end) {
        while (end >= start){
            if (substring.charAt(end) != substring.charAt(start)){
               return false;
            }
            end--;
            start++;
        }
        return true;
    }
}
