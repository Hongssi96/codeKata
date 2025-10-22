import java.util.*;

class Solution {
    public int[] solution(int n, int m) {
        int[] answer = new int[2];
        int max = Math.max(n,m);
        int min = Math.min(n,m);
        int gbcVal = gbc(max, min);
        answer[0] = gbcVal;
        answer[1] = n * m / gbcVal;
        return answer;
    }
    
    static int gbc ( int max , int min ){
        if ( min == 0 ) return max;
        return gbc ( min , max % min);
    }
}
