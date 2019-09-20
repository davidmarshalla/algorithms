package Sort;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Heap {
    public static class student {
        public int age;
        public int id;

        public student(int age, int id) {
            this.age = age;
            this.id = id;
        }

        @Override
        public String toString() {
            return "age = " + this.age + "  id = " + this.id;
        }
    }

    //按照age排的小根堆
    public static class ageComparator implements Comparator<student> {
        @Override
        public int compare(student o1, student o2) {
            if (o1.age > o2.age) {
                return 1;//右边的的参数放在上头
            } else if (o1.age < o2.age) {
                return -1;
            } else {
                return 0;
            }
        }
    }

    //按照id排的大根堆
    public static class idComparator implements Comparator<student> {
        @Override
        public int compare(student o1, student o2) {
            if (o1.id < o2.id) {
                return 1;
            } else if (o1.id > o2.id) {
                return -1;
            } else {
                return 0;
            }
        }
    }


    public static void main(String[] args) {
        PriorityQueue<student> heap = new PriorityQueue<>(new idComparator());

        heap.add(new student(12, 1));
        heap.add(new student(17, 2));
        heap.add(new student(16, 3));
        heap.add(new student(13, 14));

        System.out.println(heap.poll());
        System.out.println(heap.poll());
        System.out.println(heap.poll());
        System.out.println(heap.poll());
    }
}
