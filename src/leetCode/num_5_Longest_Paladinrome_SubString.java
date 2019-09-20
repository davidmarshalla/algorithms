package leetCode;

public class num_5_Longest_Paladinrome_SubString {
    private static char[] manacherString(String s) {
        char[] res = new char[s.length() * 2 + 1];
        int index = 0;
        for (int i = 0; i < res.length; i++) {
            res[i] = i % 2 == 0 ? '#' : s.charAt(index++);
        }
        return res;
    }

    public static String longestPalindrome(String s) {
        if (s == null || s.length() < 1) {
            return null;
        }
        char[] charArr = manacherString(s);
        int[] pArr = new int[charArr.length];
        int index = -1;
        int pR = -1;
        int max = Integer.MIN_VALUE;
        int center = 0;


        for (int i = 0; i != charArr.length; i++) {
            pArr[i] = pR > i ? Math.min(pArr[2 * index - i], pR - i) : 1;
            while (i + pArr[i] < charArr.length && i - pArr[i] > -1) {
                if (charArr[i + pArr[i]] == charArr[i - pArr[i]]) {
                    pArr[i]++;
                } else {
                    break;
                }
            }
            if (i + pArr[i] > pR) {
                pR = i + pArr[i];
                index = i;
            }

            if (pArr[i] > pArr[center]) {
                center = i;
            }

            max = Math.max(max, pArr[i]);
        }

        StringBuilder sb = new StringBuilder();

        for (int i = center - pArr[center] + 1; i <= center + pArr[center] - 1; i++) {
            if (charArr[i] != '#') {
                sb.append(charArr[i]);
            }
        }
        return sb.toString();
    }


    public static void main(String[] args) {
        String s = "babad";
        String res = longestPalindrome(s);
        System.out.println(res);
    }
}
