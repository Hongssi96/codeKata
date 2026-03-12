import java.io.*;
import java.util.*;

public class Main {
    static int T, N, K;
    static int[] arr;
    static int[] sorted;
    static int[] tree;
    static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            arr = new int[N];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            // 1) 좌표압축용 정렬 배열
            sorted = arr.clone();
            Arrays.sort(sorted);

            // 중복 제거
            int m = 1;
            for (int i = 1; i < N; i++) {
                if (sorted[i] != sorted[i - 1]) {
                    sorted[m++] = sorted[i];
                }
            }

            // 2) 세그먼트 트리 초기화
            tree = new int[4 * m];
            Arrays.fill(tree, INF);

            long answer = 0;

            // 3) 앞에서부터 보면서 처리
            for (int i = 0; i < N; i++) {
                int leftValue = arr[i] - K;
                int rightValue = arr[i];

                // 값 범위 [arr[i]-K, arr[i]] 에 해당하는 압축 인덱스 구간 찾기
                int left = lowerBound(sorted, m, leftValue);
                int right = upperBound(sorted, m, rightValue) - 1;

                if (left <= right) {
                    int minIdx = query(1, 0, m - 1, left, right);
                    if (minIdx != INF) {
                        answer += (i - minIdx);
                    }
                }

                // 현재 값 arr[i]를 트리에 반영
                int pos = lowerBound(sorted, m, arr[i]);
                update(1, 0, m - 1, pos, i);
            }

            sb.append("Case #").append(t).append("\n");
            sb.append(answer).append("\n");
        }

        System.out.print(sb);
    }

    // 세그먼트 트리 update: 해당 값 위치에 최소 인덱스 저장
    static void update(int node, int start, int end, int idx, int value) {
        if (idx < start || idx > end) return;

        if (start == end) {
            tree[node] = Math.min(tree[node], value);
            return;
        }

        int mid = (start + end) / 2;
        update(node * 2, start, mid, idx, value);
        update(node * 2 + 1, mid + 1, end, idx, value);
        tree[node] = Math.min(tree[node * 2], tree[node * 2 + 1]);
    }

    // 세그먼트 트리 query: 구간 내 최소 인덱스 반환
    static int query(int node, int start, int end, int left, int right) {
        if (right < start || end < left) return INF;
        if (left <= start && end <= right) return tree[node];

        int mid = (start + end) / 2;
        return Math.min(
                query(node * 2, start, mid, left, right),
                query(node * 2 + 1, mid + 1, end, left, right)
        );
    }

    // lower_bound: target 이상이 처음 나오는 위치
    static int lowerBound(int[] arr, int size, int target) {
        int l = 0, r = size;
        while (l < r) {
            int mid = (l + r) >>> 1;
            if (arr[mid] >= target) r = mid;
            else l = mid + 1;
        }
        return l;
    }

    // upper_bound: target 초과가 처음 나오는 위치
    static int upperBound(int[] arr, int size, int target) {
        int l = 0, r = size;
        while (l < r) {
            int mid = (l + r) >>> 1;
            if (arr[mid] > target) r = mid;
            else l = mid + 1;
        }
        return l;
    }
}