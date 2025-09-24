import java.util.*;

class Solution {
    public String solution(String s) {
        StringTokenizer st = new StringTokenizer(s);
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        while(st.hasMoreTokens()){
            int tmp = Integer.parseInt(st.nextToken());
            min = Math.min ( min , tmp);
            max = Math.max ( max , tmp);
        }
        String answer = "";
        answer += min + " " + max;
        return answer;
    }
}
