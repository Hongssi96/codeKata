class Solution {
    public String solution(String s) {
        String answer = "";
        if (s.length() % 2 == 1){
            return answer += s.charAt(s.length()/2);
        } else {
            return answer += s.charAt(s.length()/2 - 1) + "" + s.charAt(s.length()/2);
        }
        
    }
}
