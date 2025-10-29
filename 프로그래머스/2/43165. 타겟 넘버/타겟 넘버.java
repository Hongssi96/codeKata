class Solution {
    static int[] numbers;
	static int target, cnt;
	public int solution(int[] numbers, int target) {
        this.numbers = numbers;
        this.target = target;
        cnt = 0;
        powerset(0,0);
		int answer = cnt;
        return answer;
    }
	static void powerset ( int idx, int sum) {
		if (idx == numbers.length) {
			if ( sum == target) {
				cnt++;
			}
			return;
		}
		powerset(idx + 1, sum + numbers[idx]);
		powerset(idx + 1, sum - numbers[idx]);
	}
}