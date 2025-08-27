public class NumberOfValidClockTimes {
    public static int countTime(String time) {

       // one time '?'
        if(time.charAt(0) == '?' && time.charAt(1) != '?' && time.charAt(3) != '?' && time.charAt(4) != '?') {
            if(time.charAt(1) < '4' || time.charAt(1) < '5' && time.charAt(3) == '0' && time.charAt(4) == '0') {
                return 3;
            } else {
                return 2;
            }
        } else if(time.charAt(0) != '?' && time.charAt(1) == '?' && time.charAt(3) != '?' && time.charAt(4) != '?') {
            if(time.charAt(0) < '2'){
                return 10;
            } else if(time.charAt(0) == '2') {
                return 4;
            }
        } else if(time.charAt(0) != '?' && time.charAt(1) != '?' && time.charAt(3) == '?' && time.charAt(4) != '?') {
            return 6;
        } else if(time.charAt(0) != '?' && time.charAt(1) != '?' && time.charAt(3) != '?' && time.charAt(4) == '?') {
            return 10;
        }

        // only two times '?'
        if(time.charAt(0) == '?' && time.charAt(1) == '?' && time.charAt(3) != '?' && time.charAt(4) != '?') {
            return 24;
        } else if(time.charAt(0) == '?' && time.charAt(1) != '?' && time.charAt(3) == '?' && time.charAt(4) != '?') {
            if(time.charAt(1) < '4' || time.charAt(1) < '5' && time.charAt(4) == '0') {
                return 3 * 6;
            } else {
                return 2 * 6;
            }
        } else if(time.charAt(0) == '?' && time.charAt(1) != '?' && time.charAt(3) != '?' && time.charAt(4) == '?') {
            if( time.charAt(1) < '4' || time.charAt(1) < '5' && time.charAt(3) == '0') {
                return 3 * 10;
            } else {
                return 2 * 10;
            }
        } else if(time.charAt(0) != '?' && time.charAt(1) == '?' && time.charAt(3) == '?' && time.charAt(4) != '?') {
            if(time.charAt(0) < '2'){
                return 10 * 6;
            } else if(time.charAt(0) == '2') {
                return 4 * 6;
            }
        } else if(time.charAt(0) != '?' && time.charAt(1) == '?' && time.charAt(3) != '?' && time.charAt(4) == '?') {
            if(time.charAt(0) < '2'){
                return 10 * 10;
            } else if(time.charAt(0) == '2') {
                return 4 * 10;
            }
        } else if(time.charAt(0) != '?' && time.charAt(1) != '?' && time.charAt(3) == '?' && time.charAt(4) == '?') {
            return 60;
        }

        // only three times '?'
         if(time.charAt(0) == '?' && time.charAt(1) == '?' && time.charAt(3) == '?' && time.charAt(4) != '?') {
            return 24 * 6;
        } else if(time.charAt(0) == '?' && time.charAt(1) == '?' && time.charAt(3) != '?' && time.charAt(4) == '?') {
            return 24 * 10;
        } else if(time.charAt(0) == '?' && time.charAt(1) != '?' && time.charAt(3) == '?' && time.charAt(4) == '?') {
            if(time.charAt(1) < '4'){
                return 60 * 3;
            } else {
                return 60 * 2;
            }
        } else if(time.charAt(0) != '?' && time.charAt(1) == '?' && time.charAt(3) == '?' && time.charAt(4) == '?') {
            if(time.charAt(0) < '2'){
                return 60 * 10;
            } else if(time.charAt(0) == '2') {
                return 60 * 4;
            }
        }

         // only four times '?'
         if(time.charAt(0) == '?' && time.charAt(1) == '?' && time.charAt(3) == '?' && time.charAt(4) == '?') {
            return 24 * 60;
        }

        return 1;
    }
    public static void main(String[] args) {
        System.out.println(
                countTime("?5:00")
        );
        System.out.println(
                countTime("0?:0?")
        );
        System.out.println(
                countTime("??:??")
        );
        System.out.println(
                countTime("07:?3")
        );
    }
}
