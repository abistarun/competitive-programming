/*
https://www.geeksforgeeks.org/find-maximum-path-sum-in-a-binary-tree/
https://leetcode.com/problems/binary-tree-maximum-path-sum/submissions/
*/

public class MaxPathBinaryTree {
    class Res {
        int val;
    }

    private int maxUtil(TreeNode node, Res res) {
        if (node == null)
            return 0;

        int l = maxUtil(node.left, res);
        int r = maxUtil(node.right, res);

        int max_single = Math.max(Math.max(l, r) + node.val,
                node.val);

        int max_top = Math.max(max_single, l + r + node.val);

        res.val = Math.max(res.val, max_top);

        return max_single;

    }

    public int maxPathSum(TreeNode root) {
        Res res = new Res();
        res.val = Integer.MIN_VALUE;
        maxUtil(root, res);
        return res.val;
    }
}