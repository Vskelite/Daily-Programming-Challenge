import java.util.Scanner;
public class Day8{
     
    public static String reverseWords(String s){

        char[] str = s.toCharArray();
        int n = str.length;

        reverse( str, 0, n - 1);

        reverseEachWord(str, n);

        return cleanSpaces(str, n);
    }

    static void reverse(char[] str, int left, int right){
        while (left < right) {
            char temp = str[left];
            str[left] = str[right];
            str[right] = temp;
            left++;
            right--;
        }
    }

    static void reverseEachWord(char[] str, int n){
        int start = 0, end = 0;

        while (start < n) {
            while (start < end || (start < n && str[start] == ' ')) {
                start++;
            }
            while (end < start  || (end < n && str[end] != ' ') ){
                end++;
            }
            reverse(str, start, end -1);
        }
    }

    static String cleanSpaces(char[] str, int n){
        int i = 0, j = 0;

        while (j < n) {
            while (j < n && str[j] == ' ') {
                j++;
            }
            while (j < n && str[j] != ' ') {
                str[i++] = str[j++];
            }
            while (j < n && str[j] != ' ') {
                j++;
            }

            if (j < n) {
                str[i++] = ' ';
            }
        }
        return new String(str).substring(0, i);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a string: ");
        String s = sc.nextLine();
        sc.close(); 
        System.out.println(reverseWords(s));
    }
}