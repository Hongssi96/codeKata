class Solution {
    public int solution(int n) {
        int[] pibo = new int[n+1];
        pibo[1] = 1;
        for ( int i = 2 ; i < n+1 ; i++ ){
            pibo[i] = (pibo[i - 1] + pibo[i - 2]) % 1234567;
        }
        int answer = pibo[n] % 1234567;
        return answer;
    }
}
