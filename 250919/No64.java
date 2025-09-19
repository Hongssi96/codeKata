import java.util.Arrays;

public class Solution {
	public int solution(int n, int[] lost, int[] reserve) {
		int[] student = new int[n + 1];
		Arrays.fill(student, 1);
        student[0] = 0;
		for (int i = 0; i < lost.length; i++) {
			student[lost[i]]--;
		}
		for (int i = 0; i < reserve.length; i++) {
			student[reserve[i]]++;
		}
		int answer = 0;
		for (int i = 1; i < student.length; i++) {
			if (student[i] >= 1) {
				answer++;
				continue;
			}
			if (student[i] == 0) {
				if (student[i - 1] > 1) {
					answer++;
				} else if (i != student.length - 1 && student[i + 1] > 1) {
					student[i + 1]--;
					answer++;
				}
			}
		}
		return answer;
	}
}
