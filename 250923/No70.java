import java.util.*;

class Solution {
    public int[] solution(String[] wallpaper) {
        int sr = 0;
        int sc = 0;
        int er = 0;
        int ec = 0;
        char blanc = '.';
        char have = '#';
        boolean isStart = false;
        for (int r = 0 ; r < wallpaper.length ; r++ ){
            String tmp = wallpaper[r];
            for ( int c = 0 ; c < tmp.length() ; c++ ){
                if(tmp.charAt(c) == '#'){
                    if(!isStart){
                        sr = r;
                        er = r;
                        sc = c;
                        ec = Math.max(ec, c);
                        isStart = true;
                    } else {
                        er = r;
                        sc = Math.min(sc, c);
                        ec = Math.max(ec, c);
                    }
                }
            }
        }
        int[] answer = {sr,sc,er+1,ec+1};
        return answer;
    }
}
