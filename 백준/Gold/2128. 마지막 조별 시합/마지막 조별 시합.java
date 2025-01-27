import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	public static StringTokenizer st;
	public static int N, D, K;
	public static int[] canSolveTask;
	public static int[] visited;
	public static int maxATeamCnt;

	public static void main(String[] args) throws Exception {
		input();
		makeComb(0,1);
		System.out.println(maxATeamCnt);
	}

	// D 중에서 K개를 뽑는다.
	public static void makeComb(int cnt,int next) {

		if (cnt == K) {
			
			maxATeamCnt = Math.max(maxATeamCnt, CntMaxATeam());
			return;
		}

		for (int i = next; i <= D; i++) {
			if (visited[i] == 1) {
				continue;
			}
			visited[i] = 1;
			makeComb(cnt + 1, i);
			visited[i] = 0;
		}
	}
	

	// 현재 문제 집합 (visited) 에 포함된 문제들만 풀 수 있는 학생들을 카운트한다.
	public static int CntMaxATeam() {
		
		// 2번 3번 문제가 집합에 포함된다면 test = 110 으로 만든다.
		int test = 0;
		for(int i=1;i<=D;i++) {
			if(visited[i] == 1) {
				test = test | (1 << (i-1));
			}
		}
		
		
		int cnt = 0;
		
		for (int i = 0; i < N; i++) {

			// 비트마스킹으로 집합에 포함되지 않는 문제를 풀 수 있는 지 확인
			// test를 ~연산을 통해 001으로 만들고, canSolveTask와 &연산을 진행한다.
			// canSolve가 101 (1번째 3번째 풀기 가능)이었다면 연산 결과는 001
			// canSolve가 0이 아니라면 집합을 벗어난 문제를 해결 가능하므로 카운트하지 않는다.
			int tmp = canSolveTask[i] & (~test);
			if(tmp == 0) {
				cnt++;
			}
		}

		return cnt;
	}
	 

	public static void input() throws Exception {
		st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		visited = new int[D+1];

		// canSolveTask[i][j] = 1 -> i번 학생이 j번 문제를 풀 수 있다.
		canSolveTask = new int[N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			int cnt = Integer.parseInt(st.nextToken());
			for (int j = 0; j < cnt; j++) {
				int taskNum = Integer.parseInt(st.nextToken());
				canSolveTask[i] = canSolveTask[i] | (1 << (taskNum-1));
			}
		}
	}
}