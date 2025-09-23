import java.util.*;

class Solution {
    public String solution(String[] survey, int[] choices) {
        StringBuilder answer = new StringBuilder();

        int[] score = new int[9];

        Map<Character, Integer> idx = Map.of(
            'R', 1, 'T', 2,
            'C', 3, 'F', 4,
            'J', 5, 'M', 6,
            'A', 7, 'N', 8
        );
        Map<Integer, Character> rev = Map.of(
            1, 'R', 2, 'T',
            3, 'C', 4, 'F',
            5, 'J', 6, 'M',
            7, 'A', 8, 'N'
        );

        for (int i = 0; i < survey.length; i++) {
            char left = survey[i].charAt(0);  
            char right = survey[i].charAt(1);  
            int nScore = choices[i] - 4;    

            if (nScore > 0) {
                score[idx.get(right)] += nScore;
            } else if (nScore < 0) {              
                score[idx.get(left)] += -nScore;
            }         
        }

        for (int i = 0; i < 4; i++) {
            int first = 2 * i + 1;
            int second = first + 1;
            if (score[first] >= score[second]) {
                answer.append(rev.get(first));
            } else {
                answer.append(rev.get(second));
            }
        }

        return answer.toString();
    }
}
