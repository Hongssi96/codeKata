class Solution {
    public int solution(int a, int b, int n) {
        int answer = 0;
        while (n >= a) {
            int plusCoke = (n / a) * b;
            answer += plusCoke;
            n = (n % a) + plusCoke;
        }
        return answer;
    }
}
