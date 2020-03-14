package sort;

import utils.Utils;

/**
 * @author Administrator
 * @descript 归并排序
 * @date 2020/3/1 14:15
 */
public class MergeSort1 {

    private static int[] temp;

    private void merge(int[] nums, int left, int mid, int right) {
        if (right + 1 - left >= 0) System.arraycopy(nums, left, temp, left, right + 1 - left);

        int l = left, r = mid + 1;
        for (int i = left; i <= right; i++) {
            if (l > mid) {
                nums[i] = temp[r++];
            } else if (r > right) {
                nums[i] = temp[l++];
            } else if (temp[l] > temp[r]) {
                nums[i] = temp[r++];
            } else {
                nums[i] = temp[l++];
            }
        }
    }

    private void sort(int[] nums, int left, int right) {
        if (left < right) {
            int mid = (left + right) >> 1;
            sort(nums, left, mid);
            sort(nums, mid + 1, right);
            merge(nums, left, mid, right);
        }
    }

    public void sort(int[] nums) {
        int len = nums.length;
        temp = new int[len];
        sort(nums, 0, len - 1);
        Utils.printNums(nums);
    }

    public static void main(String[] args) {
        new MergeSort1().sort(Utils.getRandomNums(10000));
    }
}
