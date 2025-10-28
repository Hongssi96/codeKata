class Solution {
    public int[] solution(int n, long left, long right) {
        int len = (int) (right - left + 1);
        int[] answer = new int[len];

        for (int i = 0; i < len; i++) {
            long k = left + i;
            long r = k / n;
            long c = k % n;
            answer[i] = (int) (Math.max(r, c) + 1);
        }
        return answer;
    }
}
