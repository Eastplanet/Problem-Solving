import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;
    public static int N,M;
    public static List<Edge>[] adj;
    public static int[] levels;
    public static int[][] p;
    public static int[][] dist;
    public static final int MAX_HEIGHT = 20;

    public static void main(String[] args) throws Exception {

        init();

        markLevels();

        for(int k=1;k<MAX_HEIGHT;k++){
            for(int j=2;j<=N;j++){
                if(p[j][k-1] != 0){
                    p[j][k] = p[p[j][k-1]][k-1];
                    dist[j][k] = dist[j][k-1] + dist[p[j][k-1]][k-1];
                }
            }
        }

        M = Integer.parseInt(in.readLine());
        for(int i=0;i<M;i++){
            st = new StringTokenizer(in.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            // a와 b의 공통 조상까지의 거리를 구한다.
            long dist = LCA(a,b);
            System.out.println(dist);
        }
    }

    public static long LCA(int a,int b){

        long sum = 0;

        if(levels[a] != levels[b]){

            if(levels[a] < levels[b]){
                int tmp = a;
                a = b;
                b = tmp;
            }

            int diff = levels[a] - levels[b];
            for(int i=0; diff > 0; i++){
                if(diff % 2 == 1){
                    sum += dist[a][i];
                    a = p[a][i];

                }
                diff = diff >> 1;
            }
        }

        if(a != b){
            for(int i=MAX_HEIGHT-1;i>=0;i--){
                if(p[a][i] != 0 && p[a][i] != p[b][i]){
                    sum += dist[a][i];
                    sum += dist[b][i];
                    a = p[a][i];
                    b = p[b][i];
                }
            }

            sum += dist[a][0];
            sum += dist[b][0];
        }

        return sum;
    }

    public static void markLevels(){

        int[] visited = new int[N+1];
        Queue<Node> q = new ArrayDeque<>();

        q.add(new Node(1,0));
        visited[1] = 1;

        while(!q.isEmpty()){

            Node curr = q.poll();
            levels[curr.num] = curr.level;

            for(Edge edge : adj[curr.num]){
                int next = edge.end;
                if(visited[next] == 1){
                    continue;
                }

                q.add(new Node(next,curr.level+1));
                visited[next] = 1;
                p[next][0] = curr.num;
                dist[next][0] = edge.dist;
            }
        }

    }

    public static void init() throws Exception {

        N = Integer.parseInt(in.readLine());

        // 트리의 높이는 최대 2^16을 넘어설 수 없다.
        p = new int[N+1][MAX_HEIGHT];
        dist = new int[N+1][MAX_HEIGHT];
        levels = new int[N+1];
        adj = new ArrayList[N+1];
        for(int i=0;i<=N;i++){
            adj[i] = new ArrayList<>();
        }

        for(int i=0;i<N-1;i++){
            st = new StringTokenizer(in.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            adj[s].add(new Edge(e,w));
            adj[e].add(new Edge(s,w));
        }
    }

    public static class Node {
        int num, level;
        public Node(int num, int level){
            this.num = num;
            this.level = level;
        }
    }

    public static class Edge {
        int end, dist;

        public Edge(int end, int dist) {
            this.end = end;
            this.dist = dist;
        }
    }
}