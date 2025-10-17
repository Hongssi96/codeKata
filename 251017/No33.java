import java.util.*;

class Solution {
    public int solution(int left, int right) {
        int[] cnt = new int[right+1];
        
        for ( int i = 1 ; i <= right ; i++ ){
            for ( int j = i ; j <= right ; j += i) {
                cnt[j]++;
            }
        }
        int answer = 0;
        
        for ( int x = left ; x <= right ; x++ ){
            answer += (cnt[x] % 2 == 0 ) ? x : -x;
        }
        return answer;
    }
}
