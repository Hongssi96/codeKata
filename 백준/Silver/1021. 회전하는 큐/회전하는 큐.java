import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] arr = new int[M];
        for (int i = 0; i < M; i++) {
            arr[i] = sc.nextInt();
        }

        Deque<Integer> q = new ArrayDeque<>();
        for (int i = 1; i <= N; i++) {
            q.offerLast(i);
        }

        int moves = 0;

        for (int target : arr) {
            if (q.peekFirst() != null && q.peekFirst() == target) {
                
                q.pollFirst();
                continue;
            }

            int idx = 0;
            for (int v : q) {
                if (v == target) break;
                idx++;
            }

            // 왼쪽으로 idx 번 돌릴지, 오른쪽으로 (size - idx) 번 돌릴지 선택
            int size = q.size();
            if (idx <= size / 2) {
                for (int i = 0; i < idx; i++) {
                    q.offerLast(q.pollFirst());
                    moves++;
                }
            } else {
                int r = size - idx;
                for (int i = 0; i < r; i++) {
                    q.offerFirst(q.pollLast());
                    moves++;
                }
            }

            q.pollFirst();
        }

        System.out.println(moves);
    }
}
