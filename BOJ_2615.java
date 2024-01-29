import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Main {

	public static int[][] map = new int[19][19];
	public static int[][] movepos = {
			{1,0},{1,1},{0,1},{-1,1} 
			};

	public static boolean isIn(int y, int x) {
		if (x < 0 || x >= 19)return false;
		if (y < 0 || y >= 19)return false;
		return true;
	}
	
	
	public static void input() throws Exception{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		for (int i = 0; i < 19; i++) {
			String[] line = in.readLine().split(" ");
			for (int j = 0; j < 19; j++) {
				map[i][j] = line[j].charAt(0) - '0';
			}
		}
	}

	public static void main(String[] args) throws Exception {
		
		input();

		// search
		// Left First - top First
		for (int j = 0; j < 19; j++) {
			for (int i = 0; i < 19; i++) {
				
				if (map[i][j] == 0)continue;
				
				int nowColor = map[i][j];
				for (int k = 0; k < 4; k++) {
					
					int seriesCount = 1;
					
					int dely = movepos[k][0];
					int delx = movepos[k][1];
					
					int goy = dely + i;
					int gox = delx + j;

					while(true) {
						if(!isIn(goy,gox))break;
						if(map[goy][gox] != nowColor)break;
						
						seriesCount++;
						goy += dely;
						gox += delx;
					}
					
					//반대 방향 탐색
					dely *= -1;
					delx *= -1;
					goy = dely + i;
					gox = delx + j;
					while(true) {
						if(!isIn(goy,gox))break;
						if(map[goy][gox] != nowColor)break;
						
						seriesCount++;
						goy += dely;
						gox += delx;
					}
					
					
					if(seriesCount == 5) {
						System.out.println(nowColor);
						System.out.println((i+1) + " " + (j+1));
						return ;
					}
					
					
					

				}

			}
		}
        
        System.out.println("0");

	}
}