import java.util.*;
import java.lang.*;

class Solution {
    
    static List<int[]>[] adj;
        
    public int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
        
        adj = new ArrayList[n+1];
        for(int i=1;i<=n;i++){
            adj[i] = new ArrayList<>();
        }
        
        for(int i=0;i<paths.length;i++){
            int s = paths[i][0];
            int e = paths[i][1];
            int w = paths[i][2];
            adj[s].add(new int[]{e,w});
            adj[e].add(new int[]{s,w});
        }
        
        int[] isSummits = new int[n+1];
        for(int i=0;i<summits.length;i++)isSummits[summits[i]] = 1;
        
        int[] visited = new int[n+1];
        int[] prev = new int[n+1];
        int[] dist = new int[n+1];
        PriorityQueue<Item> pq = new PriorityQueue<>();
        
        for(int i=0;i<gates.length;i++){
            pq.add(new Item(gates[i], 0, -1));
        }
        
        while(!pq.isEmpty()){
            
            Item curr = pq.poll();
            
            if(visited[curr.pos] == 1) continue;
            
            prev[curr.pos] = curr.prev;
            dist[curr.pos] = curr.intensity;
            visited[curr.pos] = 1;
            if(isSummits[curr.pos] == 1)continue;
            
            for(int[] next : adj[curr.pos]){
                int nextNum = next[0];
                int time = next[1];
                if(visited[nextNum] == 0){
                    pq.add(new Item(nextNum,Math.max(curr.intensity,time),curr.pos));
                }
            }
        }
        
        int minIntensity = Integer.MAX_VALUE;
        int minSummits = Integer.MAX_VALUE;
        
        
        for(int i=0;i<summits.length;i++){
            int num = summits[i];
            
            if(dist[num] == 0) continue;
            if(dist[num] < minIntensity){
                minIntensity = dist[num];
                minSummits = num;
            }
            else if(dist[num] == minIntensity){
                minSummits = Math.min(minSummits, num);
            }
        }
        
        int[] answer = {minSummits, minIntensity};
        return answer;
    }
    
    static class Item implements Comparable<Item>{
        int pos, intensity, prev;
        public Item(int pos, int intensity, int prev){
            this.pos = pos;
            this.intensity = intensity;
        }
        
        @Override
        public int compareTo(Item o1){
            return this.intensity - o1.intensity;
        }
    }
    
}