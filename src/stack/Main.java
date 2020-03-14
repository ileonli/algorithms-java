package stack;

/**
 * @author Administrator
 * @descript
 * @date 2020/2/14 17:43
 */
public class Main {
    public static void main(String[] args) {
        ArrayStack<Integer> i = new ArrayStack<>(20);
        i.push(20);
        i.push(30);
        i.push(40);
        System.out.println("pop:" + i.pop());
        i.push(50);
        System.out.println("pop:" + i.pop());
        i.pop();
        i.list();
    }
}
