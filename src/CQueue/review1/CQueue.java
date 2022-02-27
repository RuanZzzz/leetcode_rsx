package CQueue.review1;

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
        // 判断B存不存在数据，存在则弹出顶层栈元素
        if (!B.isEmpty()) {
            return B.removeLast();
        }
        // 判断A是否为空，为空直接返回-1
        if (A.isEmpty()) {
            return -1;
        }
        // 剩下就是A不为空，先将元素倒序放到B中
        while (!A.isEmpty()) {
            B.addLast(A.removeLast());
        }
        // 最后再弹出B的元素
        return B.removeLast();
    }

}
