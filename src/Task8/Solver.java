package Task8;

public class Solver {
    public static void solve(int[][] matrix) {
        int minColInd = 0, maxColInd = 0;
        int maxEl = -9999999, minEl = 9999999;
        for (int j = matrix[0].length - 1; j >= 0; j--) {
            for (int i = 0; i < matrix.length; i++) {
                if (matrix[i][j] < minEl) {
                    minEl = matrix[i][j];
                    minColInd = j;
                }
            }
        }
        for (int j = 0; j < matrix[0].length; j++) {
            for (int i = 0; i < matrix.length; i++) {
                if (matrix[i][j] > maxEl) {
                    maxEl = matrix[i][j];
                    maxColInd = j;
                }
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            int tmp = matrix[i][maxColInd];
            matrix[i][maxColInd] = matrix[i][minColInd];
            matrix[i][minColInd] = tmp;
        }
    }
}
