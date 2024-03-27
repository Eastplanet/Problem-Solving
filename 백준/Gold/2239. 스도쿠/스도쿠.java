import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	static int[][] map = new int[9][9];
	static int[][] garo = new int[9][10];
	static int[][] sero = new int[9][10];
	static int[][] nemo = new int[9][10];
	static int[][][] sector = new int[3][3][10];

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		for (int i = 0; i < 9; i++) {
			String tmp = in.readLine();
			for (int j = 0; j < 9; j++) {
				map[i][j] = (int) (tmp.charAt(j) - '0');
			}
		}

		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				garo[i][map[i][j]] = 1;
				sero[j][map[i][j]] = 1;
				sector[i/3][j/3][map[i][j]]=1;
			}
		}
		
	
		BACK();

	}
	
	static void BACK() {
		
		boolean change = false;
		
		for(int i=0;i<9;i++) {
			for(int j=0;j<9;j++) {
				if(map[i][j] == 0) {
					change = true;
					for(int k=1;k<=9;k++) {
						if(garo[i][k] == 0 && sero[j][k] == 0 && sector[i/3][j/3][k] == 0) {
							garo[i][k] = 1;
							sero[j][k] = 1;
							sector[i/3][j/3][k] = 1;
							map[i][j] = k;
							
							BACK();
							
							map[i][j] = 0;
							garo[i][k] = 0;
							sero[j][k] = 0;
							sector[i/3][j/3][k] = 0;
						}
					}
					
				}
				if(change) {
					return;
				}
			}
			if(change) {
				return;
			}
		}
		
		if(change == false) {
			
			for(int i=0;i<9;i++) {
				for(int j=0;j<9;j++) {
					System.out.print(map[i][j]);
				}
				System.out.println();
			}
			System.exit(0);
		}
	}
}