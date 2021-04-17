package leetcode.editor.cn;

//给你一个 只包含正整数 的 非空 数组 nums 。请你判断是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,5,11,5]
//输出：true
//解释：数组可以分割成 [1, 5, 5] 和 [11] 。 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,3,5]
//输出：false
//解释：数组不能分割成两个元素和相等的子集。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 200 
// 1 <= nums[i] <= 100 
// 
// Related Topics 动态规划 
// 👍 748 👎 0

import java.util.HashMap;

class PartitionEqualSubsetSum {
    public static void main(String[] args) {
        Solution solution = new PartitionEqualSubsetSum().new Solution();
        int[] nums = {1,1};
        System.out.println(solution.canPartition(nums));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        boolean[][] dp;
        /**
         * @TimeComplexity: nm
         * @SpaceComplexity: nm
         * @Author: 赖锦帆
         * @Date: 2021-04-17
         */
        public boolean canPartition(int[] nums) {
            //A问题转化，集合划分问题转化简单背包问题

            int sum = 0;
            for (int num : nums) {
                sum += num;
            }
            //B.特殊输入处理
            /**
             * bug1
             */
            if (sum % 2 != 0)
                return false;
            /**
             * bug2
             */
            sum /= 2;//sum:数组和的一半，即当前简单背包问题要求的目标容量大小

            //C. dp
            //1.dp[i][j]对前i个物品，能否有一种选择恰好装满j容量背包
            //2.两种选择装，不装
            //3.状态转移
            //求dp[nums.length][sum]
            dp = new boolean[nums.length+1][sum+1];
            //base case
            for (int i = 0; i < nums.length; i++) {
                dp[i][0] = true;
            }
            //dp
            for (int i = 1; i <= nums.length; i++) {
                for (int j = 1; j <= sum; j++){
                    //有一种选择恰好装满即true
                    //考虑数组越界，分类
                    if (j-nums[i-1]<0){
                        //背包容量不足以装下当前nums[i-1]重量的物品i
                        dp[i][j] = dp[i-1][j];
                    }else {
                        //背包装得下物品i
                        dp[i][j] = dp[i-1][j] || dp[i-1][j-nums[i-1]];
                    }
                }
            }
            return dp[nums.length][sum];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
