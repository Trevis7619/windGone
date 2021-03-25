package 二叉树;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class 二叉搜索树的第k大节点 {

    public int kthLargest(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>();


        List<Integer> result = getList(list, root);

        result.add(root.val);
        result = result.stream().sorted().collect(Collectors.toList());

        System.out.println(Arrays.toString(result.toArray()));
        return result.get(result.size() - k);
    }

    public static List<Integer> getList(List<Integer> initList, TreeNode treeNode) {

        if (treeNode == null) {
            return initList;
        } else {

            if (treeNode.left != null) {
                initList.add(treeNode.left.val);
                getList(initList, treeNode.left);
            }

            if (treeNode.right != null) {
                initList.add(treeNode.right.val);
                getList(initList, treeNode.right);
            }
            return initList;
        }

    }

}
