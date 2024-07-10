import java.util.*;
import java.lang.*
;
/*
1. 현재 상태에서 방문할 수 있는 모든 양을 방문한다. (최대 양 기록)
2. 방문하지 않은 늑대 중 하나를 방문한다.
3. 갈 수 있는 곳이 없다면 돌아간다.
*/

class Solution {

    List<Integer>[] adj;
    int infoSize;
    
    int maxSheep = -1;
    
    int[] visited = new int[17];
    int[] candidate = new int[17];
    

    public int solution(int[] info, int[][] edges) {
        infoSize = info.length;
        adj = new ArrayList[infoSize];
        for(int i=0;i<infoSize;i++)adj[i] = new ArrayList<>();
        for(int i=0;i<edges.length;i++){
            int[] e = edges[i];
            adj[e[0]].add(e[1]);
        }
        
        
        visited[0] = 1;
        searchSheep(1,0,0,info);
        
        return maxSheep;
    }
    
    public void searchSheep(int sheepCnt, int wolfCnt, int curr, int[] info){
        
        if(sheepCnt <= wolfCnt) return;
        
        maxSheep = Math.max(maxSheep, sheepCnt);
        
        // 갈 수 있는 후보 추가
        for(int next : adj[curr]){
            candidate[next] = 1;
        }
        
        for(int i=0;i<infoSize;i++){
            if(candidate[i] == 1 && visited[i] == 0){
                visited[i] = 1;
                
                if(info[i] == 0){
                    searchSheep(sheepCnt+1,wolfCnt, i,info);
                }
                else{
                    searchSheep(sheepCnt,wolfCnt+1, i,info);
                }
                
                visited[i] = 0;
                
            }
        }
        
        // 갈 수 있는 후보 제거
        for(int next : adj[curr]){
            candidate[next] = 0;
        }
        
        
    }
    
}


/*
늑대가 있더라도 그 다음 노드에 뭐가 있는 지 알아야 한다.
일단 양이 있으면 방문?
백트래킹? 
총 노드의 수 17
시간 충분할 듯
*/