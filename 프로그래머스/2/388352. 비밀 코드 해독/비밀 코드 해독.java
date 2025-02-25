class Solution {
    
    public int[] visited;
    public int cpN, m, result;
    public int[][] cpQ;
    public int[] cpAns;
    
    public int solution(int n, int[][] q, int[] ans) {
        cpN = n;
        cpQ = q;
        cpAns = ans;
        m = q.length;
        
        visited = new int[n+1];
        
        // 가능한 모든 조합을 만든다.
        makeC(1,0);
        
        return result;
    }
    
    // 만들어진 수들로 정답과 똑같은지 체크
    public boolean test(){
        
        // 모든 시도에 대해 통과하는지
        for(int i=0;i<m;i++){
            
            // 각 시험에 대해 포함되는 수와 일치하는 지
            int cnt = 0;
            
            for(int j=0;j<5;j++){
                // 질문에 나왔던 숫자가, visited == 1이면 카운트
                if(visited[cpQ[i][j]] == 1){
                    cnt++;
                }
            }
            
            if(cnt != cpAns[i]){
                return false;
            }
        }
        
        return true;
    }
    
    public void makeC(int idx, int cnt){
        
        
        if(cnt == 5){
            
            if(test()){
                result++;
            }
           
            return;
        }
        
        for(int i=idx;i<=cpN;i++){
            if(visited[i] == 1){
                continue;
            }
            visited[i] = 1;
            makeC(i, cnt+1);
            visited[i] = 0;
        }
    }
}