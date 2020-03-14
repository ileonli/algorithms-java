package utils;

import java.util.Arrays;

/**
 * @author lapoison
 * @descript 排序的工具类
 * @date 2020/1/3 下午9:15
 */
public class Utils {

    /**
     * 生成随机数组
     *
     * @param num 生成数组的长度
     * @return 返回随机的数组
     */
    public static int[] getRandomNums(int num) {
        int[] nums = new int[num];
        for (int i = 0; i < num; i++) {
            nums[i] = (int) (Math.random() * 1000);
        }
        return nums;
    }

    /**
     * 生成倒序数组
     *
     * @param num 生成数组的长度
     * @return 返回倒序的数组
     */
    public static int[] getReverseNums(int num) {
        int[] nums = new int[num];
        for (int i = 0; i < num; i++) {
            nums[num - i - 1] = i;
        }
        return nums;
    }

    /**
     * 生成正序数组
     *
     * @param num 生成数组的长度
     * @return 返回正序的数组
     */
    public static int[] getPositiveNums(int num) {
        int[] nums = new int[num];
        for (int i = 0; i < num; i++) {
            nums[i] = i;
        }
        return nums;
    }

    /**
     * 打印数组
     *
     * @param nums 要打印的数组
     */
    public static void printNums(int[] nums) {
        System.out.println(Arrays.toString(nums));
    }

    /**
     * 交换两个数组元素的位置
     *
     * @param nums  要交换的数组
     * @param start 第一个索引
     * @param end   第二个索引
     */
    public static void exchange(int[] nums, int start, int end) {
        int n = nums[start];
        nums[start] = nums[end];
        nums[end] = n;
    }

    /**
     * 验证数组是否排好序
     *
     * @param nums 要排序的数组
     * @return true：排好序，false：没有排好序
     */
    public static boolean verify(int[] nums) {
        int[] cloneNums = nums.clone();
        Arrays.sort(cloneNums);
        for (int i = 0; i < cloneNums.length; i++) {
            if (cloneNums[i] != nums[i]) {
                return false;
            }
        }
        return true;
    }
}