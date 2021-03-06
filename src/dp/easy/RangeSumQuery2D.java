package dp.easy;
//304. Range Sum Query 2D - Immutable
/*
Given a 2D matrix matrix, find the sum of the elements inside the rectangle
defined by its upper left corner (row1, col1) and lower right corner (row2, col2).
*/
public class RangeSumQuery2D {
    int[][] dp;
    public RangeSumQuery2D(int[][] matrix) {
        if(matrix==null || matrix.length==0 || matrix[0].length==0)
            return;
        dp = new int[matrix.length+1][matrix[0].length+1];

        // dp[i][j] 表示 [0][0] - [i][j]矩阵的所有元素sum
        for (int i=1; i<=dp.length; i++)
            for (int j=1; j<= dp[0].length; j++)
                dp[i][j] = dp[i-1][j] + dp[i][j-1] - dp[i-1][j-1] + matrix[i-1][j-1];
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int iMin = Math.min(row1, row2);
        int iMax = Math.max(row1, row2);

        int jMin = Math.min(col1, col2);
        int jMax = Math.max(col1, col2);

        return dp[iMax + 1][jMax + 1] - dp[iMax + 1][jMin] - dp[iMin][jMax + 1] + dp[iMin][jMin];
//        return dp[row2+1][col2+1] - dp[row1][col2] - dp[row2][col1] + dp[row1][col1];
    }
}
