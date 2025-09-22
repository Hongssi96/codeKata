class Solution {
    public String solution(String s, String skip, int index) {
        boolean[] blocked = new boolean[26];
        for (int i = 0; i < skip.length(); i++) {
            blocked[skip.charAt(i) - 'a'] = true;
        }

        StringBuilder ans = new StringBuilder(s.length());
        for (int i = 0; i < s.length(); i++) {
            int idx = s.charAt(i) - 'a';
            int moved = 0;
            while (moved < index) {
                idx = (idx + 1) % 26;        
                if (!blocked[idx]) moved++;
            }
            ans.append((char) ('a' + idx));
        }
        return ans.toString();
    }
}
