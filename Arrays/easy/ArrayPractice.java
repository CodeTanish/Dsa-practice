package Arrays.easy;

import java.util.*;

public class ArrayPractice {
    public static void main(String[] args) {

        // int [] arr1 = {2, 5, 1, 3, 0};
        // int [] arr2 = {1,1,2,2,2,3,3,3,3};
        // int [] arr3 = {2,0,3,0,1,1,0,4,0};
        int [] arr4 = {1,1,0,0,0,1,1,1,1,1};

        // brutefindtheLargestElementFromArray(arr1);
        // betterfindtheLargestElementFromArray(arr1);

        // brutefindSecondLargestElement(arr1);
        // betterFindSecondLargestElement(arr1);

        // bruteCheckArrayIsSort(arr2);
        // betterCheckArrayIsSort(arr2);

        // rotateArrayByOnePlace(arr1);
        // bruteMoveZeroToLast(arr3);
        int [] arr5 = {1,1,2};
        System.out.println(mostOptimalSolutionRemoveDuplicate(arr5));
        // System.out.println(maxConsecutiveOnes(arr4));
    }

    static void swap(int[] arr, int left, int rigth) {
        int temp = arr[left];
        arr[left] = arr[rigth];
        arr[rigth] = temp;
    }

    static void display (int [] arr){
        for (int val: arr){
            System.out.print(val+ " ");
        }
    }

