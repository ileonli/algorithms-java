package sort;

import utils.Utils;

/**
 * @author Administrator
 * @descript 快速排序
 * @date 2020/2/26 15:10
 */
public class QuickSort {

    private static void sort(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }
        int i = left, j = right + 1;
        //采用左边元素作为基准
        int v = nums[left];
        while (true) {
            while (nums[++i] < v) if (i == right) break;
            while (v < nums[--j]) if (j == left) break;
            if (i >= j) break;
            Utils.exchange(nums, i, j);
        }
        Utils.exchange(nums, left, j);
        sort(nums, left, j - 1);
        sort(nums, j + 1, right);
    }

    public void sort(int[] nums) {
        long s = System.currentTimeMillis();
        sort(nums, 0, nums.length - 1);
        Utils.printNums(nums);
        System.out.println(System.currentTimeMillis() - s);
    }

    public static void main(String[] args) {
        new QuickSort().sort(Utils.getRandomNums(10));
    }
}
