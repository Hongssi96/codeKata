class Solution {
    public int[] solution(int brown, int yellow) {
		int bigCarpet = brown + yellow;
		int row = 0;
		int col = 0;
		for (int i = 3; i <= Math.sqrt(bigCarpet) ; i++) {
			int tmp = bigCarpet / i;
			if ( (tmp * i) == bigCarpet && (i-2) * (tmp - 2) == yellow) {
				row = i;
				col = tmp;
			}
		}
		int[] answer = new int[2];
		answer[0] = col;
		answer[1] = row;
		return answer;
	}
}
