package org.hello.neetcode150.Valid_Palindrome;

public class Solution_v1 {
    public boolean isPalindrome(String s) {
        char[] arr = s.toLowerCase().toCharArray();

        int left = 0;
        int right = arr.length - 1;

        while(left < right) {

            boolean lvalue = check(arr[left]);
            boolean rvalue = check(arr[right]);

            if(lvalue && rvalue) {
                if(arr[left] != arr[right]) return false;
                left++;
                right--;
            }else if(!lvalue && rvalue) {
                left++;
            }else if(lvalue && !rvalue) {
                right--;
            }else {
                left++;
                right--;
            }
        }

        return true;
    }

    private boolean check(char c) {
        return Character.isAlphabetic(c) || Character.isDigit(c);
    }
}
