import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {
        int N = Integer.parseInt(in.readLine());

        List<Integer> A = new ArrayList<>();
        List<Integer> B = new ArrayList<>();
        List<Integer> C = new ArrayList<>();

        Queue<int[]> Q = new ArrayDeque<>();

        for(int i=0;i<N;i++){
            StringTokenizer st = new StringTokenizer(in.readLine());
            int cmd = Integer.parseInt(st.nextToken());
            if(cmd == 1){
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                Q.add(new int[]{a,b});
            }
            else{
                int b = Integer.parseInt(st.nextToken());
                int[] front = Q.poll();
                if(front[1] == b){
                    A.add(front[0]);
                }
                else{
                    B.add(front[0]);
                }
            }
        }

        while(!Q.isEmpty()){
            C.add(Q.poll()[0]);
        }

        StringBuilder sb = new StringBuilder();

        if(A.size()==0) sb.append("None");
        Collections.sort(A);
        for(int i=0;i<A.size();i++){
            sb.append(A.get(i)+" ");
        }
        sb.append("\n");


        if(B.size()==0) sb.append("None");
        Collections.sort(B);
        for(int i=0;i<B.size();i++){
            sb.append(B.get(i)+" ");
        }
        sb.append("\n");

        if(C.size() == 0) sb.append("None");
        Collections.sort(C);
        for(int i=0;i<C.size();i++){
            sb.append(C.get(i)+" ");
        }
        sb.append("\n");

        System.out.println(sb);
    }
}