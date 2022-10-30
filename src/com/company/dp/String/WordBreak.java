package com.company.dp.String;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class WordBreak {
    public static void main(String[] args) {
        String s = "leetcode";
        List<String> wordDict = new ArrayList<>(
                Arrays.asList( "leet","code")
        );
        HashMap<String,Boolean> memo = new HashMap<>();
        System.out.println(memo(s,wordDict,memo));
    }

    private static boolean memo(String s, List<String> wordDict, HashMap<String,Boolean> memo) {
        if (wordDict.contains(s)) return true;
        if (memo.containsKey(s)) return memo.get(s);
        for(int i=0;i<s.length();i++) {
            String prefix = s.substring(0,i+1);
            String suffix = s.substring(i+1);

            if(wordDict.contains(prefix) && memo(suffix, wordDict,memo)) {
                memo.put(s, true);
                return true;
            }
        }
        memo.put(s,false);
        return false;
    }

    //classic partition
}
