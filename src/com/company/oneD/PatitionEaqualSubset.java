package com.company.oneD;

public class PatitionEaqualSubset {
    public static void main(String[] args) {
        int[] nums = {1,5,11,5};
        int sum = 0;
        for (int num : nums) sum += num;
        if (sum%2 != 0) System.out.println(false);
        System.out.println(partition(nums.length-1, sum/2, nums));

        //for dp solution target - nums[i] play a role so it would be easy with 2d one for target and another for nums okey
        boolean[][] dp = new boolean[nums.length+1][sum/2+1];
        // look some zero so value return true
        dp[0][0] = true;
        for (int i = 1; i <= nums.length; i++) {
            for (int j = 0; j <= sum/2; j++) {
                if (j - nums[i-1] >= 0) dp[i][j] = dp[i-1][j-nums[i-1]];
                dp[i][j] = dp[i][j] || dp[i-1][j];
            }
        }
        System.out.println(dp[nums.length][sum/2]);

        // some are repetative in our code like i-1 ;
        boolean[] memo = new boolean[sum/2+1];
        memo[0] = true;
        for (int i = 1; i <= nums.length; i++) {
            for (int j = 0; j <= sum/2; j++) {
                if (j - nums[i-1] >= 0) memo[j] = memo[j -nums[i-1]] || memo[j];
            }
        }
        System.out.println(memo[sum/2]);

    }

    private static boolean partition(int i, int target, int[] nums) {
        if (i < 0 || target < 0) return false;
        if (target == 0) return true;
        return partition(i-1, target- nums[i], nums) || partition(i-1, target, nums);
    }


}
