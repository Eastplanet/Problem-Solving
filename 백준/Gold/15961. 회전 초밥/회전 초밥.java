import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(in.readLine());
		int beltCount = Integer.parseInt(st.nextToken());
		int sushiTypeCount = Integer.parseInt(st.nextToken());
		int windowSize = Integer.parseInt(st.nextToken());
		int couponNum = Integer.parseInt(st.nextToken());

		int[] arr = new int[beltCount];
		for (int i = 0; i < beltCount; i++) {
			arr[i] = Integer.parseInt(in.readLine());
		}

		int[] visited = new int[sushiTypeCount+1];
		int eatSushiCount = 0;
		int maxEatSushiCount = 0;

		// 초기 윈도우 세팅
		for (int i = 0; i < windowSize; i++) {
			int nowSushi = arr[i];

			if (visited[nowSushi] == 0)
				eatSushiCount++;

			visited[nowSushi]++;
		}
		
		maxEatSushiCount = eatSushiCount;

		int start = 0;
		int end = windowSize - 1;
		for (int i = 1; i < beltCount; i++) {
			

			
			visited[arr[start]]--;
			if(visited[arr[start]]==0)eatSushiCount--;
			start = (start + 1) % beltCount;
			
			end = (end + 1) % beltCount;
			if(visited[arr[end]]==0)eatSushiCount++;
			visited[arr[end]]++;
			
			int coupon = 0;
			if(visited[couponNum] == 0 )coupon = 1;
			
			
			if(maxEatSushiCount < eatSushiCount + coupon) {
				maxEatSushiCount = eatSushiCount + coupon;
			}
			
		}
		
		System.out.println(maxEatSushiCount);

	}
}