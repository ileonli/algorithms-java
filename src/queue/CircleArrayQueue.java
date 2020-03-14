package queue;

/**
 * @author Administrator
 * @descript 环形队列
 * @date 2020/2/10 13:39
 */
public class CircleArrayQueue {
    private int front;
    private int rear;
    private int maxSize;
    private int[] values;

    public CircleArrayQueue(int maxSize) {
        if (maxSize <= 0) {
            throw new RuntimeException("Please enter a number greater than 0!");
        }
        values = new int[maxSize];
        front = 0;
        rear = 0;
    }

    public boolean isEmpty() {
        return rear == front;
    }

    public boolean isFull() {
        return front == (rear + 1) % maxSize;
    }

    public void add(int value) {
        if (isFull())
            throw new RuntimeException("The queue is full！");
        values[rear] = value;
        rear = (rear + 1) % maxSize;
    }

    public int get() {
        if (isEmpty())
            throw new RuntimeException("The queue is empty！");
        int value = values[front];
        front = (front + 1) % maxSize;
        return value;
    }

    public int getHead() {
        if (isEmpty())
            throw new RuntimeException("The queue is empty!");
        return values[front];
    }
}
