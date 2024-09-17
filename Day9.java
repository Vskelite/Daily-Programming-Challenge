// Problem : Longest Common Prefix
// You are given an array of strings strs[], consisting of lowercase letters. Your task is to find the longest common prefix shared among all the strings. If there is no common prefix, return an empty string "".

// Input :
// An array of strings strs[] where each string consists of lowercase English letters.
// Example: strs[] = ["flower", "flow", "flight"]

// Output :
// * A string representing the longest common prefix. If no common prefix exists, return an empty string "".
// Example: "fl"

public class Day9{
    
    public static String findPrefix(String[] str){

        if(str == null || str.length == 0){
            return "";
        }

        for(int i = 0; i < str[0].length(); i++){

            char c = str[0].charAt(i);

            for(int j = 1; j < str.length; j++){

                if( i >= str[j].length() || str[j].charAt(i) != c){
                    return str[0].substring(0, i);
                }
            }
        }

        return str[0];
    }
    public static void main(String[] args) {
        
        String[] str = {"flower", "flow", "flight"};
        System.out.println("Longest common prefix: "+ findPrefix(str));
    }
}