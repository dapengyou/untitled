package arithmetic;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author lady_zhou
 * @date 创建时间: 2019/1/8
 * @Description 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。
 * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
 */
public class class_03 {

    public static void main(String[] args) {
        int pre[] = {1, 2, 4, 7, 3, 5, 6, 8};
        int in[] = {4, 7, 2, 1, 5, 3, 8, 6};

        class_03 class_03 = new class_03();
        class_03.reConstructBinaryTree(pre, in);


    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }


    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        if (pre == null || in == null) {
            return null;
        }

        //递归
        TreeNode root = reConstructBinaryTree(pre, 0, pre.length - 1, in, 0, in.length - 1);
        return root;
    }

    public TreeNode reConstructBinaryTree(int[] pre, int startPre, int endPre, int[] in, int startIn, int endIn) {
        if (startPre > endPre || startIn > endIn) {
            return null;
        }
        TreeNode root = new TreeNode(pre[startPre]);
        for (int i = startIn; i <= endIn; i++) {
            if (in[i] == pre[startPre]) {
                root.left = reConstructBinaryTree(pre, startPre + 1,
                        startPre + i - startIn, in, startIn, i - 1);
                root.right = reConstructBinaryTree(pre, i + startPre - startIn + 1,
                        endPre, in, i + 1, endIn);
                break;
            }

        }
        List list = new ArrayList();
        list.add(root.val);

        System.out.print(list);
        return root;
    }

}
