class Solution {
    public int solution(String t, String p) {
        int tSize = t.length();
        int pSize = p.length();
        int answer = 0;
        long base = Long.parseLong(p);
        for( int start = 0 ; start < tSize - pSize + 1 ; start++ ){
            long tmp = Long.parseLong(t.substring(start, start + pSize));
            if (tmp <= base) answer++;
        }
        return answer;
    }
}
