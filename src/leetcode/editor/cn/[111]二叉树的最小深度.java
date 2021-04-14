package leetcode.editor.cn;

//给定一个二叉树，找出其最小深度。 
//
// 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。 
//
// 说明：叶子节点是指没有子节点的节点。 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [3,9,20,null,null,15,7]
//输出：2
// 
//
// 示例 2： 
//
// 
//输入：root = [2,null,3,null,4,null,5,null,6]
//输出：5
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数的范围在 [0, 105] 内 
// -1000 <= Node.val <= 1000 
// 
// Related Topics 树 深度优先搜索 广度优先搜索 
// 👍 487 👎 0

import java.util.LinkedList;
import java.util.Queue;

public class MinimumDepthOfBinaryTree{
  public static void main(String[] args) {
     Solution solution = new MinimumDepthOfBinaryTree().new Solution();
     
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
    public int minDepth(TreeNode root) {
         Queue<TreeNode> queue = new LinkedList<>();
         queue.offer(root);
         if (root==null)
             return 0;
         int depth = 0;
         while (!queue.isEmpty()){
             int size = queue.size();
             for (int i = 0; i < size; i++) {
                 TreeNode node = queue.poll();
                 if (node.left==null&&node.right==null)
                     return depth;
                 if (node.left!=null)
                     queue.offer(node.left);
                 if (node.right!=null)
                     queue.offer(node.right);
             }
             depth++;
         }
         return depth-1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
