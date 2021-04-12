package leetcode.editor.cn;

//给你二叉树的根节点 root ，返回它节点值的 前序 遍历。 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [1,null,2,3]
//输出：[1,2,3]
// 
//
// 示例 2： 
//
// 
//输入：root = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：root = [1]
//输出：[1]
// 
//
// 示例 4： 
//
// 
//输入：root = [1,2]
//输出：[1,2]
// 
//
// 示例 5： 
//
// 
//输入：root = [1,null,2]
//输出：[1,2]
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数目在范围 [0, 100] 内 
// -100 <= Node.val <= 100 
// 
//
// 
//
// 进阶：递归算法很简单，你可以通过迭代算法完成吗？ 
// Related Topics 栈 树 
// 👍 553 👎 0

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

class BinaryTreePreorderTraversal{
  public static void main(String[] args) {
     Solution solution = new BinaryTreePreorderTraversal().new Solution();
     
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
      //中 --> 左 -->右
      // time: O(n)
      // space:O(n)
    public List<Integer> preorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        LinkedList<Integer> list = new LinkedList<>();
        TreeNode tmp = root;
        while (!stack.isEmpty()||tmp!=null){
            if (tmp!=null){
            //当前不为空(tmp继续向左，一边向左一边访问)
            //tmp入栈，访问tmp，进入tmp.left
                list.add(tmp.val);
                stack.push(tmp);
                tmp = tmp.left;
            }else{
            //当前为空(tmp需要回退至最后入栈结点)
            //stack弹出栈顶至node，tmp回退到node.right
                TreeNode node = stack.pop();
                tmp = node.right;
            }
        }
        return list;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
