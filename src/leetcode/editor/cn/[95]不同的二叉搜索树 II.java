package leetcode.editor.cn;

//给定一个整数 n，生成所有由 1 ... n 为节点所组成的 二叉搜索树 。 
//
// 
//
// 示例： 
//
// 输入：3
//输出：
//[
//  [1,null,3,2],
//  [3,2,null,1],
//  [3,1,null,null,2],
//  [2,1,3],
//  [1,null,2,null,3]
//]
//解释：
//以上的输出对应以下 5 种不同结构的二叉搜索树：
//
//   1         3     3      2      1
//    \       /     /      / \      \
//     3     2     1      1   3      2
//    /     /       \                 \
//   2     1         2                 3
// 
//
// 
//
// 提示： 
//
// 
// 0 <= n <= 8 
// 
// Related Topics 树 动态规划 
// 👍 851 👎 0

import entity.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class UniqueBinarySearchTreesIi{
  public static void main(String[] args) {
     Solution solution = new UniqueBinarySearchTreesIi().new Solution();
     
  }
//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<TreeNode> generateTrees(int n) {
        if (n<1)
            return new ArrayList<>();
        List<TreeNode> res = helper(1,n);
        return res;
    }
    private List<TreeNode> helper(int start, int end){
        List<TreeNode> list = new LinkedList<>();
        if (start>end){
            list.add(null);
            return list;
        }
        for (int i=start;i<=end;i++){
            List<TreeNode> leftTree = helper(start, i - 1);
            List<TreeNode> rightTree = helper(i + 1, end);
            for (TreeNode l : leftTree) {
                for (TreeNode r : rightTree) {
                    TreeNode cur = new TreeNode(i);
                    cur.left = l;
                    cur.right = r;
                    list.add(cur);
                }
            }
        }
        return list;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
