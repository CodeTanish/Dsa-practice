public class Search {
    public static void main(String [] arg){
        int [] arr = {3, 4, 6, 7, 9, 12, 16, 17};
        int target = 6;

        searchArray(arr, target);
    }

    static int searchArray(int [] arr, int target){
        int start = 0;
        int end = arr.length-1;
        int mid = 0;
        
        while(start < end){
            mid = (start + end)/2;

            if(arr[mid] > target) end = mid -1;
            else start = mid + 1;
        }
        return (arr[mid] == target) ? mid : -1;
    }

    static int lowwerBound(int [] arr, int target){
        int start = 0, end = arr.length-1, mid = 0;
 
        while (start <= end){
            mid = start + (end - start)/2;

            if (arr[mid] > target) end = mid - 1;
            else start = mid + 1;
        }

        return (arr[mid] >= target) ? mid : -1;
    }

    static int upperBound(int [] arr, int target){
        
        int start = 0, end = arr.length-1, mid = 0;
 
        while (start <= end){
            mid = start + (end - start)/2;

            if (arr[mid] > target) end = mid;
            else start = mid + 1;
        }

        return start;
    }
}