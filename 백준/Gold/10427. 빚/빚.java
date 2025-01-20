import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	public static StringTokenizer st;
	
	public static int N;
	public static long[] arr,sum;

	
	public static void main(String[] args) throws Exception {
		
		int T = Integer.parseInt(in.readLine());
		
		while(T-- > 0) {
			init();
			
			long answer = 0;
			
			
			// i 번 돈을 갚는다.
			for(int i=2;i<=N;i++) {
				
				long min = Long.MAX_VALUE;
				
				// j에서 시작해서 j+i-1까지를 선택한다.
				// ex) i가 2인경우  0 ~ 1까지 2개 선택
				for(int j=0;j<N-(i-1);j++) {
					
					// j~j+i-1까지의 합
					long hap;
					if(j == 0) {
						hap = sum[j+i-1];
					}
					else {
						hap = sum[j+i-1] - sum[j-1];
					}
					
					// 최소값 찾기
					min = Math.min(min, arr[j+i-1]*i - hap);
				}
				
				answer += min;
			}
			
			System.out.println(answer);
			
		}
		
	}
	
	public static void init() throws Exception {
		st = new StringTokenizer(in.readLine());
		
		N = Integer.parseInt(st.nextToken());
		arr = new long[N];
		sum = new long[N];
		
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		// 정렬
		Arrays.sort(arr);
		
		for(int i=0;i<N;i++) {
			if(i == 0) {
				sum[i] = arr[i];
			}
			else {
				sum[i] = sum[i-1] + arr[i];
			}
		}
	}
	
	
	

}