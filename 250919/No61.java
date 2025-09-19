import java.util.*;

class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        int zero_num = 0;
        int match_num = 0;
        for ( int i = 0 ; i < 6 ; i++ ){
            if ( lottos[i] == 0 ){
                zero_num++;
                continue;
            }
            for ( int j = 0 ; j < 6 ; j++){
                if ( lottos[i] == win_nums[j] ){
                    match_num++;
                    break;
                }
            }
        }
        answer[0] = 7 - (zero_num + match_num);
        answer[1] = 7 - (match_num);
        if ( zero_num + match_num == 0 ){
            answer[0] = 6;
        }
        if ( match_num == 0 ){
            answer[1] = 6;
        }
        return answer;
    }
}
