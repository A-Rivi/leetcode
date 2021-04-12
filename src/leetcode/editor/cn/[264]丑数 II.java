package leetcode.editor.cn;

//给你一个整数 n ，请你找出并返回第 n 个 丑数 。 
//
// 丑数 就是只包含质因数 2、3 和/或 5 的正整数。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 10
//输出：12
//解释：[1, 2, 3, 4, 5, 6, 8, 9, 10, 12] 是由前 10 个丑数组成的序列。
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：1
//解释：1 通常被视为丑数。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 1690 
// 
// Related Topics 堆 数学 动态规划 
// 👍 564 👎 0

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

class UglyNumberIi{
  public static void main(String[] args) {
     Solution solution = new UglyNumberIi().new Solution();
     solution.nthUglyNumber(10);
  }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int nthUglyNumber(int n) {
        int[] dp = new int[n];
        int two = 3,three = 2,five = 4;
        for (int i = 0; i < 5; i++) {
            dp[i] = i+1;
        }
        if (n<5) {
            return dp[n];
        } else{
            for (int i = 5; i <n ; i++) {
                List<Integer> list = new LinkedList<>();
                int[] nums = {dp[two]*2,dp[two]*3,dp[two]*5,dp[three]*2,dp[three]*3,dp[three]*5,dp[five]*2,dp[five]*3,dp[five]*5};
                int min = nums[0];
                int minIndex = 0;
                for (int i1 = 0; i1 < nums.length; i1++) {
                    if (nums[i1]<min){
                        min = nums[i1];
                        minIndex = i1;
                    }
                }
                dp[i] = min;
                if (minIndex/3==0)
                    two = minIndex;
                else if (minIndex/3==1)
                    three = minIndex;
                else five = minIndex;
            }
        }
        return dp[n-1];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
