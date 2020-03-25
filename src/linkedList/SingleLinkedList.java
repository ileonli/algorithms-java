package linkedList;

/**
 * @author Administrator
 * @descript 带head的单链表
 * @date 2020/2/10 15:30
 */
public class SingleLinkedList<Value extends Comparable<Value>> {

    private Node head;

    private class Node {
        private Value value;
        private Node next;

        public Node(Value value) {
            this.value = value;
        }
    }

    public SingleLinkedList() {
        head = new Node(null);
    }

    public void add(Value value) {
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = new Node(value);
    }

    public void remove(Value value) {
        Node temp = head;
        while (temp.next != null) {
            if (temp.next.value.compareTo(value) == 0) {
                temp.next = temp.next.next;
            }
            temp = temp.next;
        }
        head.next = temp.next;
    }

    public void reverse() {
//        Node temp;
//        Node node = new Node(null);
//        Node cur = head.next;
//        while (cur != null) {
//            temp = cur.next;
//            cur.next = node.next;
//            node.next = cur;
//            cur = temp;
//        }
//        head.next = node.next;

        Node temp, cur;
        cur = head.next;
        while (cur.next != null) {
            temp = cur.next;
            cur.next = temp.next;
            temp.next = head.next;
            head.next = temp;
        }
    }

    public void reverseList() {
        reverseList(head.next);
    }

    private void reverseList(Node node) {
        if (node == null) return;
        reverseList(node.next);
        System.out.println(node.value);
    }

    public void list() {
        Node temp = head;
        while (temp.next != null) {
            System.out.println(temp.next.value);
            temp = temp.next;
        }
    }

    public static void main(String[] args) {
        SingleLinkedList<Integer> s = new SingleLinkedList<>();
        s.add(10);
        s.add(12);
        s.add(13);

        s.list();
        s.reverse();
        System.out.println();
        s.list();
    }
}
