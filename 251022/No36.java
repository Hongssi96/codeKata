class Solution {
    public boolean solution(String s) {
        if (( s.length() == 4 || s.length() == 6) && isNum(s) ){
            return true;
        }
        return false;
    }
    static boolean isNum ( String s ){
        for ( int i = 0 ; i < s.length() ; i++ ){
            if ( s.charAt(i) - '0' < 0 || s.charAt(i) - '0' > 9){
                return false;
            }
        }
        return true;
    }
}
