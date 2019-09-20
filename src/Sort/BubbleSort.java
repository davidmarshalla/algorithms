package Sort;

import java.awt.*;

public class BubbleSort {
    public static void bubbleSort(int[] arr) {
        //外循环,执行n-1次
        for (int i = arr.length - 1; i > 0; i--) {
            //内循环，执行i次
            for (int j = 0; j < i; j++) {
                if(arr[j]>arr[j+1]){
                    swap(arr,j,j+1);
                }
            }
        }
    }

    private static void swap(int[] arr,int i,int j){
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }

    Color c1 = new Color(17,6,4);
}
