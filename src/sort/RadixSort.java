package sort;

import utils.Utils;

/**
 * @author Administrator
 * @descript 基数排序
 * @date 2020/3/2 13:31
 */
public class RadixSort {

    public void sort(int[] nums) {
        int len = nums.length;

        //获取最大元素的位数
        int max = nums[0];
        for (int i = 1; i < len; i++) {
            if (nums[i] > max) max = nums[i];
        }
        max = (max + "").length();

        //定义储存元素的桶
        int[][] buckets = new int[10][len];
        //统计每个桶占用的空间
        int[] bucketsCount = new int[10];
        for (int i = 0, t = 1; i < max; i++, t *= 10) {
            //在桶中放数
            for (int num : nums) {
                int i1 = num / t % 10;
                buckets[i1][bucketsCount[i1]++] = num;
            }
            //把桶中数据恢复到原数组
            int a = 0;
            for (int b = 0; b < 10; b++) {
                if (bucketsCount[b] != 0) {
                    for (int k = 0; k < bucketsCount[b]; k++) {
                        nums[a++] = buckets[b][k];
                    }
                }
                //数组计数恢复为0
                bucketsCount[b] = 0;
            }
        }
    }

    public static void main(String[] args) {
        int[] randomNums = Utils.getRandomNums(1000);
        new RadixSort().sort(randomNums);

        System.out.println(Utils.verify(randomNums));
    }
}
