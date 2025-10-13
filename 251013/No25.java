import java.util.*;
import java.io.*;

class Solution {
    public int[] solution(int[] arr, int divisor) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for ( int num : arr ){
            if (num % divisor == 0){
                pq.add(num);
                System.out.println(num);
            }
        }
        int[] answer = new int[pq.size()];
        if( pq.size() == 0 ){
            return new int[]{-1};
        }
        for ( int i = 0 ; i < pq.size() ; i++ ){
            answer[i] = pq.poll();
        }
        return answer;
    }
}
