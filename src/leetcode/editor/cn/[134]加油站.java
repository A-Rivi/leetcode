package leetcode.editor.cn;

//在一条环路上有 N 个加油站，其中第 i 个加油站有汽油 gas[i] 升。 
//
// 你有一辆油箱容量无限的的汽车，从第 i 个加油站开往第 i+1 个加油站需要消耗汽油 cost[i] 升。你从其中的一个加油站出发，开始时油箱为空。 
//
// 如果你可以绕环路行驶一周，则返回出发时加油站的编号，否则返回 -1。 
//
// 说明: 
//
// 
// 如果题目有解，该答案即为唯一答案。 
// 输入数组均为非空数组，且长度相同。 
// 输入数组中的元素均为非负数。 
// 
//
// 示例 1: 
//
// 输入: 
//gas  = [1,2,3,4,5]
//cost = [3,4,5,1,2]
//
//输出: 3
//
//解释:
//从 3 号加油站(索引为 3 处)出发，可获得 4 升汽油。此时油箱有 = 0 + 4 = 4 升汽油
//开往 4 号加油站，此时油箱有 4 - 1 + 5 = 8 升汽油
//开往 0 号加油站，此时油箱有 8 - 2 + 1 = 7 升汽油
//开往 1 号加油站，此时油箱有 7 - 3 + 2 = 6 升汽油
//开往 2 号加油站，此时油箱有 6 - 4 + 3 = 5 升汽油
//开往 3 号加油站，你需要消耗 5 升汽油，正好足够你返回到 3 号加油站。
//因此，3 可为起始索引。 
//
// 示例 2: 
//
// 输入: 
//gas  = [2,3,4]
//cost = [3,4,3]
//
//输出: -1
//
//解释:
//你不能从 0 号或 1 号加油站出发，因为没有足够的汽油可以让你行驶到下一个加油站。
//我们从 2 号加油站出发，可以获得 4 升汽油。 此时油箱有 = 0 + 4 = 4 升汽油
//开往 0 号加油站，此时油箱有 4 - 3 + 2 = 3 升汽油
//开往 1 号加油站，此时油箱有 3 - 3 + 3 = 3 升汽油
//你无法返回 2 号加油站，因为返程需要消耗 4 升汽油，但是你的油箱只有 3 升汽油。
//因此，无论怎样，你都不可能绕环路行驶一周。 
// Related Topics 贪心算法 
// 👍 631 👎 0

class GasStation {
    public static void main(String[] args) {
        Solution solution = new GasStation().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //@End: 2021-04-21 10:58
        /**
         * @Time: n
         * @Space: 1
         * @Author: 赖锦帆
         * @Date: 2021-04-21 10:58
         * 1数学原理,从问题中抽离出 x到y可达的数学表达
         * 2x最后可达y，则xy之间的元素最多可达y，则下一个从y+1开始试图一圈
         */
        public int canCompleteCircuit(int[] gas, int[] cost) {
            int n = gas.length;
            int i = 0;
            while (i < n) {
                int sumCost = 0, sumGas = 0;
                int cnt = 0;
                //从当前i开始走一圈，直到没油或者走到
                while (cnt < n) {
                    int j = (i + cnt) % n;
                    sumCost += cost[j];
                    sumGas += gas[j];
                    if (sumCost > sumGas) {
                        break;
                    }
                    cnt++;
                }
                //如果走到
                if (cnt == n) {
                    return i;
                } else {
                    //如果没走到，则取i走到的最后一个加油站的下一个开始
                    i = i + cnt + 1;
                }
            }
            return -1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
