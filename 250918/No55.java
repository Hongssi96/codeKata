class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        int idx1 = 0;
        int idx2 = 0;
        for ( int i = 0 ; i < goal.length ; i++ ){
            if (goal[i].equals(cards1[idx1])){
                if( idx1 <= cards1.length - 2){
                    idx1++;
                }
            } else if ( goal[i].equals(cards2[idx2])){
                if( idx2 <= cards2.length - 2){
                    idx2++;
                }
            } else {
                return "No";
            }
        }
        return "Yes";
    }
}
