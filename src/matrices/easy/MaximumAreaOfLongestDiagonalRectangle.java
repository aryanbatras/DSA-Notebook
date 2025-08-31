package matrices.easy;

public class MaximumAreaOfLongestDiagonalRectangle {
    // 3000. Maximum Area of Longest Diagonal Rectangle
    // https://leetcode.com/problems/maximum-area-of-longest-diagonal-rectangle/
    // Easy
    // Tags: Greedy, Matrix
    public static int maximalRectangle(int[][] dimensions) {
        int l = 0;
        int w = 0;
        int area = 0;
        double dia = 0;
        double maxDia = Integer.MIN_VALUE;
        for(int i = 0; i < dimensions.length; i++){
            l = dimensions[i][0];
            w = dimensions[i][1];
            dia = Math.sqrt((l * l) + (w * w));
            if(dia > maxDia){
                maxDia = dia;
                area = l * w;
            }
            else if (dia == maxDia){
                if(l * w > area){
                    area = l * w;
                }
            }
        }
        return area;
    }
    public static void main(String[] args) {
        int[][] mat = {
                {9,3},
                {8,6}
        };
        System.out.println(maximalRectangle(mat));
        int[][] mat1 = {
                {3,4},
                {4,3}
        };
        System.out.println(maximalRectangle(mat1));
        int[][] mat2 = {
                {1,0,1,0,0},
                {1,0,1,1,1},
                {1,1,1,1,1},
                {1,0,0,1,0}
        };
        System.out.println(maximalRectangle(mat2));
        int[][] mat3 = {
                {1,1,1,1,1},
                {1,1,1,1,1},
                {1,1,1,1,1},
                {1,1,1,1,1}
        };
        System.out.println(maximalRectangle(mat3));

        System.out.println();
    }
}
