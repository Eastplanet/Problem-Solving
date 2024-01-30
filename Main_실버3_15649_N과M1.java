package com.ssafy.daily02;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_실버3_15649_N과M1 {
	
	static StringBuilder sb = new StringBuilder();
	
	static int[] numbers;
	static boolean[] visited;
	static int N;
	static int M;
	
	public static void permutation(int count) {
		
		if(count == M) {
			for(int i=0;i<M;i++) {
				sb.append(numbers[i]+" ");
			}
			sb.append("\n");
			return;
			}
		
		for(int i=1;i<=N;i++) {
			if(visited[i])continue;
			
			numbers[count] = i;
			visited[i] = true;
			permutation(count + 1);
			visited[i] = false;
		}
	}

	public static void main(String[] args) throws Exception{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		numbers = new int[M];
		visited = new boolean[N+1];
		
		permutation(0);
		
		System.out.println(sb);
		
	}
}
