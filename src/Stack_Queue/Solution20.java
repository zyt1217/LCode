package Stack_Queue;

import java.util.Stack;

public class Solution20 {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(char c : s.toCharArray()){
            if (c - '(' == 0 || c - '[' == 0 || c - '{' == 0)
                stack.push(c);
            if( c - ')' == 0)
                if(!stack.isEmpty() && stack.peek() - '(' == 0) {
                    stack.pop();
                    continue;
                }
                else return false;
            if(c - ']' == 0)
                if(!stack.isEmpty() && stack.peek() - '[' == 0) {
                    stack.pop();
                    continue;
                }
                else return false;
            if(c - '}' == 0)
                if (!stack.isEmpty() && stack.peek() - '{' == 0)
                    stack.pop();
                else return false;
        }
        return stack.isEmpty();
    }
}
