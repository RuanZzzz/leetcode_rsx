package reverseList;

public class reverseList {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.add(2);
        head.add(3);
        head.add(4);
        head.add(5);

        new Solution().reverseList(head);

    }

}


class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode cur = head;
        ListNode tmp = null;
        ListNode pre = null;

        while (cur != null) {
            // 暂存后续的节点
            tmp = cur.next;
            // 修改引用指向，不修改的话 pre暂存的就有下一个指向
            cur.next = pre;
            // 暂存当前节点
            pre = cur;
            // 访问下一个节点
            cur = tmp;
        }

        return pre;
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