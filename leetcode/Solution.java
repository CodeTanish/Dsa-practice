package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

public class Solution {
    public static void main(String[] args) {

        int [] arr = {2,7,11,15};
        int target = 9;
        two_sum(arr, target);
    }

    static int [] two_sum(int [] arr, int target){

        for (int i=0; i<arr.length; i++){
            for(int j = i+1; j< arr.length; j++){
                if (arr[i] + arr[j] == target) return new int[] {i, j};
            }
        }

        return new int[]{-1, -1};
    }

    static int [] optimized_two_sum(int [] arr, int target){

        HashMap<Integer, Integer> complement = new HashMap<>();

        for(int i = 0; i< arr.length; i++){
            int result = target - arr[i];

            if (complement.containsKey(result)){
                return new int[] {complement.get(complement), i};
            }

            complement.put(arr[i], i);
        }

        return new int[] {-1, -1};
    }

    static void remove_duplicated(int [] arr){
        int index = 0;

        for(int j=0; j<arr.length; j++){
            if (arr[index] != arr[j]) {
                arr[index+1] = arr[j];
                index++;
            }
        }
    }

    static boolean valid_parentheses(String str) {

        Stack <Character> check = new Stack<>();
        for (char i: str.toCharArray()){
            if (str.charAt(i) == str.charAt(i+1)) check.push(str.charAt(i));
            else check.pop();
        }

        return check.isEmpty();
    }

//    static void daily_Temperature(int [] arr){
//
//        int count = 0, index = 0;
//        ArrayList <Integer> output = new ArrayList<>();
//
//        for(int i=0; i<arr.length; i++){
//
//            if (i == arr.length-1) output.add(0);
//            if (arr[index] < arr[i]) count++;
//            if (arr[index] > arr[i]) {
//                output.add(count);
//                index++;
//                count = 0;
//            }
//        }
//
//        System.out.println(output);
//    }

    static void reverse_list (){

    }
}
