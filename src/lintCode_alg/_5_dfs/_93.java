package lintCode_alg._5_dfs;

import common.NodeClass.TreeNode;

/**
 * Given a binary tree, determine if it is height-balanced.
 *
 * <p>For this problem, a height-balanced binary tree is defined as a binary tree in which the depth
 * of the two subtrees of every node never differ by more than 1.
 */
public class _93 {
    public boolean isBalanced(TreeNode root) {
        return getResult(root).isBalanced;
    }

    private Result getResult(TreeNode node) {
        if (node == null) {
            return new Result(0, true);
        }

        Result left = getResult(node.left);
        Result right = getResult(node.right);

        if (!left.isBalanced || !right.isBalanced || Math.abs(left.h - right.h) > 1) {
            return new Result(-1, false);
        }

        return new Result(Math.max(left.h, right.h) + 1, true);
    }

    class Result {
        int h;
        boolean isBalanced;

        public Result(int h, boolean isBalanced) {
            this.h = h;
            this.isBalanced = isBalanced;
        }
    }
}
