class Solution {
    public int solution(int num) {
        if(num == 1) return 0;
        int answer = 0;
        long nowNum = num;
        while(true){
            if(answer >= 500) return -1;
            if(nowNum == 1) break;
            if(nowNum % 2 == 0){
                nowNum /= 2;
            } else {
                nowNum = nowNum * 3 + 1;
            }
            answer++;
        }
        return answer;
    }
}
