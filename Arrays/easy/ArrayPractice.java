package Arrays.easy;

public class ArrayPractice {
    public static void main(String[] args) {
        int[] arr1 = { 2, 5, 1, 3, 0 };

        // brutefindtheLargestElementFromArray(arr1);
        // betterfindtheLargestElementFromArray(arr1);

        // brutefindSecondLargestElement(arr1);
        // betterFindSecondLargestElement(arr1);
        brutecheckArrayIsSort(arr1);
    }

    static void swap(int[] arr, int left, int rigth) {
        int temp = arr[left];
        arr[left] = arr[rigth];
        arr[rigth] = temp;
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
    static boolean brutecheckArrayIsSort(int [] arr){
        for (int i=0; i<arr.length; i++){
            for (int j=i+1; j<arr.length; j++){
                if (arr[j] < arr[i]) {
                    return false;
                }
            }
        }
        return true;
    }
    static boolean bettercheckArrayIsSort(int [] arr){
        for (int i=1; i<arr.length; i++){
            if (arr[i] < arr[i-1]) {
                return false;
            }        
        }
        return true;
    }
}
