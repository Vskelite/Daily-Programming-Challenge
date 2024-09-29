// Problem : Reverse a Stack Using Recursion
// You are given a stack of integers, and your task is to write a function that reverses the stack using recursion. You are not allowed to use any additional data structure (like arrays, lists, or another stack). The only operations you are allowed to perform are push, pop, and peek on the stack. The reversal must be done using recursion only.

// Input : [3, 1, 4, 2]

// Output : [2, 4, 1, 3]

import java.util.Stack;

public class Day21{
    public static void reverseStack(Stack<Integer> stack){
        if(stack.isEmpty()){
            return;
        }

        int top = stack.pop();

        reverseStack(stack);

        insertAtBottom(stack, top);
    }

    public static void insertAtBottom(Stack<Integer> stack, int value){
        if(stack.isEmpty()){
            stack.push(value);
            return;
        }

        int top = stack.pop();

        insertAtBottom(stack, value);

        stack.push(top);
    }
    public static void main(String[] args){
     Stack<Integer> stack = new Stack<>();
     stack.push(1);
     stack.push(2);
     stack.push(3);
     stack.push(4);
        System.out.println("Original stack: "+ stack);
     reverseStack(stack);
     System.out.println(stack);
    }
}