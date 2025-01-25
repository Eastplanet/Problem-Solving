import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	public static StringTokenizer st;
	public static int N, K;
	public static long[] lion;
	public static long HMin, HMax, LMin, LMax;

	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		lion = new long[K];

		HMin = Long.MAX_VALUE;
		LMin = Long.MAX_VALUE;
		HMax = 0;
		LMax = 0;
		
		long sum = 0;
		long prev = 0;
		
		for (int i = 0; i < K; i++) {
			lion[i] = Long.parseLong(in.readLine());

			if (i == 0) {
				prev = lion[i];
			} else {
				sum += Math.abs(prev - lion[i]);
				prev = lion[i];
			}
			LMin = Math.min(LMin, lion[i]);
			LMax = Math.max(LMax, lion[i]);
		}

		for (int i = 0; i < N - K; i++) {
			long num = Long.parseLong(in.readLine());
			HMin = Math.min(HMin, num);
			HMax = Math.max(HMax, num);
		}

		

		
		
		// 사자 보다 더 키가 큰 경우
		if(HMax > LMax) {
			
			long ret = 2 * Math.abs(HMax - LMax); 
			// 끝에 추가할 수 있지만 중간에 넣는게 더 이득일 수 있음.
			ret = Math.min(ret, Math.abs(lion[0]-HMax));
			ret = Math.min(ret, Math.abs(lion[K-1]-HMax));
			sum += ret;
		}
		
		
		
		// 사자보다 키가 작은 경우
		if(HMin < LMin) {
			long ret = 2 * Math.abs(HMin - LMin);
			ret = Math.min(ret, Math.abs(lion[0]-HMin));
			ret = Math.min(ret, Math.abs(lion[K-1]-HMin));
			sum += ret;
		}
		
		
		
		
		System.out.println(sum);

	}

}