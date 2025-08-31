package array.easy;

public class IntegerToRoman {
    public static String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();
        String s = String.valueOf(num);
        int placeValue = s.length();
        for(int e = 0; e < s.length(); e++){
            if(placeValue == 4){
                if(s.charAt(e) == '1') sb.append("M");
                else if(s.charAt(e) == '2') sb.append("MM");
                else if(s.charAt(e) == '3') sb.append("MMM");
            } else if(placeValue == 3){
                if(s.charAt(e) == '1') sb.append("C");
                else if(s.charAt(e) == '2') sb.append("CC");
                else if(s.charAt(e) == '3') sb.append("CCC");
                else if(s.charAt(e) == '4') sb.append("CD");
                else if(s.charAt(e) == '5') sb.append("D");
                else if(s.charAt(e) == '6') sb.append("DC");
                else if(s.charAt(e) == '7') sb.append("DCC");
                else if(s.charAt(e) == '8') sb.append("DCCC");
                else if(s.charAt(e) == '9') sb.append("CM");
            } else if(placeValue == 2){
                if(s.charAt(e) == '1') sb.append("X");
                else if(s.charAt(e) == '2') sb.append("XX");
                else if(s.charAt(e) == '3') sb.append("XXX");
                else if(s.charAt(e) == '4') sb.append("XL");
                else if(s.charAt(e) == '5') sb.append("L");
                else if(s.charAt(e) == '6') sb.append("LX");
                else if(s.charAt(e) == '7') sb.append("LXX");
                else if(s.charAt(e) == '8') sb.append("LXXX");
                else if(s.charAt(e) == '9') sb.append("XC");
            } else if(placeValue == 1){
                if(s.charAt(e) == '1') sb.append("I");
                else if(s.charAt(e) == '2') sb.append("II");
                else if(s.charAt(e) == '3') sb.append("III");
                else if(s.charAt(e) == '4') sb.append("IV");
                else if(s.charAt(e) == '5') sb.append("V");
                else if(s.charAt(e) == '6') sb.append("VI");
                else if(s.charAt(e) == '7') sb.append("VII");
                else if(s.charAt(e) == '8') sb.append("VIII");
                else if(s.charAt(e) == '9') sb.append("IX");
            }
            placeValue--;
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        System.out.println(intToRoman(3749));
        System.out.println(intToRoman(58));
        System.out.println(intToRoman(1994));
        System.out.println(intToRoman(9));
        System.out.println(intToRoman(4));
        System.out.println(intToRoman(40));
        System.out.println(intToRoman(2008));
    }

}
