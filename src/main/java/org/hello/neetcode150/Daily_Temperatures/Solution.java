package org.hello.neetcode150.Daily_Temperatures;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] answer = new int[temperatures.length];

        Deque<int[]> stack = new ArrayDeque<>();

        for(int i = 0; i < temperatures.length; i++) { // O(n)
            int temperature = temperatures[i];
            while(!stack.isEmpty() && temperature > stack.peek()[1]) {
                int[] value = stack.pop();
                answer[value[0]] = i - value[0];
            }

            stack.push(new int[]{i, temperature});
        }

        return answer;
    }
}
