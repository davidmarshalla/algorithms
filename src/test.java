import java.util.*;

public class test {
    public static int myAtoi(String str) {
        if(str.length() < 1){
            return 0;
        }
        int index = 0;
        int res = 0;
        long tmp = 0;
        while (index < str.length()) {
            while (index != str.length() && str.charAt(index) == ' ') {
                index++;
            }
            if(index == str.length()){
                return 0;
            }
            if (str.charAt(index) == '0') {
                return res;
            } else if (str.charAt(index) == '-') {
                index++;
                while (index < str.length()) {
                    tmp = tmp * 10 + (str.charAt(index++) - '0');
                }
                res = -tmp > Integer.MIN_VALUE ? (int) -tmp : Integer.MIN_VALUE;
            } else if (str.charAt(index) < '0' || str.charAt(index) > '9') {
                return res;
            } else {
                while (index < str.length() && str.charAt(index) != ' ' && str.charAt(index) >= '0' && str.charAt(index) <= 9) {
                    int num = str.charAt(index++) - '0';
                    tmp = tmp * 10 + num;
                }
                res = tmp < Integer.MAX_VALUE ? (int) tmp : Integer.MAX_VALUE;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String str = "    0000000000000   ";
        int res = myAtoi(str);
        System.out.println(res);
    }
}
