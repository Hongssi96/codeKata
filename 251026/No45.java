class Solution {
    public String solution(String s, int n) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char now = s.charAt(i);

            if (now == ' ') {
                sb.append(' ');
                continue;
            }

            if (now >= 'a' && now <= 'z') {
                now = (char) ('a' + (now - 'a' + n) % 26);
            } else if (now >= 'A' && now <= 'Z') {
                now = (char) ('A' + (now - 'A' + n) % 26);
            }
            sb.append(now);
        }
        return sb.toString();
    }
}
