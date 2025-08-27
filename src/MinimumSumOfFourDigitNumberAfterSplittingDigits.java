public class MinimumSumOfFourDigitNumberAfterSplittingDigits {
    public static int minimumSum(int num) {
        int firstMin = Integer.MAX_VALUE, secondMin = Integer.MAX_VALUE;
        int firstMinIndex = -1, secondMinIndex = -1;
        String s = String.valueOf(num);
        for(int e = 0; e < s.length(); e++){
            int val = s.charAt(e) - '0';
            if(val < firstMin){
                secondMinIndex = firstMinIndex;
                secondMin = firstMin;
                firstMin = val;
                firstMinIndex = e;
            } else if (val < secondMin){
                secondMin = val;
                secondMinIndex = e;
            }
        }
        int t1 = 0, t2 = 0;
        for(int e = 0; e < s.length(); e++){
            if(e == firstMinIndex || e == secondMinIndex) continue;
            if(t1 == 0){
                t1 = s.charAt(e) - '0';
            } else {
                t2 = s.charAt(e) - '0';
            }
        }
        int num1 = ( ( s.charAt(firstMinIndex) - '0' ) * 10 ) + t1;
        int num2 = ( ( s.charAt(secondMinIndex) - '0' ) * 10 ) + t2;
        return num1 + num2;
    }
    public static void main(String[] args) {
        System.out.println(
                minimumSum(2932)
        );
        System.out.println(
                minimumSum(4009)
        );
    }
}
