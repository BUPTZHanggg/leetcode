package common;

/**
 * @author zhaohang <zhaohang06@kuaishou.com>
 * Created on 2022-03-31
 */
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    TreeNode() {}
    public TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    /**
     *       2
     *      / \
     *    3    4
     *   / \
     *  1   6
     * @return
     */
    public static TreeNode commonTree() {
        TreeNode root = new TreeNode(2);
        TreeNode rootLeft = new TreeNode(3, new TreeNode(1), new TreeNode(6));
        TreeNode rootRight = new TreeNode(4);
        root.left = rootLeft;
        root.right = rootRight;
        return root;
    }
}
