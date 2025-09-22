import java.util.*;
import java.io.*;

class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        Map<Character, Integer> map = new HashMap<>();
        for ( String key : keymap ){
            for ( int i = 0 ; i < key.length() ; i++ ){
                if (!map.containsKey(key.charAt(i))){
                    map.put(key.charAt(i),i+1);
                } else {
                    map.replace(key.charAt(i),Math.min(map.get(key.charAt(i)), i + 1));
                }
            }
        }
        
        int[] answer = new int[targets.length];
        
        for (int t = 0 ; t < targets.length ; t++ ){
            int cnt = 0;
            for (int i = 0 ; i < targets[t].length() ; i++ ){
                if ( !map.containsKey(targets[t].charAt(i))){
                    answer[t] = -1;
                    break;
                }
                cnt += map.get(targets[t].charAt(i));
            }
            if (answer[t] != -1) answer[t] = cnt;
        }
        return answer;
    }
}
