package isSymmetric;

/**
 * 请实现一个函数，用来判断一棵二叉树是不是对称的。如果一棵二叉树和它的镜像一样，那么它是对称的。
 *
 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 * 输入：root = [1,2,2,3,4,4,3]
 * 输出：true
 */
public class isSymmetric {
    public static void main(String[] args) {
        TreeNode root = new TreeNode();
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        boolean res = new Solution().isSymmetric(root);

        System.out.println(res);
    }
}

class Solution {
    public boolean isSymmetric(TreeNode root) {
        return root == null || recur(root.left, root.right);
    }

    public boolean recur(TreeNode L,TreeNode R) {
        if (L == null && R == null) {
            return true;
        }
        if (L == null || R == null || L.val != R.val) {
            return false;
        }
        return recur(L.left,R.right) && recur(L.right,R.left);
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {

    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val,TreeNode left,TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

}