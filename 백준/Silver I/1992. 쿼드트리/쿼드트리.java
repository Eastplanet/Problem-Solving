import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int[][] map;
	
	public static void main(String[] args) throws Exception{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		
		int N = Integer.parseInt(in.readLine());
		
		map = new int[N][N];
		
		for(int i=0;i<N;i++) {
			String tmp = in.readLine();
			for(int j=0;j<N;j++) {
				map[i][j] = (tmp.charAt(j)-'0');
			}
		}
		
		System.out.println(recv(0,0,N-1,N-1));
		
	}
	
	public static String recv(int minY,int minX, int maxY,int maxX) {
		
		
		int first = map[minY][minX];
		boolean flag = true;
		
		for(int i=minY;i<=maxY;i++) {
			for(int j=minX;j<=maxX;j++) {
				if(map[i][j]!=first) {
					flag = false;
					break;
					}
			}
		}
		
		if(flag) {
			if(first == 1)return "1";
			else return "0";
		}
		else {
			int midY = (minY+maxY)/2;
			int midX = (minX+maxX)/2;
			
			
			StringBuilder sbuilder = new StringBuilder();
			sbuilder.append("(");
			sbuilder.append(recv(minY,minX,midY,midX));
			sbuilder.append(recv(minY,midX+1,midY,maxX));
			sbuilder.append(recv(midY+1,minX,maxY,midX));
			sbuilder.append(recv(midY+1,midX+1,maxY,maxX));
			sbuilder.append(")");
			return sbuilder.toString();
		}
		
	}
}