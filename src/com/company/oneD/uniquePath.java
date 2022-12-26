package com.company.oneD;

public class uniquePath {
    public static void main(String[] args) {
        int[][] dp = new int[3][3];
        //tabulation
        for (int i = 0; i <3; i++) {
            int up = 0, left = 0;
            for (int j = 0; j < 3; j++) {
                if (i == 0 && j == 0) dp[i][j] = 1;

                if (i > 0) up = dp[i-1][j];
                if (j > 0) left = dp[i][j-1];
                dp[i][j] += up + left;
            }
        }
        System.out.println(dp[2][2]);

        //space optimazation

        int[] sp = new int[3];
        for (int i = 0; i < 3; i++) {
            int[] temp = new int[3];
            for (int j = 0; j < 3; j++) {
                if (i == 0 && j == 0) temp[j] =1;
                int up = 0 , left= 0;
                    if (i > 0)  up = sp[j];
                    if (j > 0) left = temp[j-1];
                    temp[j] += up + left;
            }
            sp = temp;
        }
        System.out.println(sp[2]);
    }

    private static int f2(int i, int j, int[][] dp) {
        if(i == 0 && j == 0) return 1;
        if(i < 0 || j < 0) return 0;

        //do all the stuff;
        if (dp[i][j] != -1) return dp[i][j];
        int up = f(i-1,j);
        int left = f(i, j-1);

        return dp[i][j] = up + left;
    }

    private static int f(int i, int j) {
        //base case
        if(i == 0 && j == 0) return 1;
        if(i < 0 || j < 0) return 0;

        //do all the stuff;
        int up = f(i-1,j);
        int left = f(i, j-1);

        return up + left;
    }
}
