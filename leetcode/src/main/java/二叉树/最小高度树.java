package 二叉树;

import java.util.Arrays;

public class 最小高度树 {

    public TreeNode sortedArrayToBST(int[] nums) {

        return helper(nums, 0, nums.length - 1);
    }

    public static TreeNode helper(int[] temp, int left, int right) {

        if (left == right) {
            return null;
        }
        int mid = temp[(left + right) / 2];
        TreeNode treeNode = new TreeNode(temp[mid]);


        treeNode.left = helper(Arrays.copyOfRange(temp,0,mid), 0, mid);

        treeNode.right = helper(Arrays.copyOfRange(temp,mid,right), mid, right);

        return  treeNode;

    }
}
