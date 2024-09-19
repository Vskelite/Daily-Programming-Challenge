// Problem : Permutations of a String
// You are given a string s. Your task is to generate and return all possible permutations of the characters in the string. A permutation is a rearrangement of the characters in the string, and each character must appear exactly once in every permutation. If there are duplicate characters in the string, the resulting permutations should also be unique (i.e., no repeated permutations).

// Input : "abc"

// Output : ["abc", "acb", "bac", "bca", "cab", "cba"]

import java.util.*;

public class Day11{
    
    public static List<String> uniquePermutations(String s){
        List<String> result = new ArrayList<>();
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        boolean[] used = new boolean[chars.length];
        backtrack(result, new StringBuilder(), chars , used);
        return result;

    }

    public static void backtrack(List<String> result, StringBuilder current, char[] chars, boolean[] used){
        if (current.length() == chars.length) {
            result.add(current.toString());
            return;
        }

        for(int i = 0; i< chars.length; i++){
            if (used[i]) continue;

            if(i > 0 && chars[i] == chars[i - 1] && !used[i -1]) continue;

            current.append(chars[i]);
            used[i] = true;

            backtrack(result, current, chars, used);

            used[i] = false;
            current.deleteCharAt(current.length() - 1);
        }
    }
    public static void main(String[] args){
        String[] testCases = {"abc", "aab", "aaa", "a", "abcd"};
        for(String test : testCases){
            System.out.println("Input: "+ test);
            List<String> result = uniquePermutations(test);
            System.out.println("Output: " + result);
            System.out.println();
        }

    }
}