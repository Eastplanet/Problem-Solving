import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;
    public static int N;
    public static int[][] p;

    public static List<Integer>[] adj;
    public static int[] outCome, level;
    public static final int MAX_HEIGHT = 20;

    public static void main(String[] args) throws Exception {

        int T = Integer.parseInt(in.readLine());
        while(T -- > 0){
            init();

            // 높이를 기록합니다.
            markHeight();

            // p 배열을 갱신합니다.
            for(int j=1;j<MAX_HEIGHT;j++){
                for(int i=1;i<=N;i++) {
                    if(p[i][j-1] != 0){
                        p[i][j] = p[p[i][j - 1]][j - 1];
                    }
                }
            }

            // 명령어를 받아 처리합니다.

            st = new StringTokenizer(in.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            int result = findLCA(A,B);
            System.out.println(result);
        }
    }

    public static void markHeight(){

        int root = -1;
        for(int i=1;i<=N;i++){
            if(outCome[i] == 0){
                root = i;
                break;
            }
        }

        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{root, 0});
        while(!q.isEmpty()){
            int[] curr = q.poll();
            level[curr[0]] = curr[1];

            for(int next :adj[curr[0]]){
                q.add(new int[]{next, curr[1]+1});
            }
        }
    }

    public static int findLCA(int A, int B){
        if(level[A] != level[B]){
            // A가 더 깊게 위치하도록 변경
            if(level[A] < level[B]){
                int tmp = A;
                A = B;
                B = tmp;
            }

            int diff = level[A] - level[B];

            for(int i=0;diff > 0; i++){
                if(diff % 2 == 1){
                    A = p[A][i];
                }
                diff = diff >> 1;
            }
        }

        if(A == B){
            return A;
        }

        // 높이는 똑같아짐
        for(int i=MAX_HEIGHT-1;i>=0;i--){
            if(p[A][i] != 0 && p[A][i] != p[B][i]){
                A = p[A][i];
                B = p[B][i];
            }
        }

        A = p[A][0];
        return A;
    }

    public static void init() throws Exception{
        N = Integer.parseInt(in.readLine());
        p = new int[N+1][MAX_HEIGHT];

        outCome = new int[N+1];
        level = new int[N+1];

        adj = new ArrayList[N+1];
        for(int i=1;i<=N;i++){
            adj[i] = new ArrayList<>();
        }

        for(int i=0;i<N-1;i++){
            st = new StringTokenizer(in.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            adj[A].add(B);
            p[B][0] = A;
            outCome[B]++;
        }
    }

}

