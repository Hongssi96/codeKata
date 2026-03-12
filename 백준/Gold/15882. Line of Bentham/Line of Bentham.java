import java.io.BufferedInputStream;
import java.io.IOException;
import java.util.Arrays;

public class Main {

    static class FastScanner {
        private final BufferedInputStream in = new BufferedInputStream(System.in);
        private final byte[] buffer = new byte[1 << 16];
        private int ptr = 0, len = 0;

        private int read() throws IOException {
            if (ptr >= len) {
                len = in.read(buffer);
                ptr = 0;
                if (len <= 0) return -1;
            }
            return buffer[ptr++];
        }

        int nextInt() throws IOException {
            int c;
            do {
                c = read();
            } while (c <= ' ');

            int sign = 1;
            if (c == '-') {
                sign = -1;
                c = read();
            }

            int val = 0;
            while (c > ' ') {
                val = val * 10 + (c - '0');
                c = read();
            }
            return val * sign;
        }
    }

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner();

        int N = fs.nextInt();

        long NEG = Long.MIN_VALUE / 4;
        long[] dp = new long[8];
        long[] next = new long[8];
        Arrays.fill(dp, NEG);

        // 시작 전에는 x[-2], x[-1], x[0] = 0 이라고 보면 됨
        dp[0] = 0;

        for (int i = 1; i <= N; i++) {
            int a = fs.nextInt(); // p[i][i-3]
            int b = fs.nextInt(); // p[i][i-2]
            int c = fs.nextInt(); // p[i][i-1]

            Arrays.fill(next, NEG);

            for (int mask = 0; mask < 8; mask++) {
                if (dp[mask] == NEG) continue;

                int x_im3 = (mask >> 2) & 1;
                int x_im2 = (mask >> 1) & 1;
                int x_im1 = mask & 1;

                // 1) i번 사람을 요원으로 교체 (x_i = 0)
                int nextMask0 = ((mask << 1) & 7);
                next[nextMask0] = Math.max(next[nextMask0], dp[mask]);

                // 2) i번 사람을 유지 (x_i = 1)
                long gain = (long) a * x_im3 + (long) b * x_im2 + (long) c * x_im1;
                int nextMask1 = ((mask << 1) & 7) | 1;
                next[nextMask1] = Math.max(next[nextMask1], dp[mask] + gain);
            }

            long[] temp = dp;
            dp = next;
            next = temp;
        }

        long answer = 0;
        for (int mask = 0; mask < 8; mask++) {
            answer = Math.max(answer, dp[mask]);
        }

        System.out.println(answer);
    }
}