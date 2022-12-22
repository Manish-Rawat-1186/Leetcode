package com.company.dp.String;

import java.util.Arrays;
import java.util.Scanner;

public class FrogJump {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = input.nextInt();
        }
        System.out.println(Arrays.toString(arr));

        System.out.println(sm(n-1,arr));


    }

    private static int sm(int i, int[] arr) {
        int prev1 = 0;
        int prev2 = 0;
        for (int j = 1; j < arr.length; j++) {
            int left = prev1 + Math.abs(arr[j] - arr[j-1]);
            int right = Integer.MAX_VALUE;
            if (j > 1) right = prev2 + Math.abs(arr[j] - arr[j-2]);
            int curr = Math.min(left, right);
            prev2 = prev1;
            prev1 = curr;
        }
        return prev1;
    }

    private static int dp(int i,int[] arr) {
        // now we can turn into more space optimize.
        // it's look like prev1 and prev2 and curr kind of analogy so let's write some code for space  optimization
        int[] memo = new int[arr.length];
        memo[0] = 0;
        for (int j = 1; j < arr.length; j++) {
            int right = Integer.MAX_VALUE;
            int left = memo[i-1] + Math.abs(arr[j] - arr[j-1]);
            if (j > 1) right = memo[i-2] + Math.abs(arr[j] - arr[j-2]);
            memo[j] = Math.min(right, left);
        }
        return memo[i];
    }

    private static int f(int i, int[] arr) {
        //frog can only jump one stair or two at a time.
        //so find the minimum path of energy.
        if (i == 0) return 0;
        int left = f(i - 1, arr) +  Math.abs(arr[i] - arr[i - 1]);
        int right = Integer.MAX_VALUE;
        if (i > 1) {
            right = f(i - 2, arr) + Math.abs(arr[i] - arr[i-2]);
        }
        return Math.min(left, right);
    }


}
