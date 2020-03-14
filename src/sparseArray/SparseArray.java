package sparseArray;

import java.io.*;

/**
 * @author Administrator
 * @descript 稀疏数组
 * @date 2020/2/9 16:12
 */
public class SparseArray {

    /**
     * 根据数组生成稀疏数组
     *
     * @param nums n * n的数组
     * @return 稀疏数组
     */
    public int[][] genSparseArr(int[][] nums) {
        int sparseArrLen = 0;
        int length = nums.length;
        for (int[] num : nums) {
            for (int n : num) {
                if (n != 0) {
                    sparseArrLen++;
                }
            }
        }
        int[][] sparseArr = new int[sparseArrLen + 1][3];
        sparseArr[0][0] = length;
        sparseArr[0][1] = nums[0].length;
        sparseArr[0][2] = sparseArrLen;
        //如果数组中没有非0元素，直接返回。
        if (sparseArrLen != 0) {
            int count = 1;
            for (int i = 0; i < length; i++) {
                for (int j = 0; j < nums[i].length; j++) {
                    int n = nums[i][j];
                    if (n != 0) {
                        sparseArr[count][0] = i;
                        sparseArr[count][1] = j;
                        sparseArr[count][2] = n;
                        count++;
                    }
                }
            }
        }
        return sparseArr;
    }

    /**
     * 根据稀疏数组生成普通数组
     *
     * @param nums 稀疏数组格式
     * @return 普通数组
     */
    public int[][] reverseToNums(int[][] nums) {
        int[][] result = new int[nums[0][0]][nums[0][1]];
        for (int i = 1; i < nums.length; i++) {
            result[nums[i][0]][nums[i][1]] = nums[i][2];
        }
        return result;
    }

    /**
     * 数组写入到文件
     *
     * @param nums 数组
     */
    public void writeToFile(int[][] nums) {
        File file = new File("./nums.data");
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try (
                FileWriter fileWriter = new FileWriter(file);
                BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        ) {
            SparseArray sparseArray = new SparseArray();
            int[][] sparseArr = sparseArray.genSparseArr(nums);
            for (int i = 0; i < sparseArr.length; i++) {
                bufferedWriter.write(sparseArr[i][0] + " " + sparseArr[i][1] + " " + sparseArr[i][2] + "\r\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 从储存稀疏数组的文件中得到原数组
     *
     * @return 普通数组
     */
    public int[][] getNumsFromFile() {
        File file = new File("./nums.data");
        int[][] nums = null;
        try (
                FileReader fileReader = new FileReader(file);
                BufferedReader bufferedReader = new BufferedReader(fileReader);
        ) {
            int flag = 0;
            String line = null;
            while ((line = bufferedReader.readLine()) != null) {
                String[] split = line.split(" ");
                int row = Integer.parseInt(split[0]);
                int col = Integer.parseInt(split[1]);
                int value = Integer.parseInt(split[2]);
                if (flag == 0) {
                    nums = new int[value + 1][3];
                    nums[flag][0] = row;
                    nums[flag][1] = col;
                    nums[flag][2] = value;
                } else {
                    nums[flag][0] = row;
                    nums[flag][1] = col;
                    nums[flag][2] = value;
                }
                flag++;
            }
            if (nums != null) nums = reverseToNums(nums);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return nums;
    }

    public static void main(String[] args) {
        int[][] nums = {
                {3, 0, 5, 0, 0},
                {1, 2, 0, 2, 0},
                {0, 7, 8, 0, 0},
                {0, 0, 0, 2, 0},
                {1, 0, 0, 0, 0}
        };
        SparseArray sparseArray = new SparseArray();

        System.out.println("\n生成稀疏数组~");
        int[][] sparseArr = sparseArray.genSparseArr(nums);
        for (int[] value : sparseArr) {
            System.out.println(value[0] + " " + value[1] + " " + value[2]);
        }

        System.out.println("\n变为原数组~");
        int[][] ints = sparseArray.reverseToNums(sparseArr);
        for (int[] anInt : ints) {
            for (int i : anInt) {
                System.out.print(i + " ");
            }
            System.out.println();
        }

        System.out.println("\n写入到文件~");
        sparseArray.writeToFile(nums);

        System.out.println("\n从文件恢复~");
        int[][] numsFromFile = sparseArray.getNumsFromFile();
        for (int[] ints1 : numsFromFile) {
            for (int anInt1 : ints1) {
                System.out.print(anInt1 + " ");
            }
            System.out.println();
        }
    }
}
