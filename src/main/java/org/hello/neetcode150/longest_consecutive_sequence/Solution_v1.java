package org.hello.neetcode150.longest_consecutive_sequence;

import java.util.HashMap;

public class Solution_v1 {
    private HashMap<Integer,Boolean> check = new HashMap<>();

    public int longestConsecutive(int[] nums) {
        int maxValue = Integer.MIN_VALUE;
        int minValue = Integer.MAX_VALUE;

        for(int num : nums) { // O(n)
            maxValue = Math.max(maxValue, num);
            minValue = Math.min(minValue, num);
            check.put(num, true);
        }

        int cnt = 0;
        int answer = 0;
        for(int i = minValue; i <= maxValue; i++) {
            if(check.containsKey(i)) {
                cnt++;
            }else {
                cnt = 0;
            }
            answer = Math.max(answer, cnt);
        }

        return answer;
    }
}

// O(n)으로 풀긴 했지만 최대 10억이므로 최악의 경우 O(n)이 10억이 될 수 있다.