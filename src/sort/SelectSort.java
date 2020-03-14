package sort;

import utils.Utils;

/**
 * @author Administrator
 * @descript 选择排序
 * @date 2020/2/20 15:43
 */
public class SelectSort {
    public void sort(int[] nums) {

        for (int i = 0, len = nums.length; i < len; i++) {
            int min = i;
            for (int j = i + 1; j < len; j++) {
                if (nums[j] < nums[min]) {
                    min = j;
                }
            }
            Utils.exchange(nums, i, min);
        }
        Utils.printNums(nums);
    }

    public static void main(String[] args) {
        new SelectSort().sort(Utils.getRandomNums(100));
    }
}
