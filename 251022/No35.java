class Solution {
    public long solution(int price, int money, int count) {
        long need = 0;
        for ( int i = 1 ; i <= count ; i++ ){
            need += i * price;
        }
        long answer = need - money;
        if ( answer <= 0 ) return 0;
        else return answer;
    }
}
