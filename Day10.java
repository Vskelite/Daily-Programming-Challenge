// Problem : Group Anagrams
// You are given an array of strings strs[]. Your task is to group all the strings that are anagrams of each other. An anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.

// Input :
// strs[] = ["eat", "tea", "tan", "ate", "nat", "bat"]

// Output :
// [["eat", "tea", "ate"], ["tan", "nat"], ["bat"]]

import java.util.*;
public class Day10 {
    
    public static List<List<String>> groupAnagrams(String[] strs){
        Map<String, List<String>> anagramMap = new HashMap<>();

        for(String str : strs){
            int[] charCount = new int[26];
            for(char c : str.toCharArray()){
                charCount[c - 'a']++;
            }

            StringBuilder keyBuilder = new StringBuilder();
            for(int count :charCount){
                keyBuilder.append('#').append(count);
            }
            String key = keyBuilder.toString();

            anagramMap.putIfAbsent(key, new ArrayList<>());

            anagramMap.get(key).add(str);
        }

        return new ArrayList<>(anagramMap.values());
    }
    public static void main(String[] args){

        String[] strs = { "abc", "bca", "cab", "xyz", "zyx", "yxz"};
        System.out.println(groupAnagrams(strs));
    }
}
