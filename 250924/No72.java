import java.util.*;

class Solution {
		public String[] solution(String[] players, String[] callings) {
			HashMap<String, Integer> runner = new HashMap<>();
			for (int i = 0; i < players.length; i++) {
				runner.put(players[i], i);
			}
			for (int i = 0; i < callings.length; i++) {
				int idx = runner.get(callings[i]);
				String tmp = players[idx - 1];
				players[idx - 1] = callings[i];
				players[idx] = tmp;
				runner.replace(callings[i], idx - 1);
				runner.replace(tmp, idx);
			}
			String[] answer = players;
			return answer;
		}
	}
