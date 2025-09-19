class Solution {
    public int solution(String s) {
        int answer = 0;
        int X = 0;
        char x = '0';
        int NX = 0;
        for ( int i = 0 ; i < s.length() ; i++ ){
            if ( X == 0 ){
                X++;
                x = s.charAt(i);
            } else {
                if ( s.charAt(i) == x){
                    X++;
                } else {
                    NX++;
                }
            }
            if ( X == NX ){
                answer++;
                X = 0;
                NX = 0;
            }
        }
        if ( X != 0 ){
            answer++;
        }
        return answer;
    }
}
