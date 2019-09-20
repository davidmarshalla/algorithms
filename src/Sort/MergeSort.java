package Sort;

import java.util.Arrays;

public class MergeSort {
    public static void mergeSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        mergeSort(arr, 0, arr.length - 1);
    }

    private static void mergeSort(int[] arr, int l, int r) {
        if (l == r) {
            return;
        }
        int mid = l + ((r - l) >> 1);
        mergeSort(arr, l, mid);
        mergeSort(arr, mid + 1, r);
        merge(arr, l, mid, r);

    }

    private static void merge(int[] arr, int l, int mid, int r) {
        int[] tmp = new int[r - l + 1];
        int i = l;
        int j = mid + 1;
        int k = 0;
        while (i <= mid && j <= r) {
            tmp[k++] = arr[i] > arr[j] ? arr[j++] : arr[i++];
        }
        while (i <= mid) {
            tmp[k++] = arr[i++];
        }
        while (j <= r) {
            tmp[k++] = arr[j++];
        }

        for (i = 0; i < tmp.length; i++) {
            arr[l + i] = tmp[i];
        }
    }


    public static void main(String[] args) {
        int[] arr = {2, 1, 8, 6, 0, 3, 7, 4};
        mergeSort(arr);
        System.out.println(Arrays.toString(arr));

    }


}
