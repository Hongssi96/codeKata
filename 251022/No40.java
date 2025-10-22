import java.util.*;

class Solution {
    public int solution(int n) {
        Stack<Integer> q = new Stack<>();
        int tmp = n;
        while ( true ){
            if ( tmp < 3 ){
                q.push(tmp);
                break;
            }
            q.push(tmp % 3);
            tmp = tmp / 3;
        }
        int now = 1;
        int answer = 0;
        while ( !q.isEmpty()){
            int tmp1 = now * q.pop();
            answer += tmp1;
            now = now * 3;
        }
        return answer;
    }
}
