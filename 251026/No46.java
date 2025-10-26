import java.util.*;

class Solution {
    public int solution(String s) {
        Map<String, Integer> map = new HashMap<>();
        map.put("zero", 0);
        map.put("one", 1);
        map.put("two", 2);
        map.put("three", 3);
        map.put("four", 4);
        map.put("five", 5);
        map.put("six", 6);
        map.put("seven", 7);
        map.put("eight", 8);
        map.put("nine", 9);
        String number = "";
        StringBuilder sb = new StringBuilder();
        for ( int i = 0 ; i < s.length() ; i++ ){
            char tmp = s.charAt(i);
            if ( tmp >= '0' && tmp <= '9' ){
                if (!number.equals("")){
                    sb.append(map.get(number));
                    number = "";
                }
                sb.append(tmp);
            } else {
                if (map.containsKey(number)){{
                    sb.append(map.get(number));
                    number = "";
                }}
                number += tmp;
            }
        }
        if(!number.equals("")){
            sb.append(map.get(number));
        }
        int answer = Integer.parseInt(sb.toString());
        return answer;
    }
}
