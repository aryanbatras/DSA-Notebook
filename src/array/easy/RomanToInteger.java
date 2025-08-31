package array.easy;

public class RomanToInteger {
    // https://leetcode.com/problems/roman-to-integer/
    // 13. Roman to Integer

    // Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.
    // Symbol       Value
    // I             1
    // V             5
    // X             10
    // L             50
    // C             100
    // D             500
    // M             1000
    // For example, 2 is written as II in Roman numeral, just two one's added together. 12 is written as XII, which is simply X + II. The number 27 is written as XXVII, which is XX + V + II.
    // Roman numbers are used to represent numbers in the range 1 to 3999.
    // Given a roman numeral, convert it to an integer.
    public static int romanToInt(String s){
        int e = 0;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == 'I') e += 1;
            else if(s.charAt(i) == 'V'){
             if(i > 0 && s.charAt(i - 1) == 'I') e += 3;
             else e += 5;
            }
            else if(s.charAt(i) == 'X'){
              if(i > 0 && s.charAt(i - 1) == 'I') e += 8;
              else e += 10;
            }
            else if(s.charAt(i) == 'L'){
              if(i > 0 && s.charAt(i - 1) == 'X') e += 30;
              else e += 50;
            }
            else if(s.charAt(i) == 'C'){
              if(i > 0 && s.charAt(i - 1) == 'X') e += 80;
              else e += 100;
            }
            else if(s.charAt(i) == 'D'){
                if(i > 0 &&s.charAt(i - 1) == 'C') e += 300;
                else e += 500;
            }
            else if(s.charAt(i) == 'M'){
                if(i > 0 &&s.charAt(i - 1) == 'C') e += 800;
                else e += 1000;
            }
        }
        return e;
    }
    public static void main(String[] args) {
        String s = "MCMXCIV"; // 1994
        System.out.println(romanToInt(s));
        String s1 = "LVIII"; // 58
        System.out.println(romanToInt(s1));
        String s2 = "IX"; // 9
        System.out.println(romanToInt(s2));
        String s3 = "XXI"; // 21
        System.out.println(romanToInt(s3));

    }
}
