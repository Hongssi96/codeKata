import java.util.*;

class Solution {
    public long solution(long n) {
        long tmp = (long) Math.sqrt(n); 
        if (tmp * tmp == n) {
            return (long) Math.pow(tmp + 1, 2);
        } else {
            return -1;
        }
    }
}
