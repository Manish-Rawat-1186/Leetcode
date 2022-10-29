package com.company.dp.String;

import java.util.Arrays;

public class PalindromePartitioningII {
    public static void main(String[] args) {
        String s = "aab";
        System.out.println(fcr2(s,0) - 1);
        int[] dp = new int[s.length()];
        Arrays.fill(dp, -1);
        System.out.println(tab(s));
        System.out.println(fcd(dp,s,0));
    }

    private static int tab(String s){
        int n = s.length();
        boolean[][] isPalindrome = new boolean[n][n];
        for (int len = 1; len <= n; len++) { //length of string
            for (int left = 0; left <= n-len ; left++) {//left
                //right
                int right = left+len-1;
                if (s.charAt(left) != s.charAt(right)) continue;
                if (right - left <= 2) isPalindrome[left][right] = true;
                else isPalindrome[left][right] = isPalindrome[left+1][right-1];
            }
        }
        int[] dp = new int[s.length() +1];
        dp[s.length()] = 0;
        for (int i = s.length() -1; i >= 0; i--) {
            int min = s.length();
            for (int j= i; j < s.length();j++) {
                if (isPalindrome[i][j]){
                    int cuts = 1 + dp[j+1];
                    min = Math.min(min, cuts);
                }
            }
            dp[i] = min;
        }
        return dp[0] -1;

    }

    private static int fcd(int[] dp, String s, int start) {
        if (start == s.length()) return 0;
        if (dp[start] != -1) return dp[start];
        int min = s.length();
        for (int i = start; i < s.length(); i++) {
            if (isPalindrome(s,start,i)){
                int cuts = 1 + fcd(dp, s, i+1);
                min = Math.min(min, cuts);
            }
        }
        return dp[start] = min;
    }

    private static int fcr2(String s, int start) {
        if (start == s.length()) return 0;
        int min = s.length();
        for (int i = start; i < s.length(); i++) {
            if (isPalindrome(s,start,i)){
                int cuts = 1 + fcr2(s,i+1);
                min = Math.min(min, cuts);
            }
        }
        return min;
    }

    private static boolean isPalindrome(String s, int start, int end) {
        while (end > start){
            if (s.charAt(end) != s.charAt(start)){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
