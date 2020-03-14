package stack;


/**
 * @author Administrator
 * @descript 栈
 * @date 2020/2/14 17:04
 */
public class ArrayStack<E> {
    //顶部栈针
    private int top;
    //底部栈针
    private int last;
    //最大容量
    private int maxLen;
    private Object[] elementData;

    public ArrayStack(int maxLen) {
        this.maxLen = maxLen;
        elementData = new Object[maxLen];
        top = -1;
        last = -1;
    }

    public boolean isFull() {
        return top == maxLen;
    }

    public boolean isEmpty() {
        return top == last;
    }

    public void push(E e) {
        if (isFull()) throw new RuntimeException("The stack is full!");
        elementData[++top] = e;
    }

    public Object pop() {
        if (isEmpty()) throw new RuntimeException("The stack is empty!");
        return elementData[++last];
    }

    public void list() {
        for (int i = (last == -1 ? 0 : last + 1); i <= top; i++) {
            System.out.println(elementData[i]);
        }
    }
}
