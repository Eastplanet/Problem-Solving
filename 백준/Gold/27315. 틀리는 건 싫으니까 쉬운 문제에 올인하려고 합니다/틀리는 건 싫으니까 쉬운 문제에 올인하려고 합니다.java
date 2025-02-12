import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	public static StringTokenizer st;
	public static int N,M,HD,HP;
	public static PriorityQueue<Problem> solveQueue, readyQueue;
	
	public static void main(String[] args) throws Exception {
		
		// 입력
		input();
		
		// M개의 문제를 풀 때 동안 반복
		int solveCnt = 0;
		long failCnt = 0;
		
		while(solveCnt < M) {
			
			// 현재 한별 아이디어로 풀 수 있는 문제를 solveQueue로 옮긴다.
			while(!readyQueue.isEmpty()) {
				// 한별의 아이디어로 문제를 풀 수 있다면
				if(HD >= readyQueue.peek().d) {
					solveQueue.add(readyQueue.poll());
                    continue;
				}
				else {
					break;
				}
			}
			
			if(solveQueue.isEmpty()) {
				break;
			}
			// solveQueue에서 가장 구현이 쉬운 문제를 하나 푼다.
			Problem p = solveQueue.poll();
			
			// 푼 문제 횟수와 틀린 횟수 갱신
			solveCnt++;
			if(HP < p.p) {
				failCnt += p.p - HP;
			}
			
			// 능력을 증가시킨다.
			HP++;
			HD++;
		}
		
		if(solveCnt < M) {
			System.out.println("-1");
		}
		else {
			System.out.println(failCnt);
		}
	}
	
	public static void input() throws Exception {
		st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		// 풀 수 있는 문제는 구현이 쉬운 것부터 푼다.
		solveQueue = new PriorityQueue<>((Problem o1, Problem o2)->{
			return o1.p - o2.p;
		});
		// 모든 문제는 아이디어 순으로 정렬시켜 놓는다.
		readyQueue = new PriorityQueue<>((Problem o1, Problem o2)->{
			return o1.d - o2.d;
		});
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(in.readLine());
			int D = Integer.parseInt(st.nextToken());
			int P = Integer.parseInt(st.nextToken());
			int T = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());
			readyQueue.add(new Problem(D, P, T, E));
		}
		
		st = new StringTokenizer(in.readLine());
		HD = Integer.parseInt(st.nextToken());
		HP = Integer.parseInt(st.nextToken());
	}
	
	
	public static class Problem {
		int d,p;
		public Problem(int D,int P,int T,int E) {
			this.d = D;
			this.p = P;
			if(T == 1) {
				p = 0;
			}
			if(E == 1) {
				if(D % 2 == 1) {
					d = d/2 + 1;
				}
				else {
					d /= 2;					
				}
				p = Math.min(p, P/2);
			}
		}
	}
}