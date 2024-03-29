import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int[] items;

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(in.readLine());

		N = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		items = new int[N];
		
		st = new StringTokenizer(in.readLine());
		for (int i = 0; i < N; i++) {
			items[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(items);

		for (int i = 0; i < N; i++) {
			if (items[i] == C) {
				System.out.println("1");
				return;
			} else if (items[i] > C) {
				System.out.println("0");
				return;
			}
			for (int j = 0; j < N; j++) {
				if (i == j)continue;

				if (items[i] + items[j] == C) {
					System.out.println(1);
					return;
				} else if (items[i] + items[j] > C) {
					break;
				} else {
					
					int findVal = C - (items[i] + items[j]);
					int result = BS(findVal);

					if (result == -1 || result == i || result == j) {
						continue;
					} else {
						System.out.println(1);
						return;
					}

				}
			}
		}
		System.out.println(0);
		

	}

	static int BS(int find) {
		int start = 0;
		int end = N - 1;

		while (start <= end) {

			int mid = (start + end) / 2;

			if (items[mid] == find) {
				return mid;
			}

			if (mid > find) {
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}

		return -1;
	}
}