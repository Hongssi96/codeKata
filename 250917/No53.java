import java.util.*;

class Solution {
    public int[] solution(int k, int[] score) {
        int[] answer = new int[score.length];
        PriorityQueue<Integer> q = new PriorityQueue<>();
        for ( int i = 0 ; i < score.length ; i++ ){
            if ( i < k ){
                q.offer(score[i]);
                int tmp = q.poll();
                answer[i] = tmp;
                q.offer(tmp);
            } else {
                q.offer(score[i]);
                q.poll();
                int tmp = q.poll();
                answer[i] = tmp;
                q.offer(tmp);
            }
        }
        return answer;
    }
}
