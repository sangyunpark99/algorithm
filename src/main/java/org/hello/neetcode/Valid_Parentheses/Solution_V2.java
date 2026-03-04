package org.hello.neetcode.Valid_Parentheses;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class Solution_V2 {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack();
        Map<Character, Character> bracketPair = new HashMap<>();

        if(s.length() == 1 && List.of(")","}","]").contains(s)) {
            return false;
        }

        bracketPair.put(')', '(');
        bracketPair.put('}', '{');
        bracketPair.put(']','[');

        for(char c: s.toCharArray()) {
            if(stack.isEmpty()) {
                if(bracketPair.containsKey(c)) {
                    return false;
                }
                stack.push(c);
            }else {
                if(bracketPair.containsKey(c) && stack.peek() == bracketPair.get(c)) {
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
