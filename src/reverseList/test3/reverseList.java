package reverseList.test3;

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
        ListNode cur = head;
        ListNode pre = null;

        while (cur != null) {
            // 暂存后继节点
            ListNode tmp = cur.next;
            // 修改引用指向（主要）
            cur.next = pre;
            // 暂存当前节点
            pre = cur;
            // 访问下一个节点
            cur = tmp;
        }

        return pre;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        this.val = x;
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