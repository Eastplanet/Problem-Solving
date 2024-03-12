import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(in.readLine());
        int[] cntBranch = new int[N];    // 각 가지마다 연결된 정점의 갯수
        
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < N; i++) graph.add(new ArrayList<>());
        for (int i = 1; i < N; i++) {
            StringTokenizer st = new StringTokenizer(in.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
            graph.get(b).add(a);
            cntBranch[a]++;
            cntBranch[b]++;
        }
        
        ArrayList<Integer> remove = new ArrayList<>();
        boolean[] removeIdx = new boolean[N];
        for (int i = 0; i < N; i++) {
            if(cntBranch[i] == 1) {
                remove.add(i);            
            }
        }
        
        while(remove.size() > 2) {
            ArrayList<Integer> nextRem = new ArrayList<>();
            for (int rem : remove) {
                cntBranch[rem]--;        // 0되고
                removeIdx[rem] = true;
                for (int a : graph.get(rem)) {
                    if (removeIdx[a]) continue;
                    cntBranch[a]--;
                    if (cntBranch[a] == 1) {
                        nextRem.add(a);
                    }
                    else if (cntBranch[a] == 0) {
                        nextRem.remove(Integer.valueOf(a));
                    }
                }
            }
            remove = nextRem;
        }
        
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            if (!removeIdx[i]) {
                sb.append(i+" ");
            }
        }
        System.out.println(sb);
    }
}