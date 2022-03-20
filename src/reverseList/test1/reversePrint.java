package reverseList.test1;

import java.util.LinkedList;

/**
 * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
 *
 *
 *
 * 示例 1：
 *
 * 输入：head = [1,3,2]
 * 输出：[2,3,1]
 */
public class reversePrint {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.add(3);
        head.add(2);

        int[] res = new Solution().reversePrint(head);

        System.out.println("结束");
    }
}

class Solution {
    public int[] reversePrint(ListNode head) {
        LinkedList<Integer> stack = new LinkedList<>();

        while ( head != null) {
            stack.addLast(head.val);
            // 更新节点
            head = head.next;
        }

        int[] res = new int[stack.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = stack.removeLast();
        }

        return res;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }

    public void add(int newVal) {
        ListNode newNode = new ListNode(newVal);
        if (this.next == null) {
            this.next = newNode;
        }else {
            this.next.add(newVal);
        }
    }

}