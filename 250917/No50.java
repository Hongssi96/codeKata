import java.util.*;

class Solution {
    public int[] solution(String s) {
        HashMap<Character,int[]> map = new HashMap<>();
        int[] answer = new int[s.length()];

        for ( int i = 0 ; i < s.length() ; i++ ){
            char tmp = s.charAt(i);
            if (map.containsKey(tmp)){
                int[] now = map.get(tmp);
                map.replace(tmp,new int[]{i,i-now[0]});
                answer[i] = i-now[0];
            } else{
                map.put(tmp, new int[]{i,-1});
                answer[i] = -1;
            }
        }
        return answer;
    }
}
