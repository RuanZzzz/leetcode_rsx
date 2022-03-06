package levelOrder;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 从上到下打印出二叉树的每个节点，同一层的节点按照从左到右的顺序打印。
 *
 *  
 *
 * 例如:
 * 给定二叉树: [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回：
 *
 * [3,9,20,15,7]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class levelOrder {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        int[] res = new Solution().levelOrder(root);

        System.out.println("结束");
    }
}

class Solution {
    public int[] levelOrder(TreeNode root) {
        if (root == null) {
            return new int[0];
        }

        Queue<TreeNode> queue = new LinkedList<TreeNode>(){{add(root);}};
        ArrayList<Integer> res = new ArrayList<>();

        while (!queue.isEmpty()) {
            // 每次将队列中的第一个元素返回，放在当前node中
            TreeNode node = queue.poll();
            // 将当前节点的val放到res里
            res.add(node.val);
            if (node.left != null) {
                // 当左节点不为空，放到queue中
                queue.add(node.left);
            }
            if (node.right != null) {
                // 当有节点不为空，放到queue中
                queue.add(node.right);
            }
        }

        // 组装最后的返回数组
        int[] ans = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            ans[i] = res.get(i);
        }

        return ans;
    }
}


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val,TreeNode left,TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

}