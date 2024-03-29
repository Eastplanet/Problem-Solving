import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		char[] T = in.readLine().toCharArray();
		char[] P = in.readLine().toCharArray();
		int tLength = T.length;
		int pLength = P.length;
		
//		if(pLength < 1000)return;

		// 1단계: 부분일치 테이블 만들기 (패턴 분석)
		int[] pi = new int[pLength]; // pi 테이블

		// i: 패턴의 접미사 포인터
		// j: 패턴의 접두사 포인터
		for (int i = 1, j = 0; i < pLength; i++) {

			while (j > 0 && P[i] != P[j]) {
				j = pi[j - 1];
			}

			if (P[i] == P[j]) {
				pi[i] = ++j;
			} else {
				pi[i] = 0;
			}
		}

//		System.out.println(Arrays.toString(pi));
		
		int cnt = 0;
		List<Integer> list = new ArrayList<>();

		// 2단계: 부분일치 테이블을 활용하여 텍스트와 패턴 비교
		// i: 텍스트의 접미사 포인터
		// j: 패턴의 접두사 포인터
		for (int i = 0, j = 0; i < tLength; i++) {

			while (j > 0 && T[i] != P[j]) {
				j = pi[j - 1];
			}

			// 두 글자 일치
			if(T[i] == P[j]) {
				
				// j가 패턴의 마지막 인덱스라면 패턴과 일치하는 단어 찾기 완료!
				if(j == pLength - 1) {
					cnt++;
					list.add(i - (pLength - 1));
					
					j = pi[j];
				}
				//j가 패턴의 마지막 인덱스가 아닐 경우는 다음 패턴 인덱스로 이동
				else {
					j++;
				}
			}
			
		}
		
		System.out.println(cnt);
		for(int i=0;i<list.size();i++) {
			System.out.print((list.get(i)+1)+ " ");
		}

	}
}