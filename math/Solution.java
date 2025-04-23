
class Solution {

    public static void main (String [] arg){
        
        int n = 12345;
        System.out.println(countNOfDigit(n));
        System.out.println(optimalCountNOfDigit(n));
        System.out.println(reverseOfNumber(n));
        System.out.println(paindrome(n));
    }

    static int countNOfDigit(int n){
        int count = 0;

        while(n>0){
            count += 1;
            n /= 10;
        }
        return count;
    }

    static int optimalCountNOfDigit(int n){
        
        int output = (int) Math.log10(n) + 1;
        return output;
    }

    static int reverseOfNumber (int n){
        int revNumber = 0;

        while (n>0){
            revNumber = revNumber * 10 + n%10;

            n /= 10;
        }
        return revNumber;
    }
    static boolean paindrome(int n){
        String chr = Integer.toString(n);
        int start = 0, end = chr.length()-1;
        while (start <= end){
            if(chr.charAt(start) != chr.charAt(end)){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}