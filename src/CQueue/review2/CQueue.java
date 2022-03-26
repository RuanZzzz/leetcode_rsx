package CQueue.review2;

import java.util.LinkedList;

public class CQueue {
    LinkedList<Integer> A,B;

    public CQueue() {
        A = new LinkedList<>();
        B = new LinkedList<>();
    }

    public void appendTail(int value) {
        A.addLast(value);
    }

    public int deleteHead() {
        // 先检查B中是否有元素，有则直接弹出栈顶元素
        if (!B.isEmpty()) {
            return B.removeLast();
        }

        // 如果B没有元素了，A也没有元素，则直接返回-1
        if (A.isEmpty()) {
            return -1;
        }

        // 如果A中有元素，则先将元素倒序存储到B中
        while (!A.isEmpty()) {
            B.addLast(A.removeLast());
        }
        // 然后再返回B的栈顶元素

        return B.removeLast();
    }

}
