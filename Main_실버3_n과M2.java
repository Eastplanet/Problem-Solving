package com.ssafy.daily03;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_실버3_n과M2 {

	static int N;
	static int M;
	static StringBuilder sb = new StringBuilder();
	static int[] visited = new int[9];
//	static int[] arr = new int[10];

	public static void comb(int idx, int deep) {

		if (deep == M) {
			for (int i = 1; i <= N; i++) {
				if(visited[i] == 1) sb.append(i+" ");
			}
			sb.append("\n");
			return;
		}
		

		for (int i = idx; i <= N; i++) {
			if (visited[i] == 1)continue;

			visited[i] = 1;
			comb(i + 1, deep + 1);
			visited[i] = 0;
		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		comb(1, 0);

		System.out.println(sb);
	}
}
