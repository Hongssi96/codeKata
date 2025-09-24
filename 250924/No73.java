import java.util.*;

class Solution {
    static int H, W;
    public int[] solution(String[] park, String[] routes) {
        Map<Character, int[]> order = new HashMap<>();
        order.put('N',new int[]{-1, 0});
        order.put('S',new int[]{1, 0});
        order.put('W',new int[]{0, -1});
        order.put('E',new int[]{0, 1});
        H = park.length;
        W = park[0].length();
        
        int sr = 0;
        int sc = 0;
        char[][] map = new char[H][W];
        for ( int r = 0 ; r < H ; r++ ){
            String tmp = park[r];
            for ( int c = 0 ; c < W ; c++ ){
                map[r][c] = tmp.charAt(c);
                if (map[r][c] == 'S'){
                    sr = r;
                    sc = c;
                }
            }
        }
        for ( String road : routes ){
            char a = road.charAt(0);
            int t = road.charAt(2) - '0';
            int[] tmp = order.get(a);
            if ( !range_check(sr + tmp[0] * t , sc + tmp[1] * t) )continue;
            boolean isOk = true;
            for (int i = 1; i <= t; i++) {
                if (map[sr + tmp[0] * i][sc + tmp[1] * i] == 'X') {
                    isOk = false;
                    break;
                }
            }
            if ( isOk ){
                sr = sr + tmp[0] * t;
                sc = sc + tmp[1] * t;
            }
        }
        int[] answer = {sr, sc};
        return answer;
    }
    static boolean range_check ( int r, int c ){
        return r >= 0 && c >= 0 && r < H && c < W;
    }
}
