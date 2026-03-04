package org.hello.neetcode.Valid_Parentheses;

import java.util.List;
import java.util.Stack;

public class Solution_V1 {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack();

        if(s.length() == 1 && List.of(")","}","]").contains(s)) {
            return false;
        }

        for(char c: s.toCharArray()) {
            if(stack.isEmpty()) {
                stack.push(c);
            }else {
                if(c == ')') {
                    if(stack.peek() != '(') return false;
                    stack.pop();
                }else if(c == '}') {
                    if(stack.peek() != '{') return false;
                    stack.pop();
                }else if(c == ']'){
                    if(stack.peek() != '[') return false;
                    stack.pop();
                }else {
                    stack.push(c);
                }
            }
        }

        if(stack.isEmpty()) return true;
        return false;
    }
}
