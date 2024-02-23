import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int[] permu, visited;
	static int[][] arr;
	static int maxScore;

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(in.readLine());
		permu = new int[9];
		visited = new int[9];
		// arr[i][j] i이닝에 j선수가 타격
		arr = new int[N][9];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			for (int j = 0; j < 9; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		back(0);
		
		System.out.println(maxScore);
		

	}

	public static void back(int idx) {
		if (idx == 8) {
			calcMaxScore();
			return;
		}

		for (int i = 1; i < 9; i++) {
			if (visited[i] == 1)
				continue;
			visited[i] = 1;
			permu[idx] = i;
			back(idx + 1);
			visited[i] = 0;
		}
	}
	
	public static void calcMaxScore() {
		int[] sequence = new int[9];
		int idx = 0;

		for(int i=0;i<3;i++) {
			sequence[i] = permu[i];
		}
		sequence[3] = 0;
		for(int i=4;i<9;i++) {
			sequence[i] = permu[i-1];
		}
		
		//타격 순서 sequence
		int score = 0;
		int order = 0;
		for(int inning = 0 ; inning < N; inning++) {
			int out = 0;
			boolean[] base = new boolean[3];
			
			while(out != 3) {
				int player = sequence[order];
				if(arr[inning][player] == 0) {
					out++;
				}
				else if(arr[inning][player] == 1) {
					if(base[2]) {
						base[2] = false;
						score++;
					}
					if(base[1]) {
						base[2] = true;
						base[1] = false;
					}
					if(base[0]) {
						base[1] = true;
						base[0] = false;
					}
					
					base[0] = true;
				}
				else if(arr[inning][player] == 2) {
					if(base[2]) {
						base[2] = false;
						score++;
					}
					if(base[1]) {
						base[1] = false;
						score++;
					}
					if(base[0]) {
						base[2] = true;
						base[0] = false;
					}
					
					base[1] = true;
				}
				else if(arr[inning][player] == 3) {
					if(base[2]) {
						base[2] = false;
						score++;
					}
					if(base[1]) {
						base[1] = false;
						score++;
					}
					if(base[0]) {
						base[0] = false;
						score++;
					}
					
					base[2] = true;
				}
				else if(arr[inning][player] == 4) {
					if(base[2]) {
						base[2] = false;
						score++;
					}
					if(base[1]) {
						base[1] = false;
						score++;
					}
					if(base[0]) {
						base[0] = false;
						score++;
					}
					
					score++;
				}
				
				order = (order+1)%9;
			}
		}
		
		if(maxScore < score) {
			maxScore = score;
		}
	}
}