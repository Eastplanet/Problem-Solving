import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(in.readLine());
		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(in.readLine());

			// count[1] -> 1로만 처리 가능
			// count[0] -> 1혹은 2로 처리 가능
			int[] count = new int[2];
			int[] arr = new int[N];
			int max = 0;

			StringTokenizer st = new StringTokenizer(in.readLine());
			for (int i = 0; i < N; i++) {
				int v = Integer.parseInt(st.nextToken());
				arr[i] = v;
				if (max < arr[i]) {
					max = arr[i];
				}
			}

			for (int i = 0; i < N; i++) {
				if (arr[i] % 2 == max % 2) {
					count[0] += max -arr[i];
				} else {
					count[1] += 1;
					count[0] += (max - arr[i] - 1);
				}
			}

			int day = 1;

			while (true) {
				
				
				
				if (count[0] == 0 && count[1] == 0) {
					break;
				}

				// 1만큼 키우기
				if (day % 2 == 1) {
					if (count[1] > 0) {
						count[1]--;
						day++;
						continue;
					}

					// 자라게 하지 않고 넘기는게 유리
					if (count[0] == 2) {
						day++;
						continue;
					}
					else {
						count[0] -= 2;
						count[1]++;
						day++;
						continue;
					}
				} //2만큼 키우기
				else {
					
					if(count[0] == 0) {
						day++;
						continue;
					}
					
					
					if(count[0] > 0) {
						count[0] -= 2;
						day++;
						continue;
					}
				}

			}
			
			sb.append("#"+tc+" "+(day-1)+"\n");

		}
		
		System.out.println(sb);
	}
}