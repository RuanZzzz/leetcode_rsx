package mergeTwoLists;

/**
 * 输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的。
 *
 * 示例1：
 *
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 *
 */
public class mergeTwoLists {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.add(2);
        l1.add(4);

        ListNode l2 = new ListNode(1);
        l2.add(3);
        l2.add(4);

        ListNode res = new Solution().mergeTwoLists(l1,l2);
        System.out.println("结束");
    }

}

class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode res = new ListNode(0);
        ListNode cur = res;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                cur.next = l1;
                l1 = l1.next;
            }else {
                cur.next = l2;
                l2 = l2.next;
            }

            cur = cur.next;
        }

        cur.next = l1 != null ? l1 : l2;

        return res.next;
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