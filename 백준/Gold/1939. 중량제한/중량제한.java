import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int[] p;
    static int N,M,start,end;
    static Edge[] edges;

    static int find(int a){
        if(p[a] < 0)return a;
        return p[a] = find(p[a]);
    }

    static void union(int a,int b){
        a = find(a);
        b = find(b);
        if(a==b)return;

        if(p[a]<p[b]){
            p[a] += p[b];
            p[b] = a;
        }
        else{
            p[b] += p[a];
            p[a] = b;
        }
    }

    public static void main(String[] args) throws Exception {
        input();

        int minWeight = Integer.MAX_VALUE;

        for (Edge edge : edges) {
            if (find(start) == find(end)) {
                break;
            }
            union(edge.s, edge.e);
            minWeight = edge.w;
        }

        System.out.println(minWeight);
    }

    static void input() throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        p = new int[N+1];
        for(int i=0;i<=N;i++)p[i] = -1;
        edges = new Edge[M];

        for(int i=0;i<M;i++) {
            st = new StringTokenizer(in.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            edges[i] = new Edge(s, e, w);
        }
        Arrays.sort(edges);

        st = new StringTokenizer(in.readLine());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());
    }

    static class Edge implements Comparable<Edge>{
        int s,e,w;

        public Edge(int s, int e, int w) {
            this.s = s;
            this.e = e;
            this.w = w;
        }

        @Override
        public int compareTo(Edge o) {
            return o.w - this.w;
        }
    }
}