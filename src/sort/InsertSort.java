package sort;

import utils.Utils;

/**
 * @author Administrator
 * @descript 插入排序
 * @date 2020/2/20 16:31
 */
public class InsertSort {
    public void sort(int[] nums) {
        for (int i = 1, len = nums.length; i < len; i++) {
            for (int j = i; j > 0 && nums[j - 1] > nums[j]; j--) {
                Utils.exchange(nums, j, j - 1);
            }
        }
        Utils.printNums(nums);
    }

    public static void main(String[] args) {
        new InsertSort().sort(Utils.getRandomNums(10));
    }
}
