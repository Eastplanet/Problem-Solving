import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

    static int V,E;
    static int[] vertexColors;
    static List<Integer>[] adj;
    static boolean invalidColor;

    static void paintColor(int i, int color){
        vertexColors[i] = color;

        int nextColor = color*-1;
        for(int next: adj[i]){
            if(vertexColors[next] == 0){
                paintColor(next,nextColor);
            }
            else if(vertexColors[next] == nextColor){
                continue;
            }
            else if(vertexColors[next] == color){
                invalidColor = true;
                return;
            }
        }

    }

    public static void main(String[] args) throws Exception{



        int T = Integer.parseInt(in.readLine());
        while(T-- > 0){

            invalidColor = false;

            input();

            for(int i=1;i<=V;i++){
                if(vertexColors[i] == 0){
                    paintColor(i,1);
                }
            }

            if(invalidColor == true){
                System.out.println("NO");
            }
            else{
                System.out.println("YES");
            }
        }

    }

    static void input() throws Exception{
        StringTokenizer st = new StringTokenizer(in.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        vertexColors = new int[V+1];
        adj = new ArrayList[V+1];
        for(int i=0;i<=V;i++){
            adj[i] = new ArrayList<>();
        }

        for(int i=0;i<E;i++){
            st = new StringTokenizer(in.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            adj[s].add(e);
            adj[e].add(s);
        }
    }
}