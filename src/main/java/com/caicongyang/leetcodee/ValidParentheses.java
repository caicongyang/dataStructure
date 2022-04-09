package com.caicongyang.leetcodee;

import java.util.*;

public class ValidParentheses {



    public static boolean isValid(String s) {
        if (s == null || s.length() == 0) {
            return false;
        }
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else {
                //第一次入账的必须是前面的字符串
                if (stack.isEmpty()) {
                    return false;
                }
                char top = stack.pop();
                if (c == ')' && top != '(') {
                    return false;
                }
                if (c == '}' && top != '{') {
                    return false;
                }
                if (c == ']' && top != '[') {
                    return false;
                }
            }
        }
        return stack.isEmpty();

    }


    public static void main(String[] args) {
        boolean valid = isValid("{{()}}[]");
        System.out.println(valid);

        boolean valid2 = isValid("{{()}}[]()[[])");
        System.out.println(valid2);
    }

}
