package com.company.oneD;


public class twoD {
    public static void main(String[] args) {
        int[][] arr = {{2,1,3}, {3,4,6}, {10,1,6}, {8,3,7}};
        //row are no. of days and column are task ;
        //you can't do same task two simultaneous days;
        //return maximum point can we earned;
        System.out.println(helper(arr.length - 1,3, arr));

        //talk about memo

        int[][] dp = new int[arr.length][4];

        int max = 0;
        for (int i = 0; i < arr[0].length; i++) {
            max = Math.max(arr[0][i], max);
        }

        //talk about tabulation
        dp[0][0] = Math.max(arr[0][1], arr[0][2]);
        dp[0][1] = Math.max(arr[0][0], arr[0][2]);
        dp[0][2] = Math.max(arr[0][0], arr[0][1]);
        dp[0][3] = max;
        for (int i = 1; i < arr.length; i++) {
            for (int last = 0; last < 4; last++) {// previous day task knowledge
                int maxi = 0;
                for (int task = 0; task < 3; task++) { //current day maximum point
                    int point = 0;
                    if (task != last){
                        point = arr[i][task] + dp[i-1][task];
                    }
                    maxi = Math.max(maxi, point);
                }
                dp[i][last] = maxi;
            }
        }
        System.out.println(dp[dp.length-1][3]);

        // for space optimize;
        int[] spaceDp = new int[4];
        spaceDp[0] = Math.max(arr[0][1], arr[0][2]);
        spaceDp[1] = Math.max(arr[0][0], arr[0][2]);
        spaceDp[2] = Math.max(arr[0][0], arr[0][1]);
        spaceDp[3] = max;

        for (int i = 1; i < arr.length; i++) {
            for (int last = 0; last < 4; last++) {// previous day task knowledge
                int[] temp = new int[4];
                temp[last] = 0;
                for (int task = 0; task < 3; task++) { //current day maximum point
                    if (task != last){
                        temp[last] = Math.max(temp[last],arr[i][task] + spaceDp[task] );
                    }
                }
                spaceDp = temp;
            }
        }
        System.out.println(spaceDp[3]);

    }

    private static int helper2(int index, int last,int[][] points, int[][] dp) {

        if (index == 0 ){
            int maxi = 0;
            for (int i = 0; i < 3; i++) {
                if (last != i) {
                    maxi = Math.max(maxi, points[index][i]);
                }
            }
            return maxi;
        }

        if (dp[index][last] != -1) return dp[index][last];

        int maxi = 0;
        for (int i = 0; i < 3; i++) {
            int point = 0;
            if (i != last){
                point = points[index][i] + helper2(index-1, i, points,dp);
            }
            maxi = Math.max(maxi, point);
        }
        return dp[index][last] = maxi;
    }

    private static int helper(int index,int last, int[][] points) { //define index we need previous knowledge and max point
        // for current day;
        if (index == 0 ){
            int maxi = 0;
            for (int i = 0; i < 3; i++) {
                if (last != i) {
                    maxi = Math.max(maxi, points[index][i]);
                }
            }
            return maxi;
        }

        int maxi = 0;
        for (int i = 0; i < 3; i++) {
            int point = 0;
            if (i != last){
                point = points[index][i] + helper(index-1, i, points);
            }
            maxi = Math.max(maxi, point);
        }
        return maxi;
    }


}
