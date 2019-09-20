package leetCode;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class num_78_subSet {
    public static void preOrder(int[] nums, int i, List<Integer> subset, List<List<Integer>> res) {
        if (i >= nums.length) return;
        // 到了新的状态，记录新的路径，要重新拷贝一份
        subset = new ArrayList<Integer>(subset);

        // 这里
        res.add(subset);//输入结果
        preOrder(nums, i + 1, subset, res);//往左走
        subset.add(nums[i]);//左边不选某个数，右边选某个数
        preOrder(nums, i + 1, subset, res);//往右走
    }

    public static void backtrack(int[] nums, int i, List<Integer> sub, List<List<Integer>> res) {
        for (int j = i; j < nums.length; j++) {
            if (j > i && nums[j] == nums[j - 1]) continue;
            sub.add(nums[j]);
            res.add(new ArrayList<Integer>(sub));
            backtrack(nums, j + 1, sub, res);
            sub.remove(sub.size() - 1);
        }
    }


    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        List<Integer> subSet = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();

        res.add(subSet);
        backtrack(nums, 0, subSet, res);

        ListIterator<List<Integer>> lt = res.listIterator();
        while (lt.hasNext()) {
            System.out.print(lt.next() + " ");
        }

        int[][] ints = new int[2][8];
    }
}
