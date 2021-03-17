package 二叉树;

public class 二叉树深度 {

    public int maxDepth(TreeNode root) {

        if (root == null) {
            return 0;

        } else {
            if (root.left != null && root.right != null) {
                return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
            }

            if (root.left != null) {
                return 1 + maxDepth(root.left);
            }

            if (root.right != null) {
                return 1 + maxDepth(root.right);
            }
        }

        return 1;
    }
}
