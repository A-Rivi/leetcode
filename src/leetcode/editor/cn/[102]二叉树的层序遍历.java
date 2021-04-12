package leetcode.editor.cn;

//给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。 
//
// 
//
// 示例： 
//二叉树：[3,9,20,null,null,15,7], 
//
// 
//    3
//   / \
//  9  20
//    /  \
//   15   7
// 
//
// 返回其层序遍历结果： 
//
// 
//[
//  [3],
//  [9,20],
//  [15,7]
//]
// 
// Related Topics 树 广度优先搜索 
// 👍 834 👎 0


import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class BinaryTreeLevelOrderTraversal{
  public static void main(String[] args) {
     Solution solution = new BinaryTreeLevelOrderTraversal().new Solution();
     
  }
//leetcode submit region begin(Prohibit modification and deletion)

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> res = new LinkedList<>();
        if (root!=null)queue.offer(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            List<Integer> list = new LinkedList<>();
            for (int i=0;i<size;i++){
                //出队
                TreeNode node = queue.poll();
                //操作当前结点
                list.add(node.val);
                //邻接点入队
                if (node.left!=null)queue.offer(node.left);
                if (node.right!=null)queue.offer(node.right);
            }
            res.add(list);
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
