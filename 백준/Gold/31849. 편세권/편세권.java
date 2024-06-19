import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    /*
    월세가 방마다 있으니 방에서 가장 가까운편의점으로 BFS를 진행한다.
    격자에 놓는 방법 vs 거리를 간선으로하여 새로 그래프를 그리는 방법이 존재하지만
    격자에 놓는 방법이 유리한거 같음 (BFS라서?, 모든 노드가 쓰이지 않을 거 같음, 격자가 아주 크면 변환이 더 좋을 듯)
     */

    static int N,M,R,C;
    static List<Conv> conv = new ArrayList<>();
    static int[][] roomMap,visited;
    static int minScore = Integer.MAX_VALUE;

    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};

    public static void main(String[] args) throws Exception {
        input();
        BFS();
        System.out.println(minScore);
    }

    static void BFS(){

        Queue<int[]> Q = new ArrayDeque<>();
        for(Conv c : conv){
            Q.add(new int[]{c.a,c.b,0});
            visited[c.a][c.b] = 1;
        }

        while(!Q.isEmpty()){
            int [] curr = Q.poll();
            if(roomMap[curr[0]][curr[1]] != 0){
                int val = curr[2]*roomMap[curr[0]][curr[1]];
                minScore = Math.min(minScore,val);
            }

            for (int i=0;i<4;i++){
                int goy = curr[0] + dy[i];
                int gox = curr[1] + dx[i];
                if(goy <= 0 || goy > N || gox <= 0 || gox > M)continue;
                if(visited[goy][gox] == 1)continue;

                visited[goy][gox] = 1;
                Q.add(new int[]{goy,gox,curr[2]+1});
            }
        }
    }

    public static void input() throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        roomMap = new int[N+1][M+1];
        visited = new int[N+1][M+1];

        for(int i=0;i<R;i++){
            st = new StringTokenizer(in.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());
            roomMap[a][b] = p;
        }

        for(int i=0;i<C;i++){
            st = new StringTokenizer(in.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            conv.add(new Conv(a,b));
        }
    }

    static class Conv{
        int a,b;
        public Conv(int a, int b) {
            this.a = a;
            this.b = b;
        }
    }
}