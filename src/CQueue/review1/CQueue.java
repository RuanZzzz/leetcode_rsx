package CQueue.review1;

import java.util.LinkedList;

/**
 * 用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，分别完成在队列尾部插入整数和在队列头部删除整数的功能。(若队列中没有元素，deleteHead 操作返回 -1 )
 *
 *  
 *
 * 示例 1：
 *
 * 输入：
 * ["CQueue","appendTail","deleteHead","deleteHead"]
 * [[],[3],[],[]]
 * 输出：[null,null,3,-1]
 *。
 */
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

    public static void main(String[] args) {
        CQueue cQueue = new CQueue();
        cQueue.appendTail(3);
        cQueue.deleteHead();
        cQueue.deleteHead();
        //System.out.println(cQueue.deleteHead());
        //System.out.println(cQueue.deleteHead());
    }
}
