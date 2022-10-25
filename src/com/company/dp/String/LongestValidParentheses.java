package com.company.dp.String;

public class LongestValidParentheses {
    public static void main(String[] args) {
        System.out.println(func("()"));
        System.out.println(func2("()(()"));
    }

    private static int func2(String s) {
        int[] dp = new int[s.length()];
        int open = 0;
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') open++;
            if ( s.charAt(i)==')' && open > 0) {
                //matching
                dp[i] = 2 + dp[i-1];
                //matching from previous index
                if (i-dp[i] >0 )
                    dp[i] += dp[i-dp[i]];
                open--;
            }
            ans = Math.max(ans,dp[i]);
        }
        return ans;
    }

    private static int func(String s ){
        if (s.length() <= 1) return 0;
        int[] dp = new int[s.length()];
        int ans = 0;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == ')' && i-dp[i-1]-1 >= 0&& s.charAt(i-dp[i-1]-1) == '('){
                dp[i] = dp[i-1] + 2 + ((i-dp[i-1]-2 >= 0)? dp[i-dp[i-1]-2] : 0);
                ans = Math.max(dp[i], ans);
            }
        }
        return ans;
    }


}
