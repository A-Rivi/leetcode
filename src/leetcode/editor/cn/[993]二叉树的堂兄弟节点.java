package leetcode.editor.cn;

//在二叉树中，根节点位于深度 0 处，每个深度为 k 的节点的子节点位于深度 k+1 处。 
//
// 如果二叉树的两个节点深度相同，但 父节点不同 ，则它们是一对堂兄弟节点。 
//
// 我们给出了具有唯一值的二叉树的根节点 root ，以及树中两个不同节点的值 x 和 y 。 
//
// 只有与值 x 和 y 对应的节点是堂兄弟节点时，才返回 true 。否则，返回 false。 
//
// 
//
// 示例 1： 
// 
//
// 
//输入：root = [1,2,3,4], x = 4, y = 3
//输出：false
// 
//
// 示例 2： 
// 
//
// 
//输入：root = [1,2,3,null,4,null,5], x = 5, y = 4
//输出：true
// 
//
// 示例 3： 
//
// 
//
// 
//输入：root = [1,2,3,null,4], x = 2, y = 3
//输出：false 
//
// 
//
// 提示： 
//
// 
// 二叉树的节点数介于 2 到 100 之间。 
// 每个节点的值都是唯一的、范围为 1 到 100 的整数。 
// 
//
// 
// Related Topics 树 广度优先搜索 
// 👍 125 👎 0

import entity.TreeNode;

import java.util.*;

class CousinsInBinaryTree{
  public static void main(String[] args) {
     Solution solution = new CousinsInBinaryTree().new Solution();
     
  }
//leetcode submit region begin(Prohibit modification and deletion)


//class TreeNode {
//    int val;
//    TreeNode left;
//    TreeNode right;
//    TreeNode() {}
//    TreeNode(int val) { this.val = val; }
//    TreeNode(int val, TreeNode left, TreeNode right) {
//        this.val = val;
//        this.left = left;
//        this.right = right;
//    }
//}
//O(n) O(n)
class Solution {
    public boolean isCousins(TreeNode root, int x, int y) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        Map<TreeNode,TreeNode> treeMap = new HashMap<>();
        while (!queue.isEmpty()){
            int size = queue.size();
            HashMap<Integer,TreeNode> map = new HashMap<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                map.put(node.val,node);
                if (node.left!=null){
                    queue.offer(node.left);
                    treeMap.put(node.left,node);
                }
                if (node.right!=null){
                    queue.offer(node.right);
                    treeMap.put(node.right,node);
                }
            }
            TreeNode xNode = map.get(x);
            TreeNode yNode = map.get(y);
            if (xNode !=null&& yNode !=null&&treeMap.get(xNode)!=treeMap.get(yNode))
                return true;
            else if (xNode !=null|| yNode !=null)
                return false;
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
