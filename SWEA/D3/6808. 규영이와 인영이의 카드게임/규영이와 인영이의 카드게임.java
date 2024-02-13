import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
	
	static int[] arr;
	static int[] visited;
	static int winCount;
	static int loseCount;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int TC = Integer.parseInt(in.readLine());
		for(int tc=1;tc<=TC;tc++) {
			sb.append("#"+tc+" ");
			arr = new int[9];
			visited = new int[19];
			winCount = 0;
			loseCount = 0;
			
			StringTokenizer st = new StringTokenizer(in.readLine());
			for(int i=0;i<9;i++) {
				arr[i] = Integer.parseInt(st.nextToken());
				visited[arr[i]] = 1;
			}
			
			ArrayList<Integer>visit = new ArrayList<>();
			permutation(0, visit);
			
			sb.append(winCount+" "+loseCount+"\n");
			
			
		}
		System.out.println(sb);
	}
	
	public static void permutation(int count, ArrayList<Integer>visit) {
		
		if(count == 9) {
			int gyuScore = 0;
			int inScore = 0;
			
			for(int i=0;i<9;i++) {
				if(arr[i] < visit.get(i)) {
					inScore += (arr[i]+visit.get(i));
				}
				else {
					gyuScore += (arr[i]+visit.get(i));
				}
			}
			if(gyuScore > inScore) {
				winCount++;
			}
			else if(gyuScore < inScore){
				loseCount++;
			}
			
			return;
		}
		
		for(int i=1;i<=18;i++) {
			if(visited[i] == 1)continue;
			
			visited[i] = 1;
			visit.add(i);
			permutation(count+1, visit);
			visited[i] = 0;
			visit.remove(visit.size()-1);
		}
		
		
		
	}
}