package getKthFromEnd;


/**
 * 输入一个链表，输出该链表中倒数第k个节点。为了符合大多数人的习惯，本题从1开始计数，即链表的尾节点是倒数第1个节点。
 *
 * 例如，一个链表有 6 个节点，从头节点开始，它们的值依次是 1、2、3、4、5、6。这个链表的倒数第 3 个节点是值为 4 的节点。
 *
 *  
 *
 * 示例：
 *
 * 给定一个链表: 1->2->3->4->5, 和 k = 2.
 *
 * 返回链表 4->5.
 *
 */
public class getKthFromEnd {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.add(2);
        head.add(3);
        head.add(4);
        head.add(5);

        //ListNode res = new Solution().getKthFromEnd(head,2);

        System.out.println();
    }
}

class Solution {
    public ListNode getKthFromEnd1(ListNode head, int k) {
        ListNode latter = head;
        ListNode former = head;

        // 先让former向前走k步
        for (int i = 0; i < k; i++) {
            if(former == null) return null;
            former = former.next;
        }

        while (former != null) {
            former = former.next;
            latter = latter.next;
        }

        return latter;
    }
}

// 创建链表
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