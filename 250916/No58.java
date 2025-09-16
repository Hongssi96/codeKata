import java.io.*;
import java.util.*;

class Solution {
    static boolean[] isPrime;
    
    public int solution(int[] nums) {
        Arrays.sort(nums);
        int maxSum = 0;
        for ( int i = 0 ; i < 3 ; i++ ){
            maxSum += nums[nums.length-1-i];
        }
        isPrime = new boolean[maxSum + 1];
        for(int i = 0; i < isPrime.length; i++){
            isPrime[i] = true;
        }
        isPrime[0] = isPrime[1] = false;
        int answer = 0;
        for ( int i = nums.length - 1 ; i >= 2 ; i-- ){
            for ( int j = i - 1 ; j >= 1 ; j-- ){
                for ( int k = j - 1 ; k >= 0 ; k-- ){
                    int tmp = nums[i] + nums[j] + nums[k];
                    if ( !isPrime[tmp] ){
                        continue;
                    } else {
                        che(tmp);
                        if ( isPrime[tmp] ){
                            answer++;
                        }
                    }
                }
            }
        }
        return answer;
    }
    static void che(int n){
        for(int i = 2; i <= Math.sqrt(n); i++){ 
            if(isPrime[i]){ 
                for(int j = i*i; j<= n; j += i){
                    isPrime[j] = false;
                }
            }
        }
    }
    
}
