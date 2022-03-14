package deleteNode;

/**
 * 示例 1:
 *
 * 输入: head = [4,5,1,9], val = 5
 * 输出: [4,1,9]
 * 解释: 给定你链表中值为 5 的第二个节点，那么在调用了你的函数之后，该链表应变为 4 -> 1 -> 9.
 *
 */
public class deleteNode {
    public static void main(String[] args) {
        ListNode head = new ListNode(4);
        head.add(5);
        head.add(1);
        head.add(9);

        ListNode res = new Solution().deleteNode(head,5);

        System.out.println("结束");
    }
}

class Solution {
    public ListNode deleteNode(ListNode head, int val) {
        // 如果头结点就等于目标，直接返回下一节点
        if (head.val == val) {
            return head.next;
        }

        ListNode pre = head;
        ListNode cur = head.next;

        while (cur != null && cur.val != val) {
            pre = cur;
            cur = cur.next;
        }

        if (cur != null) {
            // 进行删除，pre的下个节点就是cur的下一个节点
            pre.next = cur.next;
        }

        return head;
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