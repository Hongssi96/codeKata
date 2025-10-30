import java.util.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        PriorityQueue<String> pq = new PriorityQueue<>(); // 이름 정렬용
        Map<String, int[]> inMap = new HashMap<>();
        Map<String, Integer> totalMin = new HashMap<>();

        int baseTime = fees[0];
        int baseFee = fees[1];
        int unitTime = fees[2];
        int unitFee = fees[3];

        for (String record : records) {
            StringTokenizer st = new StringTokenizer(record);
            String time = st.nextToken();
            String carnum = st.nextToken();
            String inAndOut = st.nextToken();

            int hour = Integer.parseInt(time.substring(0, 2));
            int minute = Integer.parseInt(time.substring(3, 5));

            if (inAndOut.equals("IN")) {
                inMap.put(carnum, new int[]{hour, minute});
                pq.add(carnum);
            } else {
                int[] inTime = inMap.get(carnum);
                inMap.remove(carnum);
                int diff = findMin(inTime, new int[]{hour, minute});
                totalMin.put(carnum, totalMin.getOrDefault(carnum, 0) + diff);
            }
        }
        
        // 안뺀 차들 다 넣어주기
        for (Map.Entry<String, int[]> e : inMap.entrySet()) {
            String carnum = e.getKey();
            int[] inTime = e.getValue();
            int diff = findMin(inTime, new int[]{23, 59});
            totalMin.put(carnum, totalMin.getOrDefault(carnum, 0) + diff);
        }

        PriorityQueue<String> outPQ = new PriorityQueue<>(totalMin.keySet());

        int[] answer = new int[outPQ.size()];
        int idx = 0;
        while (!outPQ.isEmpty()) {
            String car = outPQ.poll();
            int t = totalMin.get(car);

            int fee = baseFee;
            if (t > baseTime) {
                int extra = t - baseTime;
                int units = (extra + unitTime - 1) / unitTime;
                fee += units * unitFee;
            }
            answer[idx++] = fee;
        }
        return answer;
    }

    static int findMin(int[] inTime, int[] outTime) {
        int inMin = inTime[0] * 60 + inTime[1];
        int outMin = outTime[0] * 60 + outTime[1];
        return outMin - inMin;
    }
}
