import java.lang.*;
import java.util.*;

class Solution {
    
    // 각 트리의 대표를 임의로 선정
    public List<Integer>[] adj;
    
    public int[] solution(int[] nodes, int[][] edges) {
        int[] answer = {0,0};
        
        adj = new ArrayList[1_000_001];
        for(int i=0;i<=1_000_000;i++){
            adj[i] = new ArrayList<>();
        }
        
        for(int i=0;i<edges.length;i++){
            int a = edges[i][0];
            int b = edges[i][1];
            adj[a].add(b);
            adj[b].add(a);
        }
        
        
        int[] visited = new int[1_000_001];
        
        for(int i=0;i<nodes.length;i++){
            
            
            if(visited[nodes[i]] == 0){
                // 정 개수
                int right = 0;
                // 역 개수
                int reverse = 0;
                
                visited[nodes[i]] = 1;
                Queue<Integer> q = new ArrayDeque<>();
                q.add(nodes[i]);
                
                while(!q.isEmpty()){
                    int curr = q.poll();
                    
                    if(curr % 2 == adj[curr].size() % 2){
                        right++;
                    }
                    else{
                        reverse++;
                    }
                    
                    for(int next : adj[curr]){
                        if(visited[next] == 1){
                            continue;
                        }
                        visited[next] = 1;
                        q.add(next);
                    }
                }
                
                if(right == 1){
                    answer[0]++;
                }
                if(reverse == 1){
                    answer[1]++;
                }
            }
        }
        
        
        return answer;
    }
}