package 二叉树;

public class 最大深度 {

    public int maxDepth(TreeNode root) {

        if(root!=null){

            if (root.left != null && root.right != null) {
                return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
            }

            if(root.right!=null){
                return 1+maxDepth(root.right);
            }

            if(root.left!=null){
                return 1+maxDepth(root.left);
            }

            return 1;
        }
        return 0;


    }
}
