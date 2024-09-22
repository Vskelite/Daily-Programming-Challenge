// Problem : Count Substrings with Exactly K Distinct Characters
// You are given a string s of lowercase English alphabets and an integer k. Your task is to count all possible substrings of s that contain exactly k distinct characters.

// Input : s = "pqpqs", k = 2

// Output : 7

import java.util.HashMap;
import java.util.Map;

public class Day14 {
    public static int countSubstringsWithKDistinct(String s, int k) {
        if (s == null || s.length() == 0 || k == 0) {
            return 0;
        }
        
        return atMostKDistinct(s, k) - atMostKDistinct(s, k - 1);
    }

   
    private static int atMostKDistinct(String s, int k) {
        Map<Character, Integer> charCount = new HashMap<>();
        int left = 0, result = 0;

        for (int right = 0; right < s.length(); right++) {
            char rightChar = s.charAt(right);
            charCount.put(rightChar, charCount.getOrDefault(rightChar, 0) + 1);

            while (charCount.size() > k) {
                char leftChar = s.charAt(left);
                charCount.put(leftChar, charCount.get(leftChar) - 1);
                if (charCount.get(leftChar) == 0) {
                    charCount.remove(leftChar);
                }
                left++;
            }
            
           
            result += right - left + 1;
        }

        return result;
    }

    public static void main(String[] args) {
       
        System.out.println(countSubstringsWithKDistinct("pqpqs", 2));  
        System.out.println(countSubstringsWithKDistinct("aabacbebebe", 3)); 
        
    }
}