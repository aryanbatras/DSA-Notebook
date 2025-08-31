package array.med;

public class ReverseInteger {
    // 7. Reverse Integer
    // https://leetcode.com/problems/reverse-integer/
    // Medium
    // Tags: Array, Math

//    public static int reverse(int x) {
//        boolean minus = false;
//        if(x < 0) minus = true;
//        String s = String.valueOf(Math.abs(x));
//        String r = reverseString(s);
//        int rev = Integer.parseUnsignedInt(r);
//        if(rev > Integer.MAX_VALUE) return 0;
//        if(minus) return -rev;
//        else return rev;
//    }
//    public static String reverseString(String s) {
//        StringBuilder sb = new StringBuilder(s);
//        return sb.reverse().toString();
//    }

    public static int reverse(int x) {
        long rev = 0;
        while(x != 0){
            int pop = x % 10;
            x /= 10;
            rev = rev * 10 + pop;
        }
        if (rev > Integer.MAX_VALUE || rev < Integer.MIN_VALUE) return 0;
        return (int) rev;
    }

    public static void main(String[] args) {
        int x3 = 1534236469;
        System.out.println(new ReverseInteger().reverse(x3));
        int x = 123;
        System.out.println(new ReverseInteger().reverse(x));
        int x1 = -123;
        System.out.println(new ReverseInteger().reverse(x1));
        int x2 = 120;
        System.out.println(new ReverseInteger().reverse(x2));
    }
}