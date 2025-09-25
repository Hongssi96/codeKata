import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        for ( int i = 0 ; i < s.length() ; i++ ){
           if (isValid(s)){
               answer ++;
           }
            s = s.substring(1) + s.charAt(0);
        }
        return answer;
    }
    
    static boolean isValid(String str){
        Stack<Character> stack = new Stack<>();
        for ( char c : str.toCharArray() ){
            if ( c == '(' || c == '{' || c == '[') stack.push(c);
            else {
                if (stack.isEmpty()) return false;
                char top = stack.pop();
                if ((c == ')' && top != '(') ||
                (c == '}' && top != '{') ||
                (c == ']' && top != '[')) return false;
            }
        }
        return stack.isEmpty();
    }
}
