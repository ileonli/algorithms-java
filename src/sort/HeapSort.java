package sort;

import utils.Utils;

/**
 * @author Administrator
 * @descript 堆排序
 * @date 2020/3/26 19:19
 */
public class HeapSort {

    public void sort(int[] arr) {

        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            adjustHeap(arr, i, arr.length);
        }

        for (int i = arr.length - 1; i > 0; i--) {
            Utils.exchange(arr, 0, i);
            adjustHeap(arr, 0, i);
        }
    }

    /**
     * 调节堆
     *
     * @param arr 要堆化的数组
     * @param i   开始位置
     * @param len 数组长度
     */
    private void adjustHeap(int[] arr, int i, int len) {
        int temp = arr[i];//先取出当前元素i
        for (int k = i * 2 + 1; k < len; k = k * 2 + 1) {//从i结点的左子结点开始，也就是2i+1处开始
            if (k + 1 < len && arr[k] < arr[k + 1]) {//如果左子结点小于右子结点，k指向右子结点
                k++;
            }
            if (arr[k] > temp) {//如果子节点大于父节点，将子节点值赋给父节点（不用进行交换）
                arr[i] = arr[k];
                i = k;
            } else {
                break;
            }
        }
        arr[i] = temp;//将temp值放到最终的位置
    }


    public static void main(String[] args) {
        int[] nums = {1, 2, 3, -4, 5, 6};
        new HeapSort().sort(nums);
        Utils.printNums(nums);
    }
}
