import java.util.*;

class Solution {
    static int[] cnt;
    static int[] list;
    static int answer;
    public int solution(String[] want, int[] number, String[] discount) {
        Map<String, Integer> map = new HashMap<>();
        int idx = 0;
        for ( String stuff : want ){
            map.put(stuff, idx++);
        }
        list = number;
        cnt = new int[want.length];
        for ( int i = 0 ; i < 10 ; i++ ){
            if (map.containsKey(discount[i])){
                cnt[map.get(discount[i])]++;
            }
        }
        answer = 0;
        isOk();
        for ( int i = 10 ; i < discount.length ; i++ ){
            if (map.containsKey(discount[i-10])){
                cnt[map.get(discount[i-10])]--;
            }
            if (map.containsKey(discount[i])){
                cnt[map.get(discount[i])]++;
            }
            isOk();
        }
        return answer;
    }
    
    static boolean isOk (){
        for ( int i = 0 ; i < cnt.length ; i++ ){
            if ( cnt[i] < list[i] ){
                return false;
            }
        }
        answer++;
        return true;
    }
}