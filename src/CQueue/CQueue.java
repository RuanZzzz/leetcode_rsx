package CQueue;

import java.util.LinkedList;

/**
 * 用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，分别完成在队列尾部插入整数和在队列头部删除整数的功能。(若队列中没有元素，deleteHead 操作返回 -1 )
 *
 * 输入：
 * ["CQueue","deleteHead","appendTail","appendTail","deleteHead","deleteHead"]
 * [[],[],[5],[2],[],[]]
 * 输出：[null,-1,null,null,5,2]
 *
 */
public class CQueue {
    LinkedList<Integer> A,B;

    public CQueue() {
        // 初始化
        A = new LinkedList<Integer>();
        B = new LinkedList<Integer>();
    }

    /**
     * 插入元素
     * @param value
     */
    public void appendTail(int value) {
        A.addLast(value);
    }

    /**
     * 删除元素：
     * 1、看B有没有，B有则直接返回栈顶元素
     * 2、如果B没有，则看A有没有，A有就先把元素都放到B中，然后再返回B的栈顶元素
     * 3、如果B没有，A也没有，则返回 -1
     * @return
     */
    public int deleteHead() {
        // 如果B中有元素，直接返回栈顶元素
        if (!B.isEmpty()) {
            return B.removeLast();
        }
        // 如果A中没有元素
        if (A.isEmpty()) {
            return -1;
        }
        // 如果A中有
        while (!A.isEmpty()) {
            // 将A的倒序存储至B中
            B.addLast(A.removeLast());
        }
        // 然后再返回B的栈顶元素
        return B.removeLast();
    }

}
