
class Solution {
    public int solution(int[][] sizes) {
		int min = 0;
		int max = 0;
		for (int r = 0; r < sizes.length; r++) {
			min = Math.max(min, Math.min(sizes[r][0], sizes[r][1]));
			max = Math.max(max, Math.max(sizes[r][0], sizes[r][1]));
		}
		int answer = max * min;
		return answer;
	}
}
