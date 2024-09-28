// Problem : Sort a Stack Using Recursion
// Given a stack of integers, your task is to write a function that sorts the stack in ascending order. You are not allowed to use any additional data structure like arrays, lists, or another stack. The only operations you are allowed to perform are push, pop, and peek on the stack. The sorting must be performed using recursion only.

// Input : [3, 1, 4, 2]

// Output : [1, 2, 3, 4]

import java.util.Stack;

public class Day20{
     public static void sortStack(Stack<Integer> stack){
        if(stack.isEmpty()){
            return;
        }

        int top = stack.pop();

        sortStack(stack);

        insertInSortedOrder(stack, top);
     }

     private static void insertInSortedOrder(Stack<Integer> stack, int element){
        if (stack.isEmpty() || stack.peek() <= element) {
            stack.push(element);
            return;
        }

        int top = stack.pop();
        insertInSortedOrder(stack, element);

        stack.push(top);
     }
    public static void main(String[] args){
     Stack<Integer> stack = new Stack<>();
     stack.push(-3);
     stack.push(14);
     stack.push(8);
     stack.push(2);
     sortStack(stack);
     System.out.println(stack);

    }
}