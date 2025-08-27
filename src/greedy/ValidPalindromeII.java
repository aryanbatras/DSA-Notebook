package greedy;

public class ValidPalindromeII {
//    public static boolean validPalindrome(String s) {
//        char[] original = s.toCharArray();
//        char[] arr = s.toCharArray();
//        Arrays.sort(arr);
//        Stack<Character> stack = new Stack<>();
//        for(int e = 0; e < arr. length; e++){
//            if(stack.isEmpty()){
//                stack.push(arr[e]);
//            } else {
//
//                if(stack.peek() == arr[e]) {
//                    stack.pop();
//                } else {
//                    stack.push(arr[e]);
//                }
//
//            }
//        }
//        if(stack.size() <= 2) {
//            if(stack.size() == 2){
//                char a = stack.pop();
//                char b = stack.pop();
//                if(a == original[original.length / 2] && b == original[(original.length / 2) - 1]
//                        || a == original[( original.length / 2 )- 1] && b == original[original.length / 2]){
//                    return true;
//                } else if(original.length % 2 != 0 && a == original[original.length / 2] ||  b == original[original.length / 2]){
//                    return true;
//                } else {
//                return false;
//                }
//            }
//            return true;
//        } else {
//            return false;
//        }
//    }

    public static boolean validPalindrome(String s) {
        int skipper = 0;
        int l = 0, r = s.length() - 1;
        while(l < r){
            if(s.charAt(l) == s.charAt(r)){
                l++; r--;
            } else if(s.charAt(l) != s.charAt(r)){
                if(l + 1 == r || l == r - 1) {
                    return true;
                } else {
                    if(skipper == 0){
                        skipper++;
                        l++;
                        r--;
                        continue;
                    }
                    return false;
                }
            }
        }
        return true;
    }
    public static void main(String[] args) {
        System.out.println(
                validPalindrome("deeee")
        );
        System.out.println(
                validPalindrome("zryxeededexyz")
        );
        System.out.println(
                validPalindrome("tebbem")
        );
        System.out.println(
                validPalindrome("aba")
        );
        System.out.println(
                validPalindrome("abca")
        );
        System.out.println(
                validPalindrome("abc")
        );
        System.out.println(
                validPalindrome("abccba")
        );
        System.out.println(
                validPalindrome("abcba")
        );
        System.out.println(
                validPalindrome("abcbaa")
        );
    }

}
