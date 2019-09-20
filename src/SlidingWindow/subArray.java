package SlidingWindow;

import java.util.LinkedList;

/**
 * 找到数组中满足最大值减最小值小于等于num的全部子数组，时间复杂度为O（N）
 */
public class subArray {
    public static int getSubArray(int[] arr, int num) {
        //判断输入是否合理
        if (arr == null || arr.length < 1 || num < 1) {
            return 0;
        }
        //创建最大最小双端队列
        LinkedList<Integer> qmin = new LinkedList<>();
        LinkedList<Integer> qmax = new LinkedList<>();
        //创建窗口，创建返回值
        int i = 0;
        int j = 0;
        int res = 0;
        //窗口从零开始扩张，外循环i从0开始，内循环j从i开始
        while (i < arr.length) {
            while (j < arr.length) {
                //最小双端队列：如果队列不为空并且队列尾节点大于等于当前值，弹出尾节点
                //当前值从尾节点进入
                while (!qmin.isEmpty() && arr[qmin.peekLast()] >= arr[i]) {
                    qmin.pollLast();
                }
                qmin.addLast(i);
                //最大双端队列：如果队列不为空并且队列尾节点小于等于当前值，弹出尾节点
                //当前值从尾节点进入
                while (!qmax.isEmpty() && arr[qmax.peekLast()] <= arr[i]) {
                    qmax.pollLast();
                }
                qmax.addLast(i);
                //判断是否符合标准：最大队列头节点减去最小队列头节点大于num，跳出内循环
                if (arr[qmax.peekFirst()] - arr[qmin.peekFirst()] > num) {
                    break;
                }
                //j++，res++
                j++;
                res += j - i;
            }
            //判断头节点是否过期：队列头节点等于当前i，就弹出队列头节点
            if (qmin.peekFirst() == i) {
                qmin.pollFirst();
            }

            if (qmax.peekFirst() == i) {
                qmax.pollFirst();
            }
            //i++
            i++;
        }
        return res;
    }
}
