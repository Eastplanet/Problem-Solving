package ps;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;


class Person{
	int num;
}

public class BOJ_1026 {
	

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(in.readLine());
		int[] A = new int[N];
		Person[] B = new Person[N];
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(in.readLine());
		for (int i = 0; i < N; i++) {
			B[i] = new Person();
			B[i].num = Integer.parseInt(st.nextToken());
		}
		
		Comparator<Person> comp = new Comparator<Person>() {
			@Override
			public int compare(Person o1, Person o2) {
				return o2.num - o1.num;
			}
		};
		
		Arrays.sort(A);
		Arrays.sort(B,comp);
		
	
		
		
		int sum = 0;
		for(int i=0;i<N;i++) {
			sum += A[i] * B[i].num;
		}
		
		System.out.print(sum);

	}

}
