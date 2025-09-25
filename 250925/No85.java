import java.util.*;

class Solution {
    public int solution(int[] elements) {
        int n = elements.length;
        TreeSet<Integer> set = new TreeSet<>();
        int[][] dp = new int[n][n];
        for ( int i = 0 ; i < n ; i++ ){
            dp[0][i] = elements[i];
        }
        for ( int r = 1 ; r < n ; r++ ){
            for ( int c = 0 ; c < n ; c++ ){
                dp[r][c] = dp[r-1][c] + dp[0][(c+r) % n];
                set.add(dp[r][c]);
            }
        }
        int answer = set.size();;
        return answer;
    }
}
