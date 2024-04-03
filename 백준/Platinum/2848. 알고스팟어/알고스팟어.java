import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(in.readLine());
		String[] word = new String[N];
		for(int i=0;i<N;i++)word[i] = in.readLine();
		
		
		int[] indegree = new int[27];
		ArrayList<Integer>[] adj = new ArrayList[27];
		for(int i=0;i<27;i++)adj[i] = new ArrayList<>();
		
		int[] Show = new int[27];
		int[][] alreadyUsed = new int[27][27];
		
		for(int i=0;i<N-1;i++) {
				
				String A = word[i];
				String B = word[i+1];
				
				int idx = 0;
				// 다른 위치에서 break
				for(idx=0;idx<Math.min(A.length(), B.length());idx++) {
					if(A.charAt(idx) != B.charAt(idx))break;
				}
				
				// 둘중의 한 단어 길이 이상으로 넘어갔다면 알파벳 비교가 어려움
				if(idx >= A.length() || idx >= B.length()){
					if(A.length() > B.length()) {
						System.out.println("!");
						return;
					}
					continue;
				}
				
				
				
				// word[i].charAt[idx]의 단어가 앞선다.
				int a = (int)(A.charAt(idx)-'a');
				int b = (int)(B.charAt(idx)-'a');
				
				//한번 비교한 글자들이 또 사용되지 않게 막기
				if(alreadyUsed[a][b] == 1)continue;
				alreadyUsed[a][b] = 1;
				
				indegree[b]++;
				adj[a].add(b);
			
		}
		
		//등장하지 않은 단어를 저장
		for(int i=0;i<N;i++) {
			
			for(int j=0;j<word[i].length();j++) {
				int tmp = (int)(word[i].charAt(j)-'a');
				Show[tmp] = 1;
			}
		}
		
		
		Queue<Integer> q = new ArrayDeque<>();
		for(int i=0;i<27;i++) {
			if(Show[i] == 0)continue;
			
			if(indegree[i] == 0) {
				q.add(i);
			}
		}
		
		boolean possibleTwo = false;
		
		while(!q.isEmpty()) {
			if(q.size() >= 2) {
				possibleTwo = true;
			}
			int cur = q.poll();
			sb.append((char)(cur+'a'));
			for(int next: adj[cur]) {
				indegree[next]--;
				if(indegree[next]==0) {
					q.add(next);
				}
			}
		}
		
		for(int i=0;i<27;i++) {
			if(indegree[i] !=0) {
				System.out.println("!");
				return;
			}
		}
		
		if(possibleTwo) {
			System.out.println("?");
			return;
		}
		
		System.out.println(sb);
		
	}
	
	
}