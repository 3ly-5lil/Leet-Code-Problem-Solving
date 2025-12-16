package stack;

import java.util.HashMap;
import java.util.Stack;

public class ValidParentheses_20 {
    class Solution {
        // more clean
        public boolean isValid(String s) {
            Stack<Character> stack = new Stack<>();

            HashMap<Character, Character> mapping = new HashMap<>(3);
            mapping.put(')', '(');
            mapping.put(']', '[');
            mapping.put('}', '{');

            for (char c : s.toCharArray()) {
                Character v = mapping.get(c);

                if (v == null) {
                    stack.add(c);
                    continue;
                }

                if (stack.isEmpty() || stack.pop() != v)
                    return false;
            }

            return stack.isEmpty();
        }

        // more efficient
        public boolean isValid1(String s) {
            Stack<Character> stack = new Stack<>();

            for (char c : s.toCharArray()) {
                if (!stack.isEmpty()) {
                    switch (c) {
                        case ')':
                            if (stack.pop() != '(')
                                return false;
                            continue;

                        case ']':
                            if (stack.pop() != '[')
                                return false;
                            continue;

                        case '}':
                            if (stack.pop() != '{')
                                return false;
                            continue;
                    }
                }

                stack.add(c);
            }

            return stack.isEmpty();
        }
    }
}
