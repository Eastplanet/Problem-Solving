
import java.util.ArrayList;

public class Solution {

	
	int MAX = 1005000;
	int[] indegree = new int[MAX];
	int[] visited = new int[MAX];
	ArrayList<Integer>[] adj = new ArrayList[MAX];
	
	
	public int[] solution(int[][] edges) {
		int[] answer = {0,0,0,0};
		
		for(int i=0;i<MAX;i++) adj[i] = new ArrayList<>();

		for (int i = 0; i < edges.length; i++) {
			int start = edges[i][0];
			int end = edges[i][1];
			indegree[end]++;
			adj[start].add(end);
		}
		
		int generateNode = -1;
		for(int i=0;i<MAX;i++) {
			if(indegree[i] == 0 && adj[i].size() >= 2) {
				generateNode = i;
				answer[0] = generateNode;
				break;
			}
		}
		
		
		for(int next : adj[generateNode]) {
			indegree[next]--;
			answer[find(next)]++;
		}
		
		
		return answer;
	}
	
	int find(int num) {
		int DONUT = 1;
		int STICK = 2;
		int EIGHT = 3;
		
		int now = num;
		
		while(true) {
			if(adj[now].size() == 2) {
				return EIGHT;
			}
			else if(adj[now].size() == 0) {
				return STICK;
			}
			
			int next = adj[now].get(0);
			if(next == num) {
				return DONUT;
			}
			
			now = next;
		}
	}

}
