import java.util.*;

class Solution {
    public String solution(String X, String Y) {
        int[] XNum = new int[10];
        int[] YNum = new int[10];
        for ( int i = 0 ; i < X.length() ; i++ ){
            XNum[X.charAt(i) - '0']++;
        }
        for ( int i = 0 ; i < Y.length() ; i++ ){
            YNum[Y.charAt(i) - '0']++;
        }
        StringBuilder sb = new StringBuilder();
        for (int d = 9; d >= 0; d--) {
            int common = Math.min(XNum[d], YNum[d]);
            while (common-- > 0) sb.append(d);
        }

        if (sb.length() == 0) return "-1";
        if (sb.charAt(0) == '0') return "0";
        return sb.toString();
    }
}
