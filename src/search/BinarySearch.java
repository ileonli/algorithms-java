package search;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Administrator
 * @descript 二分查找
 * @date 2020/3/2 17:35
 */
public class BinarySearch {

    public List<Integer> search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        List<Integer> result = new ArrayList<>();
        while (left < right) {
            int mid = (left + right) >> 1;
            int key = nums[mid];
            if (target < key) {
                right = mid + 1;
            } else if (target > key) {
                left = mid + 1;
            } else {
                result.add(mid);

                int temp = 1;
                boolean leftFlag = true, rightFlag = true, flag;
                while (true) {
                    //防止要查找的数在数组头部或者尾部造成越界
                    flag = (target - temp >= left && target + temp <= right) && (leftFlag || rightFlag);
                    if (flag) {
                        if (nums[mid - temp] == target) {
                            result.add(mid - temp);
                        } else {
                            leftFlag = false;
                        }

                        if (nums[mid + temp] == target) {
                            result.add(mid + temp);
                        } else {
                            rightFlag = false;
                        }
                        temp++;
                    } else {
                        break;
                    }
                }
                Collections.sort(result);
                return result;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        int[] nums = {8, 8, 8, 8, 10, 20};
        System.out.println(new BinarySearch().search(nums, 8));
    }
}