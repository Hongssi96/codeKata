import java.util.HashMap;

class Solution {
    public int solution(String[][] clothes) {
        HashMap<String, Integer> map = new HashMap<>();
        
        // 의상 종류별로 개수 세기
        for (String[] cloth : clothes) {
            String type = cloth[1]; // 의상의 종류
            map.put(type, map.getOrDefault(type, 0) + 1);
        }
        
        int answer = 1;
        
        // 각 종류별로 (해당 종류를 입지 않는 경우 포함) 곱하기
        for (int count : map.values()) {
            answer *= (count + 1);
        }
        
        // 아무것도 입지 않는 경우 제외
        return answer - 1;
    }
}
