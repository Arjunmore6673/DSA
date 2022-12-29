package youtube;

public class BinarySearch {

    public int searchElement(int[] list, int target) {
        int start = 0;
        int end = list.length - 1;
        boolean isAsc = list[start] < list[end];
        while (start <= end) {
            int mid = (start + end) / 2;
            if (list[mid] == target)
                return mid;
            if (isAsc) {
                if (target > list[mid])
                    start = mid + 1;
                if (target < list[mid])
                    end = mid - 1;
            } else {
                if (target < list[mid])
                    start = mid + 1;
                if (target > list[mid])
                    end = mid - 1;
            }
        }
        return -1;
    }

    private int[] firstAndLast(int[] list, int target) {
        return new int[]{search(list, target, true), search(list, target, false)};
    }

    private int search(int[] list, int target, boolean startIndex) {
        int start = 0;
        int end = list.length - 1;
        int ans = -1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (target > list[mid])
                start = mid + 1;
            else if (target < list[mid])
                end = mid - 1;
            else {
                ans = mid;
                if (startIndex) end = mid - 1;
                else start = mid + 1;
            }
        }
        return ans;
    }


    private void searchWithoutArrayLength(int[] list, int target) {
        int start = 0;
        int end = 1;
        while (target > list[end]) {
            int newStart = end + 1;
            end = end + (end - start + 1) * 2;
            start = newStart;
        }

        System.out.println(searchAns(list, target, start, end));
        ;
    }

    private int searchAns(int[] list, int target, int start, int end) {
        int ans = -1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (target > list[mid])
                start = mid + 1;
            else if (target < list[mid])
                end = mid - 1;
            else {
                return mid;
            }
        }
        return -1;
    }


    private int peakMountain(int[] list) {
        int start = 0;
        int end = list.length - 1;
        while (start < end) {
            int mid = (start + end) / 2;
            if (list[mid] > list[mid + 1]) end = mid;
            else start = mid + 1;
        }
        return list[start];
    }

    public static void main(String[] args) {
        int[] list = {1, 2, 3, 4, 5, 6, 5, 2, 1};
        BinarySearch binarySearch = new BinarySearch();
//        System.out.println(Arrays.toString(binarySearch.firstAndLast(list, 3)));
//        binarySearch.searchWithoutArrayLength(list, 23);
        System.out.println(binarySearch.peakMountain(list));
        ;
    }


}
