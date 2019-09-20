package StringAlo;

public class BFPRT {
    public static int[] FindMinKthNumsByBFPRT(int[] arr, int k) {
        if (k < 1 || k > arr.length) {
            return arr;
        }

        int[] res = new int[k];
        int minKth = FindMinKthNum(arr, k);
        int index = 0;
        for (int i = 0; i != arr.length; i++) {
            if (arr[i] < minKth) {
                res[index++] = arr[i];
            }
        }

        for (; index != res.length; index++) {
            res[index] = minKth;
        }
        return res;
    }

    public static int FindMinKthNum(int[] arr, int k) {
        int[] copy = copyArray(arr);
        return select(copy, 0, arr.length - 1, k - 1);
    }

    //要保留原数组，又要对新数组做修改,要做partition
    private static int[] copyArray(int[] arr) {
        int[] res = new int[arr.length];
        for (int i = 0; i != arr.length; i++) {
            res[i] = arr[i];
        }
        return res;
    }

    //在begin和end之间找比i大的数
    private static int select(int[] arr, int begin, int end, int i) {
        if (begin == end) {
            return arr[begin];
        }
        int pivot = medianOfMedians(arr, begin, end);
        int[] pivotRange = partition(arr, begin, end, pivot);
        if (i >= pivotRange[0] && i <= pivotRange[1]) {
            return arr[i];
        } else if (i < pivotRange[0]) {
            return select(arr, begin, pivotRange[0] - 1, i);
        } else {
            return select(arr, pivotRange[1] + 1, end, i);
        }
    }

    private static int medianOfMedians(int[] arr, int begin, int end) {
        int num = end - begin + 1;
        int offset = num % 5 == 0 ? 0 : 1;
        int[] new_arr = new int[num / 5 + offset];
        for (int i = 0; i < new_arr.length; i++) {
            int beginI = begin + i * 5;
            int endI = beginI + 4;
            new_arr[i] = getMedian(arr, beginI, Math.min(endI, end));
        }
        return select(new_arr, 0, new_arr.length - 1, new_arr.length / 2);

    }

    private static int[] partition(int[] arr, int begin, int end, int pivot) {
        int less = begin - 1;
        int more = end + 1;
        int cur = begin;
        while (cur < more) {
            if (arr[cur] < pivot) {
                swap(arr, cur++, ++less);
            } else if (arr[cur] > pivot) {
                swap(arr, cur, --more);
            } else {
                cur++;
            }
        }
        return new int[]{less, more};
    }

    private static int getMedian(int[] arr, int begin, int end) {
        insertionSort(arr, begin, end);
        int sum = end + begin;
        int mid = (sum / 2) + sum % 2;
        return mid;
    }

    //    private static void insertionSort(int[] arr, int begin, int end) {
//        for (int i = begin + 1; i != end + 1; i++) {
//            for (int j = i; j != begin; j--) {
//                if (arr[j - 1] > arr[j]) {
//                    swap(arr, j - 1, j);
//                } else {
//                    break;
//                }
//            }
//        }
//    }
    public static void insertionSort(int[] arr, int begin, int end) {
        for (int i = begin + 1; i != end + 1; i++) {
            for (int j = i; j != begin; j--) {
                if (arr[j - 1] > arr[j]) {
                    swap(arr, j - 1, j);
                } else {
                    break;
                }
            }
        }
    }

    private static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
        int[] arr = {6, 9, 1, 3, 1, 2, 2, 5, 6, 1, 3, 5, 9, 7, 2, 5, 6, 1, 9};
        // sorted : { 1, 1, 1, 1, 2, 2, 2, 3, 3, 5, 5, 5, 6, 6, 6, 7, 9, 9, 9 }

        printArray(FindMinKthNumsByBFPRT(arr, 10));
    }
}
