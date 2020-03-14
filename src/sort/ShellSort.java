package sort;

import utils.Utils;

/**
 * @author Administrator
 * @descript 希尔排序
 * @date 2020/2/20 17:48
 */
public class ShellSort {
    public void sort(int[] nums) {
        for (int len = nums.length, gap = len / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < len; i++) {
                for (int j = i - gap; j >= 0 && nums[j + gap] <= nums[j]; j -= gap) {
                    Utils.exchange(nums, j, j + gap);
                }
            }
        }
        Utils.printNums(nums);
    }

    public static void main(String[] args) {
        new ShellSort().sort(Utils.getRandomNums(10));
    }
}
