
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.lang.*;


public class Main {

	public static StringTokenizer st;
	public static int[][] board;
	public static int N,K;
	public static int[] ammoAtk;
	public static int[] shootPattern;
	public static Target[][] map;
	
	public static int maxScore = 0;

	public static void main(String[] args) throws Exception{
		
		init();
		generateShootPatternAndStartSimulate(0);
		System.out.println(maxScore);
				
	}
	
	// 어떤 위치에 총을 쏠 지 조합을 만들고 시뮬레이션을 돌린다.
	public static void generateShootPatternAndStartSimulate(int cnt) {
		
		if(cnt == K) {
		
			maxScore = Math.max(maxScore, simulate());
			return;
		}
		
		for(int i = 0 ; i < N ; i++) {
			shootPattern[cnt] = i;
			generateShootPatternAndStartSimulate(cnt+1);
		}
	}
	
	// 시뮬레이션을 시작한다
	// 1. map에 초기 상태의 표적을 생성한다.
	// 2. 정해진 순서대로 사격을 수행한다
	// 2-1. 표적 파괴시  정해진대로 처리한다.
	// 3. maxScore를 갱신한다.
	public static int simulate() {
		
		// map에 초기 상태의 표적을 생성한다.
		initBoard();
		
		int maxScoreInSimulate = 0;
		
		// 정해진 순서대로 사격을 수행한다.
		for(int i=0;i<K;i++) {
			int nowShootPos = shootPattern[i];
			
			
			// y가 nowSootPos인 부분에 총을 쏜다.
			for(int j=0;j<N;j++) {
				if(map[nowShootPos][j] == null) {
					continue;
				}
				
				// 총알의 공격력 만큼 해당 타겟을 타격한다.
				maxScoreInSimulate += map[nowShootPos][j].attackTarget(ammoAtk[i]);
				break;
			}
		}
		
		return maxScoreInSimulate;
	}
	
	public static void initBoard() {
		
		map = new Target[N][N];
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(board[i][j] == 0) {
					continue;
				}
				map[i][j] = new Target(j,i, board[i][j]);
			}
		}
	}
	
	
	// 입력 처리
	public static void init() throws Exception{
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(in.readLine());
		board = new int[N][N];
		
		K = Integer.parseInt(in.readLine());
		ammoAtk = new int[K];
		shootPattern = new int[K];
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(in.readLine());
			for(int j=0;j<N;j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		st = new StringTokenizer(in.readLine());
		for(int i=0;i<K;i++) {
			ammoAtk[i] = Integer.parseInt(st.nextToken());	
		}
	}
	
	
	public static class Target {
		
		public boolean isBonus;
		public int x,y;
		public int startHP, currentHP;
		
		public Target(int x, int y, int startHP) {
			this.x = x;
			this.y = y;;
			this.startHP = startHP;
			this.currentHP = startHP;
			
			if(startHP >= 10) {
				this.isBonus = true;
			}
			else {
				this.isBonus = false;
			}
		}
		
		// 타겟이 공격받을 때 작업을 처리합니다.
		public int attackTarget(int damage) {
			
			// 보너스인경우 항상 파괴됩니다.
			if(this.isBonus) {
				// 타겟 파괴
				map[this.y][this.x] = null;
				
				// 점수를 리턴
				return this.startHP;
			}
			
			this.currentHP -= damage;
			
			//표적이 부숴지지 않음
			if(this.currentHP > 0) {
				return 0;
			}
			
			map[this.y][this.x] = null;
			
			// 표적 파괴 시 상하좌우에 표적을 생성한다.
			generateTarget();
			
			return this.startHP;
		}
		
		public void generateTarget() {
			
			int[] dx = {0,0,1,-1};
			int[] dy = {1,-1,0,0};
			
			for(int i=0;i<4;i++) {
				int gox = this.x + dx[i];
				int goy = this.y + dy[i];
				
				if(gox < 0 || gox >= N || goy < 0 || goy >= N) {
					continue;
				}
				if(map[goy][gox] != null) {
					continue;
				}
				
				if(this.startHP/4 == 0) {
					continue;
				}
				map[goy][gox] = new Target(gox, goy, this.startHP/4);
			}
		}
	}
	
	
	
}