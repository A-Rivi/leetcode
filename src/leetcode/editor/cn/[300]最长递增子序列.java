package leetcode.editor.cn;

//给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。 
//
// 子序列是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序
//列。 
// 
//
// 示例 1： 
//
// 
//输入：nums = [10,9,2,5,3,7,101,18]
//输出：4
//解释：最长递增子序列是 [2,3,7,101]，因此长度为 4 。
// 
//
// 示例 2： 
//
// 
//输入：nums = [0,1,0,3,2,3]
//输出：4
// 
//
// 示例 3： 
//
// 
//输入：nums = [7,7,7,7,7,7,7]
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 2500 
// -104 <= nums[i] <= 104 
// 
//
// 
//
// 进阶： 
//
// 
// 你可以设计时间复杂度为 O(n2) 的解决方案吗？ 
// 你能将算法的时间复杂度降低到 O(n log(n)) 吗? 
// 
// Related Topics 二分查找 动态规划 
// 👍 1543 👎 0

import java.util.Arrays;

class LongestIncreasingSubsequence{
  public static void main(String[] args) {
     Solution solution = new LongestIncreasingSubsequence().new Solution();
     
  }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
      /**
       * @Time: n^2
       * @Space: n
       * @Author: 赖锦帆
       * @Date: 2021-04-21 09:00
       * 关键在于定义dp[i]中状态i为 i结尾的子序列最大长度
       * 要思考：
       * 1状态（dp数组的参数有哪几个，几维）
       * 2dp[..]的含义
       * 3当前选择有哪些 ->状态转移是怎样的
       */
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp,1);
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j <=i; j++) {
                if (nums[j]<nums[i]){
                    dp[i] = Math.max(dp[i],dp[j]+1);
                }
            }
        }
        int maxLength = 0;
        for (int i = 0; i < dp.length; i++) {
            maxLength = Math.max(maxLength,dp[i]);
        }
        return maxLength;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
