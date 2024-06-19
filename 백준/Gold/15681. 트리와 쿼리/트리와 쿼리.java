import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N,R,Q;
    static Node[] nodes;
    static int[] subtreeSize;
    static int[] visited;

    public static void main(String[] args) throws Exception{

        st = new StringTokenizer(in.readLine());
        N = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());

        visited = new int[N+1];
        subtreeSize = new int[N+1];
        nodes = new Node[N+1];
        for(int i=0;i<=N;i++) {
            nodes[i] = new Node(i);
        }

        for(int i=0;i<N-1;i++){
            st = new StringTokenizer(in.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            nodes[s].adj.add(nodes[e]);
            nodes[e].adj.add(nodes[s]);
        }

        visited[R] = 1;
        makeSizeArr(R);

        StringBuilder sb = new StringBuilder();
        for(int i=0;i<Q;i++){
            int num = Integer.parseInt(in.readLine());
            sb.append(subtreeSize[num]).append("\n");
        }
        System.out.println(sb);

    }

    static int makeSizeArr(int nodeNum){

        Node node = nodes[nodeNum];
        int sizeSum = 1;

        for(Node next : node.adj){
            if(visited[next.num] == 1)continue;
            visited[next.num] = 1;
            if(subtreeSize[next.num] != 0) sizeSum += subtreeSize[next.num];
            else sizeSum += makeSizeArr(next.num);
        }

        return subtreeSize[nodeNum] = sizeSum;
    }

    static class Node{
        int num;
        // 연결됨 부모 or 자식
        List<Node> adj = new ArrayList<>();
        public Node(int num) {
            this.num = num;
        }
    }


}