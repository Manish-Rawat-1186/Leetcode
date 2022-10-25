package com.company;

public class LastStoneWeightII {
    public static void main(String[] args) {
        int[] stones = { 3, 7, 4, 1, 8, 1};
        int S = 0, S1 = 0;

        for (int stone : stones) {
            S += stone;
        }
        Boolean[][] dp = new Boolean[S + 1][stones.length+1];

//        for (int i = 1; i < stones.length+1; i++) {
//            for (int j = 1; j < S/2 + 1 ; j++) {
//                if (dp[i-1][j] || (j >= stones[i-1] && dp[j - stones[i-1]][i-1]){
//
//                }
//            }
//        }
    }
}
