import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int[][] arr = new int[10][10];
	static int[] leftPaper = {5,5,5,5,5};
	static int result = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		
		int paperCount = 0;
		
		for(int i=0;i<10;i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			for(int j=0;j<10;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if(arr[i][j] == 1)paperCount++;
			}
		}
		
		if(paperCount == 0) {
			System.out.println(0);
			return;
		}
		
		
		back(0,0,0);
		
		if(result == Integer.MAX_VALUE) {
			System.out.println(-1);
		}
		else {
			System.out.println(result);
		}
		
		
		
	}
	
	static void back(int x,int y, int usedPaper) {
		
		if(x==10) {
			x = 0;
			y++;
		}
		
		if(y==10) {
			if(result > usedPaper) {
				result = usedPaper;
			}
			return;
		}
		
		for(int i=y;i<10;i++) {
			for(int j=0;j<10;j++) {

				if(arr[i][j]==0)continue;
				
				for(int k=4;k>=0;k--) {
					if(leftPaper[k]==0)continue;
					if(canAttach(j, i, k+1)) {
						leftPaper[k]--;
						fillPaper(j, i, k+1, 0);
						back(j+1,i,usedPaper+1);
						fillPaper(j, i, k+1, 1);
						leftPaper[k]++;
					}
				}
				
				
				return;
			}
		}
		
		if(result > usedPaper) {
			result = usedPaper;
		}
		
		
	}
	
	static void fillPaper(int x,int y,int size, int type) {
		for(int i=y;i<y+size;i++) {
			for(int j=x;j<x+size;j++) {
				arr[i][j] = type;
			}
		}
	}
	
	static boolean canAttach(int x,int y, int size) {
		if(x+size >10)return false;
		if(y+size >10)return false;
		for(int i=y;i<y+size;i++) {
			for(int j=x;j<x+size;j++) {
				if(arr[i][j]==0)return false;
			}
		}
		return true;
	}
}