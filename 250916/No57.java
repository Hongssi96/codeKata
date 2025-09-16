import java.util.*;
class Solution {
    public int[] solution(int[] answers) {
		int[] A = { 1, 2, 3, 4, 5 };
		int[] B = { 2, 1, 2, 3, 2, 4, 2, 5 };
		int[] C = { 3, 3, 1, 1, 2, 2, 4, 4, 5, 5 };
		int[] score = new int[3];
		for (int i = 0; i < answers.length; i++) {
			if (answers[i] == A[i % 5]) {
				score[0]++;
			}
			if (answers[i] == B[i % 8]) {
				score[1]++;
			}
			if (answers[i] == C[i % 10]) {
				score[2]++;
			}
		}
		int max = Math.max(score[0], Math.max(score[1], score[2]));

		List<Integer> tmp = new ArrayList<>();
		for (int i = 0; i < 3; i++) {
			if (max == score[i]) {
				tmp.add(i + 1);
			}
		}

		int[] answer = new int[tmp.size()];
		for (int i = 0; i < answer.length; i++) {
			answer[i] = tmp.get(i);
		}
		return answer;
	}
}
