package MinStack.review1;

import java.util.Stack;

/**
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的 min 函数在该栈中，调用 min、push 及 pop 的时间复杂度都是 O(1)。
 *
 *  
 *
 * 示例:
 *
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.min();   --> 返回 -3.
 * minStack.pop();
 * minStack.top();      --> 返回 0.
 * minStack.min();   --> 返回 -2.
 *
 */
public class MinStack {
    Stack<Integer> A;
    Stack<Integer> B;

    public MinStack() {
        A = new Stack<>();
        // 总是存储最小的元素
        B = new Stack<>();
    }

    public void push(int x) {
        // 如果栈B中没有元素，或者栈顶元素大于等于x（因为x不能比之前的元素还小）
        if (B.isEmpty() || B.peek() >= x) {
            B.add(x);
        }
        A.add(x);
    }

    public void pop() {
        // 如果A要出栈的元素和B要出栈的元素一致，B也需要pop
        if (A.peek().equals(B.peek())) {
            B.pop();
        }
        // 否则只popA
        A.pop();
    }

    public int top() {
        return A.peek();
    }

    public int min() {
        return B.peek();
    }

}
