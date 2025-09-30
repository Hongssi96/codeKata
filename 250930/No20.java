import java.util.*;
import java.io.*;

class Solution {
    public long solution(long n) {
        PriorityQueue<Long> pq = new PriorityQueue<>(Collections.reverseOrder());
        while ( n > 9 ){
            pq.add(n % 10);
            n /= 10;
        }
        pq.add(n);
        StringBuilder sb = new StringBuilder();
        while( !pq.isEmpty()){
            sb.append(pq.poll());
        }
        
        long answer = Long.parseLong(sb.toString());
        return answer;
    }
}
