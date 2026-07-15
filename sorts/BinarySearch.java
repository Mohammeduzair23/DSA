public class BinarySearch {
    public static void main(String[] args) {
        int arr[] = {1,2,3,4,5,6,7,8,9};
        System.out.println(binarySearch(arr, 3));
        // System.out.println(binarySearch(new arr[] {1,2,3,4,5,6,7,8,9}, 0));
    }

    private static int binarySearch(int[] arr, int x) {
        int l = 0;
        int r = arr.length - 1;
        
        while(l <= r) {
            int mid = (l + r) / 2;
            if (arr[mid] == x) {
                return mid;
            } else if (x < arr[mid]) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return 1;
    }
}
