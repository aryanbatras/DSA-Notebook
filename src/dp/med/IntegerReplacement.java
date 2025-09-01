package dp.med;

public class IntegerReplacement {
    // 397. Integer Replacement
    public static int integerReplacement(long n) {
        if(n == 1) return 0;
        if(n % 2 == 0) return 1 + integerReplacement(n / 2);
        else return Math.min(1 + integerReplacement(n + 1), 1 + integerReplacement(n - 1));
    }
    public static void main(String[] args) {
        System.out.println(integerReplacement(8));
        System.out.println(integerReplacement(7));
        System.out.println(integerReplacement(4));
        System.out.println(integerReplacement(10000));
    }
}
