package queue;

/**
 * @author Administrator
 * @descript 数组实现队列
 * @date 2020/2/9 18:14
 */
public class ArrayQueue {
    private int front;
    private int rear;
    private int maxSize;
    private int[] values;

    public ArrayQueue(int maxSize) {
        if (maxSize <= 0) {
            throw new RuntimeException("Please enter a number greater than 0!");
        }
        this.maxSize = maxSize;
        values = new int[maxSize];
        rear = -1;
        front = -1;
    }

    public boolean isEmpty() {
        return rear == front;
    }

    public boolean isFull() {
        return maxSize == rear - 1;
    }

    public void add(int value) {
        if (isFull())
            throw new RuntimeException("The queue is full！");
        values[++front] = value;
    }

    public int get() {
        if (isEmpty())
            throw new RuntimeException("The queue is empty！");
        return values[++rear];
    }

    public int getHead() {
        if (isEmpty())
            throw new RuntimeException("The queue is empty!");
        return values[front + 1];
    }

    public static void main(String[] args) {
        ArrayQueue aq = new ArrayQueue(5);
        aq.add(1);
        aq.add(3);
        aq.add(2);
        aq.add(20);
        System.out.println(aq.get());
        System.out.println(aq.get());
        System.out.println(aq.get());
        System.out.println(aq.get());
    }
}
