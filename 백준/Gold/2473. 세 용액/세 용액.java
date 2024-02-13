import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(in.readLine());
		StringTokenizer st = new StringTokenizer(in.readLine());
		long[] arr = new long[N];

		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(arr);

		int findA = -1;
		int findB = -1;
		int findC = -1;
		long min = Long.MAX_VALUE;

		for (int i = 0; i < N; i++) {

			int l = i + 1;
			int r = N - 1;
			long tempMin = Long.MAX_VALUE;
			int tempL = -1;
			int tempR = -1;

			while (r - l > 0) {

				long val = arr[i] + arr[l] + arr[r];

				if (Math.abs(val) < tempMin) {
					tempMin = Math.abs(val);
					tempL = l;
					tempR = r;
				}

				if (val < 0) {
					l++;
				} else if (val > 0) {
					r--;
				} else {
					break;
				}

			}

			if (min > tempMin) {
				min = tempMin;
				findA = i;
				findB = tempL;
				findC = tempR;
			}

			if (min == 0) {
				break;
			}

		}

		System.out.println(arr[findA] + " " + arr[findB] + " " + arr[findC]);
	}
}