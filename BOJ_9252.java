package ps;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_9252 {
	
	public static int[][] arr;
	public static Stack<Character> S = new Stack<>();
	public static String A;
	public static String B;
	
	public static void findStr(int i, int j) {
		if(i <= 0 || j <= 0)return;
		
		if(A.charAt(i - 1) == B.charAt(j - 1)) {
			S.add(A.charAt(i-1));
			findStr(i-1,j-1);
		}
		else if(arr[i-1][j] > arr[i][j-1]) {
			findStr(i-1,j);
		}
		else {
			findStr(i,j-1);
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		A = in.readLine();
		B = in.readLine();

		arr = new int[A.length() + 1][B.length() + 1];

		int maxCount = 0;
		int maxIdxY = 0;
		int maxIdxX = 0;

		for (int i = 0; i < A.length() + 1; i++) {
			if (i == 0)
				continue;
			for (int j = 0; j < B.length() + 1; j++) {
				if (j == 0)
					continue;

				if (A.charAt(i - 1) == B.charAt(j - 1)) {
					arr[i][j] = arr[i - 1][j - 1] + 1;

					if (maxCount < arr[i][j]) {
						maxCount = arr[i][j];
						maxIdxY = i;
						maxIdxX = j;
					}
				} else {
					arr[i][j] = Math.max(arr[i - 1][j], arr[i][j - 1]);
				}
			}
		}

		sb.append(maxCount);
		sb.append("\n");

		findStr(maxIdxY,maxIdxX);

		

		while(!S.empty()) {
			sb.append(S.pop());
		}
		
		System.out.println(sb);

	}
}
