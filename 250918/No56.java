import java.util.*;

class Solution {
    public int solution(int k, int m, int[] score) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for ( int i = 0 ; i < score.length ; i++ ){
            pq.add(score[i]);
        }
        while ( !pq.isEmpty() ){
            for ( int i = 0 ; i < m ; i++ ){
                if (pq.isEmpty()) break;
                int tmp = pq.poll();
                if ( i == m - 1 ){
                    answer += tmp * m;
                }
            }
        }
        return answer;
    }
}
