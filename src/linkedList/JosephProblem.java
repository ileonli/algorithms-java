package linkedList;

import java.util.Scanner;

/**
 * @author Administrator
 * @descript 利用单向环形链表解决约瑟夫问题
 * @date 2020/2/14 14:46
 */
public class JosephProblem {

    private static class Node {
        Node next;
        int num;

        public Node(int num) {
            this.num = num;
        }
    }

    public JosephProblem() {
        System.out.print("请输入一共有几个人玩：");
        Scanner sc = new Scanner(System.in);
        int i = sc.nextInt();
        //生成环形链表
        Node node = genList(i);
        play(2, 2, node);
    }

    public Node genList(int n) {
        Node node = new Node(0);
        Node temp = node;
        for (int i = 1; i < n; i++) {
            temp.next = new Node(i);
            temp = temp.next;
        }
        //最后一个节点指向头部的节点
        temp.next = node;
        return node;
    }

    /**
     * @param k    从第几个开始数
     * @param m    每次数几下
     * @param node 链表头部节点
     */
    public void play(int k, int m, Node node) {

        //获取开始的节点
        Node start = node;
        //辅助指针，方便删除节点
        Node temp = null;
        for (int j = 0; j < k - 1; j++) {
            start = start.next;
        }

        while (true) {
            for (int j = 0; j < m - 1; j++) {
                temp = start;
                start = start.next;
            }
            System.out.println(start.num);
            //如果剩余最后一个，直接return
            if (start.next == start) break;
            assert temp != null;
            temp.next = start.next;
            start = start.next;
        }
    }

    public static void main(String[] args) {
        JosephProblem josephProblem = new JosephProblem();
    }
}
