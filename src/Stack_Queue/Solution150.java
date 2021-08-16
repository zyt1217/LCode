package Stack_Queue;

import java.util.Stack;

public class Solution150 {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for(String tks : tokens){
            if(tks.equals("+")){
                int push = stack.pop() + stack.pop();
                stack.push(push);
                continue;
            }
            if(tks.equals("-")){
                int push = -(stack.pop() - stack.pop());
                stack.push(push);
                continue;
            }
            if(tks.equals("*")){
                int push = stack.pop() * stack.pop();
                stack.push(push);
                continue;
            }
            if(tks.equals("/")){
                int last = stack.pop();
                int first = stack.pop();
                int push = first / last;
                stack.push(push);
                continue;
            }
            stack.push(Integer.parseInt(tks));
        }
        return stack.pop();
    }
}
