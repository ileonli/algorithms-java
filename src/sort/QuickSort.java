package sort;

import utils.Utils;

import java.util.Arrays;

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
        // +1是因为22行寻找较大元素的时候，先自减
        int l = left, r = right + 1;
        //采用左边元素作为基准
        int v = nums[left];
        while (true) {
            while (nums[++l] < v) if (l == right) break;
            while (v < nums[--r]) if (r == left) break;
            if (l >= r) break;
            Utils.exchange(nums, l, r);
        }
        Utils.exchange(nums, left, r);
        sort(nums, left, r - 1);
        sort(nums, r + 1, right);
    }

    public void sort(int[] nums) {
        long s = System.currentTimeMillis();
        sort(nums, 0, nums.length - 1);
        Utils.printNums(nums);
        System.out.println(System.currentTimeMillis() - s);
    }

    public static void main(String[] args) {
        new QuickSort().sort(new int[]{4, 4, 4});
    }
}
