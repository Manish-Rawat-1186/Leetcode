package com.company.dp.String;

import java.util.Arrays;

public class DistinctSubSequence {
    public static void main(String[] args) {
        String s = "babgbag";
        String t = "bag";
        int[][] memo = new int[s.length() + 1][t.length()+1];
        for (int i = 0; i < s.length()+1; i++) {
            Arrays.fill(memo[i], -1);
        }
        System.out.println(function(s,t,s.length()-1,t.length()-1));
        System.out.println(topTobottom(memo, s, t, s.length(), t.length()));
        System.out.println(bottomTotop(s, t));
        System.out.println(spaceOptimise(s,t));
    }

    private static int spaceOptimise(String s, String t) {
        int[] dp = new int[t.length() + 1];
        dp[0] = 1;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = t.length(); j >= 1; j--) {
                if (s.charAt(i-1) == t.charAt(j-1))
                    dp[j] += dp[j-1];
            }
        }
        return dp[t.length()];
    }

    private static int bottomTotop(String s, String t) {
        int[][] dp = new int[s.length() + 1][t.length() + 1];
        for (int i = 0; i <= s.length(); i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 1; j <= t.length(); j++) {
                dp[i][j] = dp[i-1][j];
                if (s.charAt(i-1) == t.charAt(j-1)) {
                    dp[i][j] += dp[i-1][j-1];
                }
            }
        }
        return dp[s.length()][t.length()];
    }

    private static int topTobottom(int[][] memo, String s, String t, int i, int j) {
        if (memo[i][j] != -1) return memo[i][j];
        if (j==0)  memo[i][j] = 1;
        else if (i == 0) memo[i][j] = 0;
        else {
            int sol1 = topTobottom(memo, s, t,i-1, j);
            int sol2 = 0;
            if (s.charAt(i-1) == t.charAt(j-1)) sol2 = topTobottom(memo, s, t, i-1, j-1);
            memo[i][j]= sol1 + sol2;
        }
        return memo[i][j];
    }



    private static int function(String s, String t, int i, int j) {
        if (i < 0 || j < 0 || i < j) return 0;
        if (s.charAt(i) == t.charAt(j)) {
            if (j == 0) return  1 + function(s,t,i-1,j);
            else return function(s,t,i-1,j-1) + function(s,t,i-1,j);
        }
        return function(s,t,i-1,j);
    }


}
