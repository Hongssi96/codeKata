import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        for ( int r = 0 ; r < commands.length ; r++){
            int i = commands[r][0];
            int j = commands[r][1];
            int k = commands[r][2];
            int[] tmp = new int[j - i + 1];
            int cnt = 0;
            for ( int c = i-1 ; c < j ; c++){
                tmp[cnt] = array[c];
                cnt++;
            }
            Arrays.sort(tmp);
            answer[r] = tmp[k-1];
        }
        
        return answer;
    }
}
