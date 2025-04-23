package Arrays.sorts;

public class ArraySorts {

    public static void main(String[] args) {

        int[] arr = {4, 2, 3, 1, 5, 8};

        selectionSort(arr);
    }

    static void swap(int[] arr, int left, int rigth) {
        int temp = arr[left];
        arr[left] = arr[rigth];
        arr[rigth] = temp;
    }

    static void display(int[] arr) {
        for (int val : arr) {
            System.out.print(val + " ");
        }
    }

    static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {

            int min = i;

            for (int j = i + 1; j < arr.length; j++) {
                if (arr[min] > arr[j]) {
                    min = j;
                }
            }

            if (min != i) {
                swap(arr, i, min);
            }
        }
    }

    static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length-1; j++) {
                if (arr[j] > arr[j+1]) {
                    swap(arr, i, j);
                }
            }
        }
    }
}
