import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		// 1. 구간을 찾는다. 길이가 1인구간 2인구간 3인구간 등..
		// 2. 그 구간의 시작 K를 찾는다. (이전 구간들의 합)
		// 3. 구간에서 내가 찾고자하는 K가 속한 숫자가 몇번째 수인지 찾는다. 구간을 0~k로 바꿔서 /(숫자의길이)를 해서 몇번째 수인지 찾는다.
		// 4. K가 속한 숫자를 찾는다.
		// 5. 그 숫자의 시작k를 찾는다.

		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		long sessionSum = 0;
		long[] countForSession = new long[9];

		// 0 : 1 x (10 - 1) >= k,   1 ~ 9 구간의 개수
		// 1 : 2 x (100 - 10) >= k     10 ~ 99 구간의 개수
		// 2 : 3 x (1000 - 100) >= k     100 ~ 999 구간의 개수

		// 1. 구간을 찾는다. K가 속한 구간이 나온다.
		long num = 10;
		int existSession = -1;
		sessionSum = countForSession[0];
		for (int i = 0; i < 9; i++) {

			countForSession[i] = (i + 1) * (long)(Math.pow(10, i+1) - (long)(Math.pow(10, i)));
			sessionSum += countForSession[i];

			if (sessionSum >= K) {
				existSession = i;
				break;
			} 
		}

		// 인덱스로 계산할꺼라
		K--;

		// 2. 그 구간의 시작 인덱스를 찾는다. (존재하는 구간의 이전 구간들의 합) => sessionSum
		long startIdx = sessionSum - countForSession[existSession];

		// 3. 구간에서 내가 찾고자하는 K가 속한 숫자가 몇번째 수인지 찾는다. (K - 구간의 시작 인덱스 )/(숫자의길이)를 해서 몇번째 수인지 찾는다.
		long tmpK = (K) - startIdx; // 구간에서의 상대적 위치
		long numIdx = tmpK / (existSession + 1); // 해당 구간은  숫자마다 (existSession+1)개로 구성되므로, 이 수로 나눠주면 숫자의 인덱스가 나온다. 

		// 구간의 시작 숫자를 구한다.
		long startNum = (long) Math.pow(10, existSession);
		// 4. K가 속한 숫자를 찾는다.
		long targetNum = startNum + numIdx; // (구간의 시작 숫자) + (몇 번째 숫자인지)

		
		if (targetNum > N) {
			System.out.println("-1");
		} else {
			String target = Long.toString(targetNum);
			
			// 5. K가 속한 숫자의 시작인덱스를 찾는다.
			long targetNumStartIdx = (targetNum - startNum) * (existSession + 1);
			long targetNumIdx = tmpK - targetNumStartIdx;
			System.out.println(target.charAt((int) targetNumIdx));
		}

	}

}