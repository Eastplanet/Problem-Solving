import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main {

	public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	public static StringTokenizer st;
	public static int N,M,K;
	public static int[][] arr;
	public static Pos[][] d;
	public static int[] dx = {0,0,1,-1};
	public static int[] dy = {1,-1,0,0};
	public static int[][] alreadyCheck;
	
	public static void main(String[] args) throws Exception {
		
		input();
		
		// 1. 각 영역마다 유니온-파인드로 묶어놓고 크기를 적어놓는다.
		d = new Pos[1001][1001];
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				d[i][j] = new Pos(-1,-1);
			}
		}
		
		// 2. 0인 공간을 대상으로 같은 집합에 포함시킨다.
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				
				if(arr[i][j] == 0 && alreadyCheck[i][j] == 0) {
					alreadyCheck[i][j] = 1;
					
					Queue<int[]> q = new ArrayDeque<>();
					q.add(new int[] {i,j});
					
					
					while(!q.isEmpty()) {
						int[] curr = q.poll();
						
						for(int z=0;z<4;z++) {
							int gox = curr[1] + dx[z];
							int goy = curr[0] + dy[z];
							if(gox < 0 || gox >= M || goy < 0 || goy >= N || arr[goy][gox] == 1 || alreadyCheck[goy][gox] == 1) {
								continue;
							}
							
							alreadyCheck[goy][gox] = 1;
							merge(new Pos(j,i), new Pos(gox,goy));
							q.add(new int[] {goy,gox});
						}
					}
				}
			}
		}
		
		// 3. 1인 공간을 대상으로 그 주변의 빈공간 집합의 크기를 모두 더한 뒤 출력한다.
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(arr[i][j] == 0) {
					System.out.print(0);
				}
				else {
					int sum = 0;
					
					List<Pos> duplicateCheck = new ArrayList<>();
					
					for(int k=0;k<4;k++) {
						int gox = j + dx[k];
						int goy = i + dy[k];
						if(gox < 0 || gox >= M || goy < 0 || goy >= N || arr[goy][gox] == 1) {
							continue;
						}
						
						Pos pos = find(new Pos(gox,goy));
						
						// 중복되지 않도록 더한다.
						boolean isDuplicate = false;
						for(Pos check : duplicateCheck) {
							if(check.y == pos.y && check.x == pos.x) {
								isDuplicate = true;
								break;
							}
						}
						if(isDuplicate) {
							continue;
						}
						
						duplicateCheck.add(pos);
						sum += d[pos.y][pos.x].x;
					}
					sum *= -1;
					System.out.print((sum+1)%10);
				}
			}
			System.out.println();
		}
		
	}
	
	public static void BFS(int x,int y) {
		
	}
	
	public static boolean merge(Pos a, Pos b) {
		a = find(a);
		b = find(b);
		
		// 같은 집합이라면 무시
		if(a.x == b.x && a.y == b.y) {
			return false;
		}
		
		// a집합에 b집합의 크기를 더한다.,
		d[a.y][a.x].x += d[b.y][b.x].x;
		d[a.y][a.x].y += d[b.y][b.x].y;
		//b 집합의 루트를 a로 변경한다.
		d[b.y][b.x].x = a.x;
		d[b.y][b.x].y = a.y; 
		
		return true;
	}
	
	public static Pos find(Pos p) {
		// 자신이 루트라면 리턴한다.
		if(d[p.y][p.x].x < 0) {
			return p;
		}
		return d[p.y][p.x] = find(d[p.y][p.x]); 
	}
	
	
	public static boolean canGo(int gox, int goy) {
		if(gox < 0 || gox >= M || goy < 0 || goy >= N) {
			return false;
		}
		return true;
	}
	
	public static class Pos{
		int x,y;
		public Pos(int x,int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	public static void input() throws Exception {
		st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[N][M];
		alreadyCheck = new int[N][M];
		
		for(int i=0;i<N;i++) {
			String str = in.readLine();
			for(int j=0;j<M;j++) {
				if(str.charAt(j)=='0') {
					arr[i][j] = 0;
				}
				else {
					arr[i][j] = 1;
				}
			}
		}
	}

	
}