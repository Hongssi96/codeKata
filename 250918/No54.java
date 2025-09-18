import java.util.*;

class Solution {
    public String solution(int a, int b) {
        String[] months = {"SUN","MON","TUE","WED","THU","FRI","SAT"};
        int[] days = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int daySum = 0;
        // 월 더하기
        for ( int i = 0 ; i < a - 1 ; i++ ){
            daySum += days[i];
        }
        // 일 더하기
        daySum += b - 1;
        int find = (daySum + 5) % 7;
        String answer = months[find];
        return answer;
    }
}
