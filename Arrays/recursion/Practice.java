class practice {
    public static void main(String[] args) {
        int [] arr = {2,3,5,1,9}; 
        int target = 10;

        longestSubArraySum(arr, target, 0, 0, 0);
    }

    static int search(int [] arr, int target, int start, int end){
        int mid = (start + end)/2;
        
        if(start > end) {
            return -1;
        }

        if (arr[mid] > target) {
            return search(arr, target, start, mid - 1);
        }else return search(arr, target, mid + 1, end);
    }

    static int longestSubArraySum(int[] arr, int target, int index, int sum, int length) {
        if (index == arr.length) {
            return (sum == target) ? length : 0;
        }
    
        sum += arr[index];
        length++;
    
        int currentLength = (sum == target) ? length : 0;
        int nextLength = longestSubArraySum(arr, target, index + 1, sum, length);
    
        return Math.max(currentLength, nextLength);
    }    
}