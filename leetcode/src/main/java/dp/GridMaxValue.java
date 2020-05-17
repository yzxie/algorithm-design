package dp;

/**
 * Author: xieyizun
 * Version: 1.0
 * Date: 2020/5/18
 * Description: https://leetcode-cn.com/problems/li-wu-de-zui-da-jie-zhi-lcof/
 **/
public class GridMaxValue {
    public int maxValue(int[][] grid) {
        // 向右移动n格，向下移动m格
        // 每一格只能向右或向下，dp[i][j]表示到达第i行，第j列的格子时，获取到的最大价值
        // dp[i][j] = max(dp[i][j-1], dp[i-1][j]) + grip[i][j], i >= 1, j >= 1
        // dp[0][0] = grip[0][0], dp[i][0], d[0][j]

        int m = grid.length;
        int n = grid[0].length;

        int[][] dp = new int[m][n];
        dp[0][0] = grid[0][0];

        for (int j = 1; j < n; j++) {
            dp[0][j] = dp[0][j-1] + grid[0][j];
        }

        for (int i = 1; i < m; i++) {
            dp[i][0] = dp[i-1][0] + grid[i][0];
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]) + grid[i][j];
            }
        }

        return dp[m-1][n-1];
    }
}
