package leetcode.editor.cn;

//给定一个二叉树，返回它的 后序 遍历。 
//
// 示例: 
//
// 输入: [1,null,2,3]  
//   1
//    \
//     2
//    /
//   3 
//
//输出: [3,2,1] 
//
// 进阶: 递归算法很简单，你可以通过迭代算法完成吗？ 
// Related Topics 栈 树 
// 👍 564 👎 0

import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

class BinaryTreePostorderTraversal{
  public static void main(String[] args) {
     Solution solution = new BinaryTreePostorderTraversal().new Solution();

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
    TreeNode makeTree(){
        Scanner scanner = new Scanner(System.in);
        TreeNode root = new TreeNode(scanner.nextInt());
        TreeNode l;
        TreeNode r = null,tmp;
        tmp = root;
        while (scanner.hasNext()){
            l = new TreeNode(scanner.nextInt());
            if (scanner.hasNext())
                r = new TreeNode(scanner.nextInt());
            tmp.left = l;
            tmp.right = r;
            tmp = tmp.left;
        }
        return root;
    }
}

class Solution {
      //左 --> 右 --> 中
      // time: O(n)
      // space:O(n)
    public List<Integer> postorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        LinkedList<Integer> list = new LinkedList<>();
        TreeNode tmp = root;
        while (!stack.isEmpty()||tmp!=null){
            if (tmp!=null){
                //当前不为空(tmp继续向右，一边向右一边访问)
                //tmp入栈，val倒着放入结果，进入tmp.right
                stack.push(tmp);
                list.addFirst(tmp.val);
                tmp = tmp.right;
            }else{
                //当前为空(tmp需要回退至最后入栈结点)
                //stack弹出栈顶至node，tmp回退到node.left
                TreeNode node = stack.pop();
                tmp = node.left;
            }
        }
        return list;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
