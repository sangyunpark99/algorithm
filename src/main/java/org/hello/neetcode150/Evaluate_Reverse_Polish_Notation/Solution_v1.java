package org.hello.neetcode150.Evaluate_Reverse_Polish_Notation;

import java.util.Stack;

public class Solution_v1 {
    public int evalRPN(String[] tokens) {

        Stack<Integer> stack = new Stack<Integer>();

        for(String token: tokens) {
            if(token.equals("+")) {
                int[] nums = getNum(stack);
                stack.push(nums[0] + nums[1]);
            }else if(token.equals("-")){
                int[] nums = getNum(stack);
                stack.push(nums[0] - nums[1]);
            }else if(token.equals("*")) {
                int[] nums = getNum(stack);
                stack.push(nums[0] * nums[1]);
            }else if(token.equals("/")){
                int[] nums = getNum(stack);
                stack.push(nums[0] / nums[1]);
            } else {
                stack.push(Integer.parseInt(token));
            }
        }

        return stack.pop();
    }

    private int[] getNum(Stack<Integer> stack) {
        int second = stack.pop();
        int first = stack.pop();
        return new int[]{first, second};
    }
}
