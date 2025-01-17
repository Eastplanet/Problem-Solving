import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	public static StringTokenizer st;
	public static final int N = 8;
	public static char[][] board;
	public static int[][][] visited;
	public static Queue<King> Q;
	public static Pawn P;
	public static int nowTurn;

	public static void main(String[] args) throws Exception {

		int T = Integer.parseInt(in.readLine());

		while (T-- > 0) {
			init();
			
			boolean endFlag = false;
			boolean isWhite = false;
			
			nowTurn = 0;
			
			while(!Q.isEmpty() && !endFlag) {
				
				
				while(!Q.isEmpty() && Q.peek().turn == nowTurn) {
					// 1. 킹을 움직인다.
					King curr = Q.poll();
					List<Pos> poses = curr.possibleMovePos(P.pos);
					
					
					// 폰이랑 겹치는 위치가 있다면 잡을 수 있음 , 폰의 바로 아래에 위치할 수 있다면 잡을 수 있음
					for(Pos pos : poses) {
						if( (pos.x == P.pos.x && pos.y == P.pos.y) || (pos.x == P.pos.x && pos.y == P.pos.y + 1)) {
							isWhite = true;
							endFlag = true;
							break;
						}
					}
				} 
				nowTurn++;
				
				if(endFlag) {
					break;
				}
				
				if(Q.isEmpty()) {
					endFlag = true;
					isWhite = false;
					break;
				}
				
				// 2. 폰을 움직인다.
				// 움직일 수 있으면 다음 턴으로
				if(P.move()) {
					continue;
				}
				
				
				
				// 움직일 수 없으면 누가 이긴지 체크
				if(P.pos.y == N-1) {
					
//					if(P.alreadyArive == false) {
//						P.alreadyArive = true;
//						continue;
//					}
					
					endFlag = true;
					isWhite = false;
					break;
				}
				else {
					endFlag = true;
					isWhite = true;
					break;
				}
				
				
			}
			
			if(isWhite) {
				System.out.println("White");
			}
			else {
				System.out.println("Black");
			}
			
		}

	}

	public static void init() throws Exception {

		board = new char[N][N];
		visited = new int[8][N][N];
		Q = new ArrayDeque<>();
		
		for (int i = 0; i < N; i++) {
			String tmp = in.readLine();
			for (int j = 0; j < N; j++) {
				board[i][j] = tmp.charAt(j);
			}
		}

		st = new StringTokenizer(in.readLine());
		Pos kingPos = new Pos(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		kingPos.y = N - kingPos.y;
		kingPos.x--;
		
		King king = new King(0,kingPos);
		
//		visited[0][kingPos.y][kingPos.x] = 1;
		
		Q.add(king);
		
		st = new StringTokenizer(in.readLine());
		Pos pawnPos = new Pos(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		pawnPos.y = N - pawnPos.y;
		pawnPos.x--;
		P = new Pawn(pawnPos);
	}

	public static class Pawn {
		public Pos pos;
		public boolean alreadyArive = false;

		public Pawn(Pos pos) {
			this.pos = pos;
		}

		public boolean move() {

			int gox = this.pos.x;
			int goy = this.pos.y + 1;

			if (gox < 0 || gox >= N || goy < 0 || goy >= N || board[goy][gox] == 'F') {
				return false;
			}

			this.pos.y = goy;
			return true;
		}
	}

	public static class King {
		public static int[] dx = { -1, 0, 1, 1, 1, 0, -1, -1 };
		public static int[] dy = { -1, -1, -1, 0, 1, 1, 1, 0 };
		public int turn;
		public Pos pos;

		public King(int turn, Pos pos) {
			this.turn = turn;
			this.pos = pos;
		}

		// 갈 수 있는 위치 리스트를 응답한다.
		// 폰과 위치가 겹친다면 잡을 수 있음
		public List<Pos> possibleMovePos(Pos pawnPos) {
			List<Pos> list = new ArrayList<>();

			for (int i = 0; i < 8; i++) {
				int gox = this.pos.x + dx[i];
				int goy = this.pos.y + dy[i];

				if (gox < 0 || gox >= N || goy < 0 || goy >= N || visited[this.turn][goy][gox] == 1) {
					continue;
				}
				if(board[goy][gox] == 'D' || board[goy][gox] == 'F' || (pawnPos.y == goy - 1 && (pawnPos.x == gox - 1 || pawnPos.x == gox + 1))){
					continue;
				}
				
//				visited[this.turn][goy][gox] = 1;
				
				Pos pos = new Pos(gox,goy);
				King king = new King(this.turn+1, pos);
				list.add(pos);
				Q.add(king);
			}

			return list;
		}

	}

	public static class Pos {
		int x, y;

		public Pos(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

}