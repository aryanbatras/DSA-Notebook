package string.easy;

import java.math.BigInteger;

public class LargestOddNumberInString {
    public String largestOddNumber(String num) {
        int e = num.length() - 1;
        while(num.charAt(e) % 2 == 0 && e > 0) e--;
        if(e == 0 && num.charAt(0) % 2 == 0) return "";
        else return num.substring(0, e + 1);
    }
    public static void main(String[] args) {
        String num = "52";
        System.out.println(new LargestOddNumberInString().largestOddNumber(num));
        String num1 = "4206";
        System.out.println(new LargestOddNumberInString().largestOddNumber(num1));
        String num2 = "35427";
        System.out.println(new LargestOddNumberInString().largestOddNumber(num2));
    }
}
