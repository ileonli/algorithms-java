package tree;

import java.util.Comparator;
import java.util.LinkedList;

/**
 * @author Administrator
 * @descript 哈夫曼树
 * @date 2020/3/27 11:18
 */
public class HuffmanTree {

    class Node {
        private int val;
        private Node left;
        private Node right;

        public Node(int val) {
            this.val = val;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "val=" + val +
                    '}';
        }
    }

    private Node root;

    public HuffmanTree(int[] nums) {
        root = createHuffmanTree(nums);
    }

    private Node createHuffmanTree(int[] nums) {
        LinkedList<Node> linkedList = new LinkedList<>();
        for (int num : nums) {
            linkedList.add(new Node(num));
        }

        while (linkedList.size() > 1) {
            linkedList.sort(Comparator.comparing(l -> l.val));

            Node leftNode = linkedList.get(0);
            Node rightNode = linkedList.get(1);
            Node newNode = new Node(leftNode.val + rightNode.val);

            newNode.left = leftNode;
            newNode.right = rightNode;

            linkedList.remove(leftNode);
            linkedList.remove(rightNode);

            linkedList.add(newNode);
        }
        return linkedList.get(0);
    }

    private void orderPrint(Node node) {
        System.out.println(node);

        if (node.left != null) {
            orderPrint(node.left);
        }

        if (node.right != null) {
            orderPrint(node.right);
        }
    }

    public void orderPrint() {
        orderPrint(root);
    }

    public static void main(String[] args) {
        int[] nums = {13, 7, 8, 3, 29, 6, 1};
        new HuffmanTree(nums).orderPrint();
    }
}
