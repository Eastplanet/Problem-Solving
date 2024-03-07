import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
	
	static int N,M;
	static HashSet<Integer>set = new HashSet<>();
	static int[] visit;
	static Integer[] arr;
	
	public static void main(String[] args) throws Exception{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		N= Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		visit = new int[M];
		
		
		st = new StringTokenizer(in.readLine());
		for(int i=0;i<N;i++) {
			set.add(Integer.parseInt(st.nextToken()));
		}
		
		arr = set.toArray(new Integer[0]);
		Arrays.sort(arr);
		
		back(0,0);
		
	}
	
	static void back(int count, int start) {
		
		if(count == M) {
			for(int i=0;i<M;i++) {
				System.out.print(visit[i]+ " ");
			}
		
			System.out.println();
			return;
		}
		
		
		for(int i=start;i<arr.length;i++) {
			visit[count] = arr[i];
			back(count+1,i);
		}
	}
}