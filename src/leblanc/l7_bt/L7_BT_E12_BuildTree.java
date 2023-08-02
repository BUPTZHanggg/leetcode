package leblanc.l7_bt;

import common.TreeNode;

/**
 * LC106
 * 给定两个整数数组 inorder 和 postorder
 * 其中 inorder 是二叉树的中序遍历， postorder 是同一棵树的后序遍历
 * 请你构造并返回这颗二叉树。

 * @author zhaohang <zhaohang06@kuaishou.com>
 * Created on 2022-10-24
 */
public class L7_BT_E12_BuildTree {

    public static void main(String[] args) {
        int[] ints = {9, 3, 15, 20, 7};
        int[] ints1 = {9,15,7,20,3};
        L7_BT_E12_BuildTree cl = new L7_BT_E12_BuildTree();
        TreeNode node = cl.buildTree(ints, ints1);

    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder.length == 0) {
            return null;
        }
        return buildTree(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }

    public TreeNode buildTree(int[] inorder, int inLeft, int inRight, int[] postorder, int posLeft, int posRight) {
        if (inLeft > inRight) {
            return null;
        }
        int currRoot = postorder[posRight];
        TreeNode root = new TreeNode(currRoot);
        int rootIndex = inLeft;
        while (rootIndex <= inRight) {
            if (inorder[rootIndex] == currRoot) {
                break;
            }
            rootIndex++;
        }
        int leftCount = rootIndex - inLeft;
        root.left = buildTree(inorder, inLeft, rootIndex - 1, postorder, posLeft, posLeft + leftCount - 1);
        root.right = buildTree(inorder, rootIndex + 1, inRight, postorder, posLeft + leftCount, posRight - 1);
        return root;
    }
}
