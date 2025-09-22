import java.util.*;

class Solution {
    public int solution(int[] ingredient) {
        int answer = 0;
        int n = ingredient.length;
        int[] st = new int[n];
        int top = 0;
        for ( int x : ingredient) {
            st[top++] = x;
            
            if ( top >= 4 && st[top-4] == 1 && st[top-3] == 2 && st[top-2] == 3 && st[top-1] == 1){
                top -= 4;
                answer++;
            }
        }
        return answer;
    }
}
