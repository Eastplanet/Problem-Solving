import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		// 1. 구간을 찾는다.
		// 2. 그 구간의 시작 K를 찾는다. (이전 구간들의 합)
		// 3. 구간을 0~k로 바꿔서 /(숫자의길이)를 해서 몇번째 수인지 찾는다.
		// 4. 그 숫자의 시작k를 찾는다.

		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		

		long sessionSum = 0;
		long[] countForSession = new long[9];

		// 0 : 1 x (10 - 1) >= k
		// 1 : 2 x (100 - 10 - 1) >= k
		// 2 : 3 x (1000 - 100 - 1) >= k

		// 1. 구간을 찾는다. K가 속한 구간이 나온다.
		long num = 10;
		int existSession = -1;
		sessionSum = countForSession[0];
		for (int i = 0; i < 9; i++) {

			if (i == 0) {
				countForSession[i] = 9;
			} else {
//				countForSession[i] = (i + 1) * (num - (num / 10) - 1);
				countForSession[i] = (i + 1) * (num - (num / 10));
			}

			sessionSum += countForSession[i];

			// 
			if (sessionSum >= K) {
				existSession = i;
				break;
			} else {
				num *= 10;
			}
		}
		
		K--;

		// 2. 그 구간의 시작 K를 찾는다. (존재하는 구간의 이전 구간들의 합) => sessionSum
		long startK = sessionSum - countForSession[existSession];

		// 3. 구간을 0~k로 바꿔서 /(숫자의길이)를 해서 몇번째 수인지 찾는다.
		long tmpK = (K) - startK;

		// 4. K가 몇 번째 숫자에 속한지 확인한다.
		long numIdx = tmpK / (existSession + 1);

		long startNum = (long) Math.pow(10, existSession);

		long targetNum = startNum + numIdx;

		if (targetNum > N) {
			System.out.println("-1");
		} else {
			String target = Long.toString(targetNum);

			// targetNum의 시작의 k가 무엇인지 알아낸다.
			long targetNumStartIdx = (targetNum - startNum) * (existSession + 1);
			long targetNumIdx = tmpK - targetNumStartIdx;
			System.out.println(target.charAt((int) targetNumIdx));
		}

	}

}