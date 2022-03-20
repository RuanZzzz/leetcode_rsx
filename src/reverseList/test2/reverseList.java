package reverseList.test2;

/**
 * 定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。
 *
 *  
 *
 * 示例:
 *
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 *
 */
public class reverseList {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.add(2);
        head.add(3);
        head.add(4);
        head.add(5);
        ListNode res = new Solution().reverseList(head);

        System.out.println("结束");
    }
}

class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;

        while (cur != null) {
            // 使用tmp暂存下个节点
            ListNode tmp = cur.next;
            // 修改cur指向的下个节点
            cur.next = pre;
            // pre 暂存cur
            pre = cur;
            // cur节点再往下走
            cur = tmp;
        }

        // 最后返回pre，就是反转后的链表
        return pre;
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