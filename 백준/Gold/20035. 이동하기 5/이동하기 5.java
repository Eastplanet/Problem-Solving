import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static StringTokenizer st;
	public static final long R = 1000000000l;

	public static void main(String[] args) throws Exception {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		st = new StringTokenizer(in.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] A = new int[N];
		int[] B = new int[M];
		
		st = new StringTokenizer(in.readLine());
		for(int i=0;i<N;i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(in.readLine());
		for(int i=0;i<M;i++) {
			B[i] = Integer.parseInt(st.nextToken());
		}

		
		
		// 1. Ai 가 가장 큰 곳까지 내려가기
		// 2-1. Ai+1 이 Ai와 똑같다면 Bi가 가장 큰 곳까지 이동
			// Ai랑 똑같을 때 까지 내려가기 그리고 오른쪽 끝까지 이동
		// 2-2. Ai+1 이 Ai와 다르다면 오른쪽 끝까지 이동
		// 3. 아래로 쭉 이동
		
		// 최대값이 가장 긴 위치를 찾는 건가? 가장 긴 위치? 
		// 최대값이 가장 먼저나온 위치에서 B가 최대인 지점까지 옮긴다.
		// 최대값이 가장 마지막인 위치까지 내려간 후(혹은 그대로) 가장 오른쪾으로 옮긴다.
		// 마지막까지 옮긴다.
		
		int[] Aidx = findMaxNumIdxStartAndEnd(A);
		
		// 1. B0 + A idx가 0이랑 같아질 때 까지
		long sum = 0;
		for(int i=0;i<=Aidx[0];i++) {
			sum += A[i]*R + B[0];
		}
		
		// 2. B의 최대지점까지 이동
		int[] Bidx = findMaxNumIdxStartAndEnd(B);
		for(int i=1;i<=Bidx[0];i++) {
			sum += A[Aidx[0]]*R + B[i];
		}
		
		// 3. A의 최대값이 마지막으로 나오는 위치까지 이동
		for(int i=Aidx[0]+1;i<=Aidx[1];i++) {
			sum += A[i]*R + B[Bidx[0]];
		}
		
		// 4. 오른쪽으로 끝까지 밀기
		for(int i=Bidx[0]+1;i<M;i++) {
			sum += A[Aidx[1]]*R + B[i];
		}
		
		// 5. 아래로 끝까지 밀기
		for(int i=Aidx[1]+1;i<N;i++) {
			sum += A[i]*R + B[M-1];
		}
		
		System.out.println(sum);
		
	}
	
	// 배열의 최대값이 가장 처음 나오는 idx와 마지막에 나오는 idx를 응답.
	public static int[] findMaxNumIdxStartAndEnd(int[] arr) {
		int[] ret = new int[2];
		
		int max = 0;
		
		for(int i=0;i<arr.length;i++) {
			if(arr[i] > max) {
				max = arr[i];
				ret[0] = i;
				ret[1] = i;
			}
			else if(arr[i] == max) {
				ret[1] = i;
			}
		}
		
		return ret;
	}
}