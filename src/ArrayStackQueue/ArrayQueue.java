package ArrayStackQueue;

public class ArrayQueue {
    Integer[] arr;
    Integer size, end, start;

    public ArrayQueue(int initSize) {
        arr = new Integer[initSize];
        size = 0;
        end = 0;
        start = 0;
    }

    //看要出队列的值,start指向的位置
    public Integer peak() {
        if (size == 0) {
            return null;
        }
        return arr[start];
    }

    public void enQueue(int val) {
        if (size == arr.length) {
            return;
        }
        size++;
        arr[end] = val;
        end = end == arr.length - 1 ? 0 : end + 1;
    }

    public Integer deQueue() {
        if (size == 0) {
            return null;
        }
        size--;
        Integer tmp = arr[start];
        start = start == arr.length - 1 ? 0 : start + 1;
        return tmp;
    }


}
