package com.company;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
    public static void main(String[] args) {
        int n = 3;
        List<String> list = new ArrayList<>();
        fcr(n, 0, 0, "", list);
        System.out.println(list);
    }

    private static void fcr(int n, int open, int close, String s, List<String> list) {
        if (s.length() == 2 * n){
            list.add(s);
            return;
        }
        if (open < n) fcr(n, open+1, close, s + "(", list);
        if (close < open) fcr(n, open, close+1, s + ")", list);
    }
}
