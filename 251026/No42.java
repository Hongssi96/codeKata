import java.util.*;

class Solution {
    static int[] student;
    static int answer;
    public int solution(int[] number) {
        student = number;
        answer = 0;
        for ( int i = 0 ; i < number.length - 2 ; i++ ){
            dfs(i,student[i],1);
        }
        return answer;
    }
    static void dfs (int lastidx, int sum, int depth){
        if (depth == 3){
            if (sum == 0) answer++;
            return;
        }
        if (lastidx + 1 < student.length){
            for ( int i = lastidx + 1 ; i < student.length ; i++ ){
                dfs(i, sum + student[i], depth+1);
            }
        }
    }
}
