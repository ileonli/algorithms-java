package sort;

import utils.Utils;

/**
 * @author Administrator
 * @descript 冒泡排序
 * @date 2020/2/19 16:54
 */
public class BubbleSort {

    public void sort(int[] nums) {
        boolean flag = true;
        for (int i = 0; i < nums.length - 1 && flag; i++) {
            flag = false;
            for (int j = 0; j < nums.length - 1 - i; j++) {
                if (nums[j] > nums[j + 1]) {
                    flag = true;
                    Utils.exchange(nums, j, j + 1);
                }
            }
        }
        Utils.printNums(nums);
    }

    public static void main(String[] args) {
        new BubbleSort().sort(Utils.getRandomNums(10));
    }

}
