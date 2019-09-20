package leetCode;

import java.util.ArrayList;
import java.util.List;

public class num_54_Spiral_Matrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<Integer>();
        if (matrix.length == 0) {
            return res;
        }
        int R = matrix.length, C = matrix[0].length;
        boolean[][] seen = new boolean[R][C];
        int[] dR = {0, 1, 0, -1};//右，下，左，上
        int[] dC = {1, 0, -1, 0};
        int r = 0, c = 0, di = 0;
        for (int i = 0; i < R * C; i++) {
            res.add(matrix[r][c]);
            seen[r][c] = true;
            int cR = r + dR[di];//current row
            int cC = c + dC[di];//current column
            if (0 <= cR && cR < R && 0 <= cC && cC < C && !seen[cR][cC]) {
                r = cR;
                c = cC;
            } else {
                di = (di + 1) % 4;//di + 1换方向，di不超过3，因为dR数组下标不超过3
                r += dR[di];
                c += dC[di];
            }
        }
        return res;
    }
}
