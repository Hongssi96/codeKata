class Solution {
    public int solution(int n, int m, int[] section) {
        int answer = 0;
        int lastIdx = 0;
        for ( int i = 0 ; i < section.length ; i++ ){
            if ( section[i] <= lastIdx ) continue;
            int now = section[i];
            answer++;
            lastIdx = now + m - 1;
        }
        return answer;
    }
}
