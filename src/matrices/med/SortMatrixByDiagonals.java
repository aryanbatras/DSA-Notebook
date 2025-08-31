package matrices.med;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SortMatrixByDiagonals {
    // Unsolved
    // 3446. Sort Matrix by Diagonals
    public int[][] diagonalSort(int[][] mat) {
        List<List<Integer>> l = new ArrayList<>(mat.length);
        for(int i = 0; i < mat.length; i++){
            for(int j = 0; j < mat[0].length; j++){
                if(i == j) l.get(0).add(mat[i][j]);
                if(j == i + 1) l.get(1).add(mat[i][j]);
                if(j == i - 1) l.get(2).add(mat[i][j]);
            }
        }
        l.sort((a, b) -> a.get(0).compareTo(b.get(0)));
        l.sort((b, a) -> a.get(1).compareTo(b.get(1)));
        l.sort((a, b) -> a.get(2).compareTo(b.get(2)));
        return null;
    }
    public static void main(String[] args) {
        int[][] mat = {{1, 7, 3}, {9, 8, 2}, {4, 5, 6}};
        System.out.println(new SortMatrixByDiagonals( ).diagonalSort(mat));
        int[][] mat1 = {{0,1},{1,2}};
        System.out.println(new SortMatrixByDiagonals( ).diagonalSort(mat1));
    }
}
