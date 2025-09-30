class Solution {
    public boolean solution(int x) {
        int nx = x;
        int sum = 0;
        while (nx > 9){
            sum += nx % 10;
            nx /= 10;
        }
        sum += nx;
        
        boolean answer = ( x % sum == 0 ) ? true : false;
        return answer;
    }
}
