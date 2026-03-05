package org.hello.neetcode150.Two_Integer_Sum_II;

public class Solution_v1 {
    public int[] twoSum(int[] numbers, int target) {
        // O(1)

        int left = 0;
        int right = numbers.length - 1;

        while(left < right) {
            int sum = numbers[left] + numbers[right];
            if(sum == target) {
                return new int[]{left + 1, right + 1};
            }else if(sum > target){
                right--;
            }else {
                left++;
            }
        }

        return new int[]{};
    }
}
