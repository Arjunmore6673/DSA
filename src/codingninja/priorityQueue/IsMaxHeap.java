package codingninja.priorityQueue;

public class IsMaxHeap {
    public static void main(String[] args) {
//        int[] A = {42 ,20, 18, 6, 14 ,11, 9, 4};
        int[] A = {10, 9, 8, 7, 6, 5, 4, 3, 2, 7};
        System.out.println(checkMaxHeap(A));
    }

//    int n = A.length;
//        for (int i = 0; i <= (A.length - 2) / 2; i++) {
//        if (A[i] > A[2 * i + 1] || (2 * i + 2 != A.length && A[i] > A[2 * i + 2])) {
//            return false;
//        }
//    }
//
//   return true;

    public static boolean checkMaxHeap(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < (n - 2) / 2; i++) {
            int leftIndex = (2 * i) + 1;
            int rightIndex = (2 * i) + 2;
            if (arr[leftIndex] < arr[i]) {
                return false;
            }
            if (rightIndex < n && arr[rightIndex] < arr[i]) {
                return false;
            }
        }
        return true;
    }
}
