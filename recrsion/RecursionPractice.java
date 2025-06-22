package recrsion;

public class RecursionPractice {
    public static void main(String[] args) {
        
        System.out.println(factorial(5));
        System.out.println(sum_of_digit(1234));
    }

    static int factorial(int n){
        
        if (n == 1 || n == 0) return 1;

        return n * factorial(n-1);
    }

    static int sum_of_digit(int n){
        if (n < 0) return 0;

        return n%10 + sum_of_digit(n/10);
    }

    static String reveString(String str, int index, String result){

        if (index == str.length()) return result;

        reveString(str, index+1, result);
        return result + str.charAt(index); 
    }

    static boolean palindrome(String str, int index, String result){

        if (index == str.length()) return false;

        reveString(str, index+1, result);
        result = (String) result + str.charAt(index);
        return (str == result)? true : false; 
    }

    static int count_of_digit(int n, int count){
        if (n < 0) return count;

        sum_of_digit(n/10);
        return count++;
    }

    
}
