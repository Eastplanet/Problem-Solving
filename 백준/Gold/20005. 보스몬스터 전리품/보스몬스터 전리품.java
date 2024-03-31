import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int R, C, P;
	static char[][] map;
	static int[] dx = { 0, 0, 1, -1 };
	static int[] dy = { 1, -1, 0, 0 };
	static boolean[][] visited;
	
	static Pos bossPos;
	static int bossHP, totalDps, playerCnt;
	static Map<Character, Integer> nameToDps;
	static int nowSec;
	static boolean alreadyAtk;

	

	static class Node {
		int second;
		Pos pos;
		public Node(int second, Pos pos) {
			this.pos = pos;
			this.second = second;
		}
	}

	static class Pos {
		int x, y;

		public Pos(int y, int x) {
			super();
			this.x = x;
			this.y = y;
		}

	}

	static boolean canGo(int x, int y) {
		if (x < 0 || x >= C)return false;
		if (y < 0 || y >= R)return false;
		if (map[y][x] == 'X')return false;
		if(visited[y][x])return false;
		return true;
	}

	public static void main(String[] args) throws Exception{
		init();
		
		Queue<Node> q = new ArrayDeque<>();
		q.add(new Node(0, bossPos));
		visited[bossPos.y][bossPos.x] =true;
		
		//플레이어를 찾아 다님
		while(!q.isEmpty() && playerCnt != P) {
			Node cur = q.poll();
			
			// 초가 지났을 때 체력 업데이트
			// 큐에는 초가 증가순으로 쌓여 있음
			// 0초에서 1초로 된다면 이후는 다 1초 이상임
			if(cur.second != nowSec) {
				nowSec = cur.second;
				bossHP -= totalDps;
				if(bossHP <= 0) {
					System.out.println(playerCnt);
					return;
				}
			}
			
			for(int i=0;i<4;i++) {
				int gox = cur.pos.x + dx[i];
				int goy = cur.pos.y + dy[i];
				if(!canGo(gox,goy)) continue;
				
				//플레이어 발견( DPS에 추가 해준다.)
				if(map[goy][gox] != '.') {
					int dps = nameToDps.get(map[goy][gox]);
					visited[goy][gox] = true;
					q.add(new Node(cur.second+1 , new Pos(goy,gox)));
					totalDps += dps;
					playerCnt ++;
				}
				//빈칸
				else {
					visited[goy][gox] = true;
					q.add(new Node(cur.second+1 , new Pos(goy,gox)));
				}
			}
		}
		
		// 탐색이 끝나거나 플레이어를 다 찾은 경우
		// 다찾으면 더이상 BFS하지 않고 DPS로 보스를 공격
		System.out.println(playerCnt);
		
		
	}

	static void init() throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		P = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		visited = new boolean[R][C];
		for (int i = 0; i < R; i++) {
			String tmp = in.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = tmp.charAt(j);
				if (tmp.charAt(j) == 'B') {
					map[i][j] = '.';
					bossPos = new Pos(i, j);
				}
			}
		}
		nameToDps = new HashMap<>();
		for (int i = 0; i < P; i++) {
			st = new StringTokenizer(in.readLine());
			char name = st.nextToken().charAt(0);
			int dps = Integer.parseInt(st.nextToken());
			nameToDps.put(name, dps);
		}
		bossHP = Integer.parseInt(in.readLine());
	}
}