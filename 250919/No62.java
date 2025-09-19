class Solution {
    static final String[] W = { "aya", "ye", "woo", "ma" };

    public int solution(String[] babbling) {
        int answer = 0;
        for (String s : babbling) {
            if (wordCheck(s)) answer++;
        }
        return answer;
    }

    static boolean wordCheck(String word) {
        int i = 0;
        String prev = "";
        while (i < word.length()) {
            boolean matched = false;
            for (String w : W) {
                if (!w.equals(prev) && word.startsWith(w, i)) {
                    i += w.length();
                    prev = w;
                    matched = true;
                    break;
                }
            }
            if (!matched) return false;
        }
        return true;
    }
}

