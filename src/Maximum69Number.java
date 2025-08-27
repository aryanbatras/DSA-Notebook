public class Maximum69Number {
    public static int maximum69Number (int num) {
        String s = String.valueOf(num);
        for(int e = 0; e < s.length(); e++){
            if(s.charAt(e) == '6') {
                s = s.replaceFirst("6", "9");
                return Integer.parseInt(s);
            }
        }
        return Integer.parseInt(s);
    }

    public static void main(String[] args) {
        System.out.println(
                maximum69Number(9669)
        );
        System.out.println(
                maximum69Number(9996)
        );
        System.out.println(
                maximum69Number(9999)
        );
    }
}
