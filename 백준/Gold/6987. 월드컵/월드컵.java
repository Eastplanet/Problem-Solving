import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int[][] score;
	static int[][] tmpScore;
	static boolean flag;

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		for (int i = 0; i < 4; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());

			score = new int[6][3];
			tmpScore = new int[6][3];
			flag = false;

			for (int j = 0; j < 6; j++) {
				for (int k = 0; k < 3; k++) {
					score[j][k] = Integer.parseInt(st.nextToken());
				}
			}

			back(0, 1);
			
			if(flag) {
				System.out.print(1+" ");
			}
			else {
				System.out.print(0+" ");
			}

		}
	}

	public static void back(int a, int b) {
		
		if (b == 6) {
			a++;
			b = a + 1;
		}
		
		
		if(a == 5 && b == 6) {
			for(int i=0;i<6;i++) {
				for(int j=0;j<3;j++) {
					if(tmpScore[i][j] != score[i][j]) {
						return;
					}
				}
			}
			
			flag = true;
			return;
		}

		tmpScore[a][0]++;
		tmpScore[b][2]++;
		back(a, b + 1);
		tmpScore[a][0]--;
		tmpScore[b][2]--;

		tmpScore[a][1]++;
		tmpScore[b][1]++;
		back(a, b + 1);
		tmpScore[a][1]--;
		tmpScore[b][1]--;
		
		tmpScore[a][2]++;
		tmpScore[b][0]++;
		back(a,b+1);
		tmpScore[a][2]--;
		tmpScore[b][0]--;

	}
}