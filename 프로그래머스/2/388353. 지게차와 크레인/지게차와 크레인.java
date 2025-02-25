import java.lang.*;
import java.util.*;

class Solution {
    
    public int total, N,M, cmdCnt;
    public char[][] arr;
    public int[] dx = {0,0,1,-1};
    public int[] dy = {1,-1,0,0};
    
    public int solution(String[] storage, String[] requests) {
        // init
        N = storage.length;
        M = storage[0].length();
        arr = new char[N+2][M+2];
        cmdCnt = requests.length;
        total = N*M;
        
        for(int i=0;i<N+2;i++){
            for(int j=0;j<M+2;j++){
                arr[i][j] = '.';
            }
        }
        
        for(int i=1;i<=N;i++){
            for(int j=1;j<=M;j++){
                arr[i][j] = storage[i-1].charAt(j-1);
            }
        }
        
        // requests 처리
        for(int i=0;i<cmdCnt;i++){
            String cmd = requests[i];
            
            // 전부 꺼내기
            if(cmd.length() == 2){
                all(cmd.charAt(0));
            }
            // 가능 한 것만 꺼내기
            else {
                BFS(cmd.charAt(0));
            }
            
        }
        
        return total;
    }
    
    
    // 외부에서 BFS 실행 func
    public void BFS(char c){
        
        int[][] visited = new int[N+2][M+2];
        
        
        Queue<int[]> q = new ArrayDeque<>();
        // 테두리에서 시작
        q.add(new int[]{0,0});
        visited[0][0] = 1;
        
        while(!q.isEmpty()){
            int[] curr = q.poll();
             
            for(int i=0;i<4;i++){
                int gox = curr[1] + dx[i];
                int goy = curr[0] + dy[i];
                if(gox < 0 || gox >= M+2 || goy < 0 || goy >= N+2 || visited[goy][gox] == 1){
                    continue;
                }
                
                visited[goy][gox] = 1;
                // 빈공간이면 더 나아가본다.
                if(arr[goy][gox] =='.'){
                    q.add(new int[]{goy,gox});
                }
                // 블럭을 만난 경우
                else{
                    // 내가 찾던게 아니면 스킵
                    if(arr[goy][gox] != c){
                        continue;
                    }
                    
                    //찾던 경우
                    arr[goy][gox] = '.';
                    total--;
                    
                }
            }
        }
        
    }
    
    // 전부 찾아내기 func
    public void all(char c){
        
        for(int i=1;i<=N;i++){
            for(int j=1;j<=M;j++){
                if(arr[i][j] == c){
                    arr[i][j] = '.';
                    total--;
                }
            }
        }
    }
    
}