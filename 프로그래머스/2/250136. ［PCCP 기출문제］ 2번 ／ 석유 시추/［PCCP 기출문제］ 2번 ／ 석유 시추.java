import java.lang.*;
import java.util.*;

class Solution {
    
    int visited[][];
    int oilSizeByNum[] = new int[250000];
    int N, M;
    
    public int solution(int[][] land) {
        N = land.length;
        M = land[0].length;
        visited = new int[N][M];
        
        // 석유마다 고유 번호를 단다
        
        int cnt = 1;
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(land[i][j] == 1 && visited[i][j] == 0){
                    
                    BFS(i,j,cnt++,land);
                   
                }
            }
        }
        
        
        int maxOil = 0;
        ///
       
        // 1. 생성은 한번 쓸 때 마다 초기화
        int alreadyMinning[] = new int[250000];
        
        for(int j=0;j<M;j++){
            
            int sum = 0;
            
            //1. 생성은 한번 쓸 때 마다 초기화
            //Arrays.fill(alreadyMinning,0);
            for(int k=0;k<250000;k++){
                alreadyMinning[k] =0 ;
            }
            
            //2. 쓸 때 마다 생성
            //int alreadyMinning[] = new int[250000];
            
            for(int i=0;i<N;i++){
                if(land[i][j] == 1){
                    int idx = visited[i][j];
                    if(alreadyMinning[idx] == 0 ){
                        alreadyMinning[idx] = 1;
                        sum += oilSizeByNum[idx];
                    }
                }
            }
            
            maxOil = Math.max(maxOil,sum);
            
        }
        
        

        int answer = maxOil;
        return answer;
    }
    
    //visited를 cnt로 표시하며 BFS를 돈다.
    public void BFS(int y,int x,int cnt, int land[][]){
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{y,x});
        visited[y][x] = cnt;
        oilSizeByNum[cnt]++;
        
        int[] dx = {0,0,1,-1};
        int[] dy = {1,-1,0,0};
        
        while(!q.isEmpty()){
            int[] cur = q.poll();
            
            for(int i=0;i<4;i++){
                int gox = cur[1] +dx[i];
                int goy = cur[0] +dy[i];
                
                if(canGo(goy,gox)){
                    if(visited[goy][gox] == 0 && land[goy][gox] == 1){
                        visited[goy][gox] = cnt;
                        q.add(new int[]{goy,gox});
                        oilSizeByNum[cnt]++;
                    }
                }
            }
        }
        
    }
    
    public boolean canGo(int y,int x){
        if(x < 0 || x >= M)return false;
        if(y < 0 || y >= N)return false;
        
        return true;
    }
}