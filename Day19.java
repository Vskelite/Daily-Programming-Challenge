// Problem : Evaluate a Postfix Expression
// Given a postfix expression (also known as Reverse Polish Notation), your task is to evaluate the expression and return the result. The expression can contain integers and the four basic arithmetic operators +, -, *, and /. Assume that the input is always valid and the division operator performs integer division, truncating towards zero.

// Input : "2 1 + 3 *"

// Output : 9

import java.util.Stack;
import java.util.Scanner;

public class Day19{

    public static int evaluatePostfix(String str){
        Stack<Integer> stack = new Stack<>();

        String[] tokens = str.split(" ");

        for(String token : tokens){

            if(isNumeric(token)){
                stack.push(Integer.parseInt(token));
            }else{
                int operand2 = stack.pop();
                int operand1 = stack.pop();
                int result = 0;

                switch (token) {
                    case "+":
                        result = operand1 + operand2;
                        break;

                    case "-":
                        result = operand1 - operand2;
                        break;

                    case "*":
                        result = operand1 * operand2;
                        break;

                    case "/":
                        result = operand1 / operand2;
                        break;
                
                    default:
                        throw new IllegalArgumentException("Unknown oprator: " + token);
                }

                stack.push(result);
            }
        }
        return stack.pop();
    }

    public static boolean isNumeric(String str){
        try{
            Integer.parseInt(str);
            return true;
        }catch(NumberFormatException e){
            return false;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a postfix expression: ");
        String str = sc.nextLine();
        sc.close();
        System.out.println(evaluatePostfix(str));
    }
}