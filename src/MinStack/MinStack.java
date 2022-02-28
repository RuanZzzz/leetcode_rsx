package MinStack;

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
    Stack<Integer> A,B;

    /** initialize your data structure here. */
    public MinStack() {
        A = new Stack<>();
        B = new Stack<>();
    }

    public void push(int x) {
        A.add(x);
        // 如果B为空，或者B的元素大于等于当前元素，则压栈，保持最小元素
        if (B.isEmpty() || B.peek() >= x) {
            B.add(x);
        }
    }

    public void pop() {
        // 如果A栈的栈顶元素与B的栈顶元素一致，那就将B的栈顶元素出栈
        if (A.peek().equals(B.peek())) {
            B.pop();
        }
        // 如果不一致，那就只是A出栈
        A.pop();
    }

    public int top() {
        return A.peek();
    }

    public int min() {
        return B.peek();
    }
}
