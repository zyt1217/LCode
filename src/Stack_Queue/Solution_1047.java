package Stack_Queue;

import java.util.Arrays;
import java.util.Stack;

public class Solution_1047 {
    public String removeDuplicates(String s) {
        Stack<Character> stack = new Stack<>();
        for(char c : s.toCharArray()){
            if(stack.isEmpty()){
                stack.push(c);
                continue;
            }
            if(stack.peek() == c){
                stack.pop();
            }else stack.push(c);
        }
        StringBuilder res = new StringBuilder();
        for(char c: stack){
            res.append(c);
        }
        return res.toString();
    }
}