    static int search(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) { 
            if (arr[i] == target) { 
                return i;  
            }
        }
        return -1; 
    }
    

    static void brutefindtheLargestElementFromArray(int[] arr) {

        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[i])
                    swap(arr, i, j);
            }
        }

        System.out.println(arr[arr.length - 1]);
    }

    static void betterfindtheLargestElementFromArray(int[] arr) {
        int largest = arr[0];

        for (int i = 1; i < arr.length; i++) {
            if (largest < arr[i]) {
                largest = arr[i];
            }
        }
        System.out.println(largest);
    }

    static void brutefindSecondLargestElement(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[i])
                    swap(arr, i, j);
            }
        }

        System.out.println(arr[arr.length - 2]);
    }

    static void betterFindSecondLargestElement(int[] arr) {
        int largest = Integer.MIN_VALUE;
        int sLargest = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > largest) {
                sLargest = largest;
                largest = arr[i];
            } else if (arr[i] > sLargest && arr[i] != largest) {
                sLargest = arr[i];
            }
        }
        System.out.println(sLargest);
    }
    
    static boolean bruteCheckArrayIsSort(int [] arr){
        for (int i=0; i<arr.length; i++){
            for (int j=i+1; j<arr.length; j++){
                if (arr[j] < arr[i]) {
                    return false;
                }
            }
        }
        return true;
    }
    
    static boolean betterCheckArrayIsSort(int [] arr){
        for (int i=1; i<arr.length; i++){
            if (arr[i] < arr[i-1]) {
                return false;
            }        
        }
        return true;
    }
    
    //leetcode question
    static boolean betterCheckArrayIsSortAndRotated(int [] arr){  
        int count = 0; 

        for(int i = 0; i< arr.length-1; i++){
            if(arr[i]>arr[i+1]){
                count++;
            }
        }

        if(arr[0]<arr[arr.length-1]){
            count++;
        }

        return count <=1;
    }

    static ArrayList<Integer> bruteRemoveDuplicate(int[] arr) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            boolean isDuplicate = false;
            for (int j = 0; j < i; j++) {
                if (arr[i] == arr[j]) {
                    isDuplicate = true;
                    break;
                }
            }
            if (!isDuplicate) {
                list.add(arr[i]);
            }
        }
        return list;
    }

    static ArrayList<Integer> betterRemoveDuplicate(int[] arr) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int value : arr) {
            if (!list.contains(value)) {
                list.add(value);
            }
        }
        return list;
    }
  
    static int mostOptimalSolutionRemoveDuplicate (int [] arr){
        int i = 0;
        for(int j = 0; j<arr.length; j++){
            if(arr[i] != arr[j]){
                i++;
                arr[i] = arr[j];
            }
        }
        return i+1;
    } 
    
    static List<Integer> optimalRemoveDuplicate(int[] arr) {
        HashSet<Integer> set = new HashSet<>();
        for (int value : arr) {
            set.add(value);
        }
        return new ArrayList<>(set);    
    }

    static int bruteFindTheNumberWhichOccuredMost (int [] arr){

        int max = Integer.MIN_VALUE;

        for(int val: arr){
            if(val > max) max = val;
        }

        int [] count = new int[max+1]; 
        for (int i = 0; i < arr.length; i++) {
           count[arr[i]] += 1;
        }

        int maxCount = 0, frequency = -1;
        for (int i = 0; i < count.length; i++) {
            if (count[i] > maxCount) {
                maxCount = count[i];
                frequency = i;
            }
        }
        return frequency;
    }

    static int optimalFindMaxhichOccuredMost(int [] arr){

        int frequency = 0, maxValue = arr[0];

        HashMap <Integer, Integer> map = new HashMap<>();

        for (int val: arr) {
            map.put(val, map.getOrDefault(val, 0)+1);
        }

        for (Map.Entry <Integer, Integer> entry : map.entrySet()){
            if (entry.getValue() > maxValue) {
                maxValue = entry.getValue();
                frequency = entry.getKey();
            }
        }

        return frequency;
    }

    static void rotateArrayByOnePlace (int [] arr){

        int temp = arr[0];

        for (int i=1; i<arr.length; i++){
            arr[i-1] = arr[i];
        }
        arr[arr.length - 1] = temp;

        display(arr);
    }

    static void bruteMoveZeroToLast(int [] arr){
        int count = 0, j = 0;
        for (int val: arr){
            if (val == 0) {
                count++;
            }
        }
        int [] newArray = new int[arr.length]; 

        for(int i = 0; i<arr.length; i++){
            if (arr[i] != 0) {
                newArray[j] = arr[i];
                j++;
            }
        }

        for (int k = arr.length - count; k<newArray.length; k++){
            newArray[k] = 0;
        }

        display(newArray);

    }
    
    static void moveZeroToLast(int [] arr){
        int index = 0;
        for (int i=0; i<arr.length-1; i++){
            if (arr[i] != 0){
                swap(arr, i, index);
                index++;
            }
        }

        display(arr);
    }

    static ArrayList<Integer> unionOfSortedElement(int [] arr1, int [] arr2){

        int size1 = arr1.length, size2 = arr2.length, i=0, j=0;

        ArrayList<Integer> list = new ArrayList<>();

        while (i < size1 && j < size2){
            if (arr1[i] <= arr2[j]) {
                if (list.size() == 0 || list.get(list.size()-1) != arr1[i]) {
                    list.add(arr1[i]);
                    i++;
                }else {
                    if (list.size() == 0 || list.get(list.size()-1) != arr1[j]) {
                        list.add(arr2[j]);
                        j++;
                    }
                }
            }
        }
        while (i < size1) {
            if (list.get(list.size()-1) != arr1[i]) {
                list.add(arr1[i]);
                i++;
            }
        }
        while (j < size2) {
            if (list.get(list.size()-1) != arr2[j]) {
                list.add(arr2[j]);
                j++;
            }
        }

        return list;
    }

    static int maxConsecutiveOnes (int [] arr){

        int count = 0, prevCount = 0;

        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == 1){
                count++;
                prevCount = Math.max(prevCount, count);
            } 
            else {
                count = 0;
            }
        }

        return prevCount;
    }

    //need to fix logic of this code 
    // static int longestSubarray(int [] arr, int target){
        
    //     ArrayList<Integer> list = new ArrayList<>();
        
    //     for(int i=0; i<arr.length-1; i++){
    //         for(int j = 0; j<arr.length - 1; j++){
    //             if (target != arr[i] + arr[j]) list.add(arr[j]);
    //         }
    //     }
    //     int length = list.size();
    //     return length;
    // }

    static int majorityElement (int [] arr){
        
        int max = arr[0];

        for (int val : arr){
            if(max < val) max = val;
        }

        int [] count = new int[max+1];

        for(int val: arr){
            count[val]++;
        }

        for (int i = 0; i < count.length; i++) {
            if (count[i] > arr.length / 2) {
                return i;
            }
        }
        return -1;
    }

    static int stockBuyAndSell(int [] arr){

        int min = Integer.MAX_VALUE;
        int maxProfit = 0;

        for (int price : arr){
            if (price < min){
                min = price;
            }else if (price - min > maxProfit){
                maxProfit = price - min;
            }
        }

        return maxProfit;
    }

    static int optimalStockBuyAndSell (int [] arr){

        int maxProfit = 0, min = Integer.MAX_VALUE;
        for (int price : arr){
            min = Math.min(min, price);
            maxProfit = Math.max(maxProfit, price - min);
        }
        return maxProfit;
    }

    static void sortZerosOnesAndTwos(int [] arr){
        int count_0 = 0, count_1 = 0, count_2 = 0;
        for (int val: arr){
            if(val == 0)count_0++;
            if(val == 1)count_1++;
            if(val == 2)count_2++;
        }

        for(int i = 0; i<count_0; i++){
            arr[i] = 0;
        }
        for(int i = count_0; i<count_1; i++){
            arr[i] = 0;
        }
        for(int i = count_0 + count_1; i<count_2; i++){
            arr[i] = 0;
        }
    }
}