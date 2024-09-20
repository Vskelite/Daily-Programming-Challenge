// Problem : Valid Parentheses with Multiple Types
// You are given a string s consisting of different types of parentheses: (), {}, and []. Your task is to determine whether the given string is valid.

// Input : s = "[{()}]"

// Output : true
import java.util.Stack;

public class Day12{

    public static boolean isValid(String s){

        Stack<Character> stack = new Stack<>();

        for( char c : s.toCharArray()){
            if (c == '(' || c == '{' || c== '[') {
                stack.push(c);
            }
            else if( c == ')' || c == '}' || c == ']'){
                if(stack.isEmpty()){
                    return false;
                }

                char top = stack.pop();
                if ((c == ')' && top != '(') ||
                    (c == '}' && top != '{') ||
                    (c == ']' && top != '[')) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {
        
        System.out.println(isValid("([)"));
    }
}