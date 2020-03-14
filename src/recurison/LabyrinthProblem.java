package recurison;

/**
 * @author Administrator
 * @descript 迷宫回溯问题
 * @date 2020/2/15 17:24
 */
public class LabyrinthProblem {

    private static int[][] maps = new int[9][9];

    public LabyrinthProblem() {
        for (int i = 0; i < 9; i++) {
            maps[0][i] = 1;
            maps[8][i] = 1;
        }

        for (int i = 1; i < maps.length - 1; i++) {
            maps[i][0] = 1;
            maps[i][8] = 1;
        }

        maps[1][3] = 1;

        maps[3][1] = 1;
        maps[3][2] = 1;
        maps[3][3] = 1;
        maps[3][7] = 1;
    }

    public void printNums() {
        for (int[] map : maps) {
            for (int i : map) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

    public void play() {
        printNums();
        System.out.println();
        play(maps, 1, 1);
        printNums();
    }

    /**
     * @param maps 要走的地图
     * @param x    水平移动到底位置
     * @param y    垂直移动到的位置
     * @return 是否已经走到
     */
    private boolean play(int[][] maps, int x, int y) {
        if (maps[7][7] == 2) {
            return true;
        } else {
            if (maps[x][y] == 0) {
                maps[x][y] = 2;
                //走的位置为下右左上
                if (play(maps, x, y + 1)) {
                    return true;
                } else if (play(maps, x + 1, y)) {
                    return true;
                } else if (play(maps, x, y - 1)) {
                    return true;
                } else if (play(maps, x - 1, y)) {
                    return true;
                } else {
                    maps[x][y] = 3;
                    return false;
                }
            } else {
                return false;
            }
        }
    }

    public static void main(String[] args) {
        LabyrinthProblem pro = new LabyrinthProblem();
        pro.play();
    }
}
