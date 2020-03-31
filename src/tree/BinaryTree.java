package tree;

/**
 * @author Administrator
 * @descript 二叉树
 * @date 2020/3/18 18:18
 */
public class BinaryTree<K extends Comparable<K>, V> {

    private Node root;

    class Node {
        K key;
        V value;
        Node parent;
        Node left;
        Node right;

        public Node() {
        }

        public Node(K key, V value, Node parent) {
            this.value = value;
            this.key = key;
            this.parent = parent;
        }

        @Override
        public String toString() {
            return "key=" + key + ", value=" + value;
        }
    }

    private Node getNode(K key) {
        if (key == null) throw new RuntimeException("The key should not be null!");
        Node n = root;
        while (n != null) {
            int compareValue = key.compareTo(n.key);
            if (compareValue > 0) {
                n = n.left;
            } else if (compareValue < 0) {
                n = n.right;
            } else {
                return n;
            }
        }
        return null;
    }

    public V get(K key) {
        if (key == null) throw new RuntimeException("The key should not be null!");
        Node node = getNode(key);
        return node == null ? null : node.value;
    }

    public Node getMax() {
        Node n = root;
        while (n.left != null) {
            n = n.left;
        }
        return n;
    }

    public Node getMin() {
        Node n = root;
        while (n.right != null) {
            n = n.right;
        }
        return n;
    }

    public void put(K key, V value) {
        Node newNode = new Node(key, value, null);
        if (root == null) {
            root = newNode;
            return;
        }

        Node n = root;
        while (true) {
            //左边放大的数，右边放小的数
            int compareValue = key.compareTo(n.key);

            if (compareValue > 0) {
                if (n.left == null) {
                    newNode.parent = n;
                    n.left = newNode;
                    break;
                }
                n = n.left;
            } else if (compareValue < 0) {
                if (n.right == null) {
                    newNode.parent = n;
                    n.right = newNode;
                    break;
                }
                n = n.right;
            } else {

                if (n == root) {
                    newNode.left = root.left;
                    newNode.right = root.right;
                    root = newNode;
                    return;
                }

                newNode.left = n.left;
                newNode.right = n.right;
                newNode.parent = n.parent;

                if (n.parent.left == n) {
                    n.parent.left = newNode;
                } else {
                    n.parent.right = newNode;
                }

                break;
            }
        }
    }

    public void replace(K key, V newVal) {
        Node node = getNode(key);
        //如果不存在该节点，则加入该节点
        if (node == null) {
            put(key, newVal);
        } else {
            node.value = newVal;
        }
    }

    public void delete(K key) {
        Node node = getNode(key);
        if (node == null) return;

        if (node.left == null && node.right == null) { //左右结点都为空

            if (node.parent.left == node) {
                node.parent.left = null;
            } else {
                node.parent.right = null;
            }

        } else if (node.left == null || node.right == null) { //只有一个结点为空

            //如果要删除的结点左节点没有值
            if (node.left == null) {
                //判断当前结点处于父节点的左边还是右边
                if (node.parent.left == node) {
                    node.parent.left = node.right;
                } else {
                    node.parent.right = node.right;
                }
            } else {
                //判断当前结点处于父节点的左边还是右边
                if (node.parent.left == node) {
                    node.parent.left = node.left;
                } else {
                    node.parent.right = node.left;
                }
            }

        } else { //左右结点都不为空

            Node n = node.right;
            while (n.left != null) {
                n = n.left;
            }
            n.parent.left = null;

            n.left = node.left;
            n.right = node.right;

            if (node == root) {
                root = null;
                root = n;
            } else if (node.parent.left == node) {
                node.parent.left = n;
            } else {
                node.parent.right = node.left;
            }
        }
    }

    private void inOrderTraverse(Node root) {
        if (root != null) {
            inOrderTraverse(root.left);
            System.out.print(root.value + "  ");
            inOrderTraverse(root.right);
        }
    }

    public void inOrderTraverse() {
        System.out.println("root结点为：" + root.value);
        inOrderTraverse(root);
    }
}