package greedy;

public class GCDOfOddAndEvenSums {
    public static int gcdOfOddAndEvenSums(int n) {
        int sumOdd = 0;
        int sumEven = 0;
        int oddDiff = 1;
        int sumDiff = 2;
        // 4
        for (int e = n; e > 0; e--) {
            sumOdd += oddDiff; // 1 + 3 + 5 + 7 = 16
            oddDiff = (oddDiff + 2); // 1,3,5,7
            sumEven += sumDiff; // 2 + 4 + 6 + 8 = 20
            sumDiff = (sumDiff + 2); // 2,4,6,8
        }
        System.out.println(sumOdd + " " + sumEven);
        return gcd(sumOdd, sumEven);
    }

    private static int gcd(int sumOdd, int sumEven) {
        int min = Math.min(sumOdd, sumEven);
        for (int e = min; e > 0; e--) {
            if (sumOdd % e == 0 && sumEven % e == 0) {
                return e;
            }
        }
        return 1;
    }

    public static void main(String[] args) {
        System.out.println(
                gcdOfOddAndEvenSums(46)
        );
        System.out.println(
                gcdOfOddAndEvenSums(999)
        );
        System.out.println(
                gcdOfOddAndEvenSums(500)
        );
        System.out.println(
                gcdOfOddAndEvenSums(234)
        );
        System.out.println(
                gcdOfOddAndEvenSums(345)
        );
        System.out.println(
                gcdOfOddAndEvenSums(123)
        );
        System.out.println(
                gcdOfOddAndEvenSums(4)
        );
        System.out.println(
                gcdOfOddAndEvenSums(5)
        );
    }
}
