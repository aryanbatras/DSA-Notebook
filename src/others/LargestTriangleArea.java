package others;

public class LargestTriangleArea {
    public static double largestTriangleArea(int[][] points) {
        double ans = 0;
        for(int i = 0; i < points.length - 2; i++){
            for(int j = i + 1; j < points.length - 1; j++){
                for(int k = j + 1; k < points.length; k++){
                    double area = Math.abs((1.0/2) * (points[i][0] * (points[j][1] - points[k][1]) + points[j][0] * (points[k][1] - points[i][1]) + points[k][0] * (points[i][1] - points[j][1])));
                    ans = Math.max(ans, area);
                }
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        System.out.println(
                largestTriangleArea(
                        new int[][]{{0,0},{0,1},{1,0},{0,2},{2,0}}
                )
        );
        System.out.println(
                largestTriangleArea(
                        new int[][]{{1,0},{0,0},{0,1}}
                )
        );
    }
}
