package linkedList;

/**
 * @author Administrator
 * @descript 双向链表
 * @date 2020/2/14 13:45
 */
public class DoublyLinkedList<Value extends Comparable<Value>> {
    private Node head;

    class Node {
        private Node pre;
        private Node next;
        private Value val;

        public Node(Node pre, Node next, Value val) {
            this.pre = pre;
            this.next = next;
            this.val = val;
        }
    }

    public DoublyLinkedList() {
        head = new Node(null, null, null);
    }

    public void add(Value value) {
        Node node = head;
        while (node.next != null) {
            node = node.next;
        }
        node.next = new Node(node, null, value);
    }

    public void remove(Value value) {
        Node node = head;
        while (node.next != null) {
            if (node.next.val.compareTo(value) == 0) {
                node.next.pre.next = node.next.next;
                node.next.next.pre = node.next.pre;
            }
            node = node.next;
        }
    }

    public void list() {
        Node node = head;
        while (node.next != null) {
            System.out.println(node.next.val);
            node = node.next;
        }
    }

    public static void main(String[] args) {
        DoublyLinkedList<Integer> bll = new DoublyLinkedList<>();
        bll.add(10);
        bll.add(20);
        bll.add(30);
        bll.add(14);

        bll.remove(10);
        bll.list();
    }
}
