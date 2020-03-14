package recurison;

import java.util.Arrays;

/**
 * @author Administrator
 * @descript 递归解决八皇后问题
 * @date 2020/2/16 15:42
 */
public class EightQueen {

    //默认为8皇后问题
    static int max = 8;
    int[] nums = new int[max];

    private boolean check(int n) {
        for (int i = 0; i < n; i++) {
            //nums[i] == nums[n]判断行是否有重复元素
            //Math.abs(i - n) == Math.abs(nums[i] - nums[n]
            //对应行和列相减，如果相同，则代表斜线有重复元素
            if (nums[i] == nums[n] || Math.abs(n - i) == Math.abs(nums[n] - nums[i])) {
                return false;
            }
        }
        return true;
    }

    public void play() {
        play(0);
    }

    private void play(int n) {
        if (n == max) {
            System.out.println(Arrays.toString(nums));
            return;
        }
        for (int i = 0; i < max; i++) {
            nums[n] = i;
            if (check(n)) {
                play(n + 1);
            }
        }
    }

    public static void main(String[] args) {
        new EightQueen().play();
    }

}
