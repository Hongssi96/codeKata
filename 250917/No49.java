import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        Set<Integer> sums = new HashSet<>();
        for( int i = 0 ; i < numbers.length - 1 ; i++ ){
            for ( int j = i + 1 ; j < numbers.length ; j++ ){
                sums.add(numbers[i] + numbers[j]);
            }
        }
        
        int[] answer = new int[sums.size()];
        int idx = 0;
        for ( int sum : sums){
            answer[idx] = sum;
            idx++;
        }
        Arrays.sort(answer);
        return answer;
    }
}
