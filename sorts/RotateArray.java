import java.util.Arrays;

public class RotateArray {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        leftRotate(arr, 5, 2);
        System.out.println(Arrays.toString(arr));
        rightRotate(arr, 2);
        System.out.println(Arrays.toString(arr));
    }

    private static void rev(int[] arr, int i, int j) {
        while (i <= j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
    }

    private static void leftRotate(int[] arr, int n, int d) {
        rev(arr, 0, d - 1);
        rev(arr, d, n - 1);
        rev(arr, 0, n - 1);
    }

    // Right Rotate an array by d elements
    static void rightRotate(int[] arr, int d) {
    int n = arr.length;

    for (int k = 0; k < d; k++) {

        int last = arr[n - 1];

        for (int i = n - 1; i > 0; i--) {
            arr[i] = arr[i - 1];
        }

        arr[0] = last;
    }
}
}
