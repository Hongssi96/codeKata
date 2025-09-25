class Solution {
    public int[] solution(String s) {
        int num = 0;
        int numOfChange = 0;
        String tmp = s;
        while(true){
            if( tmp.equals("1")) break;
            int cnt = 0;
            numOfChange++;
            for ( int i = 0 ; i < tmp.length() ; i++){
                if (tmp.charAt(i) - '1' == 0){
                    cnt++;
                } else {
                    num++;
                }
            }
            tmp = Integer.toBinaryString(cnt);
        }
        int[] answer = {numOfChange, num};
        return answer;
    }
}
