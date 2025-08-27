public class LatestTimeByReplacingHiddenDigits {
    public static String maximumTime(String time) {
        // one time '?'
        if (time.charAt(0) == '?' && time.charAt(1) != '?' && time.charAt(3) != '?' && time.charAt(4) != '?') {
            if (time.charAt(1) < '4' || time.charAt(1) < '5' && time.charAt(3) == '0' && time.charAt(4) == '0') {
                return "2" + time.substring(1);
            } else {
                return "1" + time.substring(1);
            }
        } else if (time.charAt(0) != '?' && time.charAt(1) == '?' && time.charAt(3) != '?' && time.charAt(4) != '?') {
            if (time.charAt(0) < '2') {
                return time.substring(0, 1) + '9' + time.substring(2);
            } else if (time.charAt(0) == '2') {
                return time.substring(0, 1) + '3' + time.substring(2);
            }
        } else if (time.charAt(0) != '?' && time.charAt(1) != '?' && time.charAt(3) == '?' && time.charAt(4) != '?') {
            return time.substring(0, 3) + '5' + time.substring(4);
        } else if (time.charAt(0) != '?' && time.charAt(1) != '?' && time.charAt(3) != '?' && time.charAt(4) == '?') {
            return time.substring(0, 4) + '9';
        }

        // only two times '?'
        if (time.charAt(0) == '?' && time.charAt(1) == '?' && time.charAt(3) != '?' && time.charAt(4) != '?') {
            return "23" + time.substring(2);
        } else if (time.charAt(0) == '?' && time.charAt(1) != '?' && time.charAt(3) == '?' && time.charAt(4) != '?') {
            if (time.charAt(1) < '4') {
                return "2" + time.substring(1, 3) + "5" + time.substring(4);
            } else {
                return "1" + time.substring(1, 3) + "5" + time.substring(4);
            }
        } else if (time.charAt(0) == '?' && time.charAt(1) != '?' && time.charAt(3) != '?' && time.charAt(4) == '?') {
            if (time.charAt(1) < '4') {
                return '2' + time.substring(1, 4) + '9';
            } else {
                return '1' + time.substring(1, 4) + '9';
            }
        } else if (time.charAt(0) != '?' && time.charAt(1) == '?' && time.charAt(3) == '?' && time.charAt(4) != '?') {
            if (time.charAt(0) < '2') {
                return time.charAt(0) + "9:5" + time.substring(4);
            } else if (time.charAt(0) == '2') {
                return time.charAt(0) + "3:5" + time.substring(4);
            }
        } else if (time.charAt(0) != '?' && time.charAt(1) == '?' && time.charAt(3) != '?' && time.charAt(4) == '?') {
            if (time.charAt(0) < '2') {
                return time.charAt(0) + "9:" + time.charAt(3) + "9";
            } else if (time.charAt(0) == '2') {
                return time.charAt(0) + "3:" + time.charAt(3) + "9";
            }
        } else if (time.charAt(0) != '?' && time.charAt(1) != '?' && time.charAt(3) == '?' && time.charAt(4) == '?') {
            return time.charAt(0) + time.substring(1,2) + ":59";
        }

        // only three times '?'
        if (time.charAt(0) == '?' && time.charAt(1) == '?' && time.charAt(3) == '?' && time.charAt(4) != '?') {
            return "23:5" + time.substring(4);
        } else if (time.charAt(0) == '?' && time.charAt(1) == '?' && time.charAt(3) != '?' && time.charAt(4) == '?') {
            return "23:" + time.charAt(3) + "9";
        } else if (time.charAt(0) == '?' && time.charAt(1) != '?' && time.charAt(3) == '?' && time.charAt(4) == '?') {
            if (time.charAt(1) < '4') {
                return "2" + time.charAt(1) + ":59";
            } else {
                return "1" + time.charAt(1) + ":59";
            }
        } else if (time.charAt(0) != '?' && time.charAt(1) == '?' && time.charAt(3) == '?' && time.charAt(4) == '?') {
            if (time.charAt(0) < '2') {
                return time.charAt(0) + "9:59";
            } else if (time.charAt(0) == '2') {
                return time.charAt(0) + "3:59";
            }
        }

        // only four times '?'
        if (time.charAt(0) == '?' && time.charAt(1) == '?' && time.charAt(3) == '?' && time.charAt(4) == '?') {
            return "23:59";
        }

        return time;
    }

    public static void main(String[] args) {
        System.out.println(
                maximumTime("?1:2?")
        );
        System.out.println(
                maximumTime("00:??")
        );
        System.out.println(
                maximumTime("?0:30")
        );
        System.out.println(
                maximumTime("10:?2")
        );
        System.out.println(
                maximumTime("2?:03")
        );
        System.out.println(
                maximumTime("0?:3?")
        );
        System.out.println(
                maximumTime("1?:22")
        );
        System.out.println(
                maximumTime("1?:2?")
        );
        System.out.println(
                maximumTime("2?:3?")
        );
        System.out.println(
                maximumTime("2?:??")
        );
        System.out.println(
                maximumTime("??:5?")
        );
        System.out.println(
                maximumTime("??:?0")
        );
        System.out.println(
                maximumTime("??:??")
        );
        System.out.println(
                maximumTime("?4:03")
        );
        System.out.println(
                maximumTime("?2:?7")
        );
        System.out.println(
                maximumTime("2?:?0")
        );
        System.out.println(
                maximumTime("0?:3?")
        );
        System.out.println(
                maximumTime("1?:22")
        );
        System.out.println(
                maximumTime("2?:0?")
        );
        System.out.println(
                maximumTime("0?:3?")
        );
        System.out.println(
                maximumTime("1?:22")
        );
        System.out.println(
                maximumTime("1?:2?")
        );
        System.out.println(
                maximumTime("2?:3?")
        );
        System.out.println(
                maximumTime("2?:??")
        );
        System.out.println(
                maximumTime("??:5?")
        );
        System.out.println(
                maximumTime("??:?0")
        );
        System.out.println(
                maximumTime("??:??")
        );
    }


}
