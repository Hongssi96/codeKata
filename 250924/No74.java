import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        Map<String, Integer> intId = new HashMap<>();
        for ( int i = 0 ; i < id_list.length ; i++ ){
            intId.put(id_list[i], i);
        }
        List<Integer>[] WhoReport = new ArrayList[id_list.length];
        for ( int i = 0 ; i < id_list.length ; i++ ){
            WhoReport[i] = new ArrayList<>();
        }
        
        Set<String> set = new HashSet<>(); // 중복 신고 확인용
        
        for (String caution : report){
            if(set.contains(caution)) continue;
            set.add(caution);
            StringTokenizer st = new StringTokenizer(caution);
            String from_id = st.nextToken();
            String to_id = st.nextToken();
            WhoReport[intId.get(to_id)].add(intId.get(from_id));
        }
        int[] answer = new int[id_list.length];
        for ( int i = 0 ; i < WhoReport.length ; i++ ){
            if( WhoReport[i].size() >= k ){
                for (int ids : WhoReport[i]){
                    answer[ids]++;
                }
            }
        }
        
        return answer;
    }
}
