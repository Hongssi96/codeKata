class Solution {
    static boolean[] isVisited;
    static int[][] schedule;
    static int answer;
    
    public int solution(int k, int[][] dungeons) {
        schedule = dungeons;
        answer = -1;
        for ( int i = 0 ; i < schedule.length ; i++ ){
            if ( k >= dungeons[i][0]){
                int cnt = 1;
                isVisited = new boolean[schedule.length];
                isVisited[i] = true;
                dfs ( cnt , k - dungeons[i][1] );
            }
        }
        return answer;
    }
    
    static void dfs ( int depth, int k ){
        answer = Math.max (depth, answer);
        for ( int i = 0 ; i < schedule.length ; i++ ){
            if ( !isVisited[i] && k >= schedule[i][0] ){
                isVisited[i] = true;
                dfs ( depth + 1, k - schedule[i][1] );
                isVisited[i] = false;
            }
        }
        
        return;
    }
}