import java.util.*;

class Solution {
    static int[] dr = {0, 1, 0, -1};
    static int[] dc = {1, 0, -1, 0};

    public int solution(String[] maps) {
        int R = maps.length, C = maps[0].length();
        int sr=0, sc=0, lr=0, lc=0, er=0, ec=0;

        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                char ch = maps[r].charAt(c);
                if (ch == 'S') { sr = r; sc = c; }
                else if (ch == 'L') { lr = r; lc = c; }
                else if (ch == 'E') { er = r; ec = c; }
            }
        }

        int d1 = bfs(maps, sr, sc, 'L');
        if (d1 == -1) return -1;

        int d2 = bfs(maps, lr, lc, 'E');
        if (d2 == -1) return -1;

        return d1 + d2;
    }

    private int bfs(String[] maps, int sr, int sc, char target) {
        int R = maps.length, C = maps[0].length();
        boolean[][] visited = new boolean[R][C];
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{sr, sc, 0});
        visited[sr][sc] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int r = cur[0], c = cur[1], d = cur[2];

            if (maps[r].charAt(c) == target) return d;

            for (int k = 0; k < 4; k++) {
                int nr = r + dr[k], nc = c + dc[k];
                if (0 <= nr && nr < R && 0 <= nc && nc < C
                        && !visited[nr][nc]
                        && maps[nr].charAt(nc) != 'X') {
                    visited[nr][nc] = true;
                    q.add(new int[]{nr, nc, d + 1});
                }
            }
        }
        return -1;
    }
}
