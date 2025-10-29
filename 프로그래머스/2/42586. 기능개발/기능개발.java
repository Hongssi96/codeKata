import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> q = new LinkedList<>();
        Queue<Integer> s = new LinkedList<>();
        int cnt = 0;
        
        for (int i = 0; i < progresses.length; i++) {
            int days = (int) Math.ceil((100.0 - progresses[i]) / speeds[i]);
            if (q.isEmpty() || q.peek() >= days) {
                q.add(days);
                cnt++;
            } else {
                s.add(cnt);
                cnt = 1;
                q.clear();
                q.add(days);
            }
        }
        s.add(cnt);
        
        int[] answer = new int[s.size()];
        for (int i = 0 ; i < answer.length; i++) {
            answer[i] = s.poll();
        }
        
        return answer;
    }
}
