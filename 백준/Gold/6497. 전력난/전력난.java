import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int m,n;
    static int totalLength;

    static Edge[] edges;
    static int[] p;

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

        while(true){
            st = new StringTokenizer(in.readLine());
            m = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());
            if(m == 0 && n == 0)break;
            input();

            Arrays.sort(edges);

            int roadCnt = 0;
            int weight = 0;

            for(int i=0;i<edges.length;i++){

                if (roadCnt == m-1)break;
                Edge edge = edges[i];
                if(find(edge.s) != find(edge.e)){
                    union(edge.s,edge.e);
                    roadCnt++;
                    weight += edge.w;
                }
            }

            System.out.println(totalLength - weight);

        }


    }

    static void input() throws Exception{

        totalLength = 0;
        edges = new Edge[n];
        p = new int[m];
        for(int i=0;i<m;i++)p[i] = -1;
        for(int i=0;i<n;i++){
            st = new StringTokenizer(in.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            totalLength += w;
            Edge edge = new Edge(s,e,w);
            edges[i] = edge;
        }
    }

    static class Edge implements Comparable<Edge>{
        int s,e,w;

        @Override
        public int compareTo(Edge o) {
            return this.w- o.w;
        }

        public Edge(int s, int e, int w) {
            this.s = s;
            this.e = e;
            this.w = w;
        }
    }


}