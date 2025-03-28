import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;
    public static int N,M;
    public static String first;
    public static List<Integer>[] adj, parents;
    public static HashMap<String, Integer> map;
    public static HashSet<String> set;
    public static String[] idxToName;
    public static int[] indgree;
    public static double[] blood;
    public static int cnt = 1;

    public static void main(String[] args) throws Exception {
        init();

        blood[map.get(first)] = 1;

        Queue<Integer> q = new ArrayDeque<>();

        for(int i=1;i<cnt;i++){
            if(indgree[i] == 0){
                q.add(i);
            }
        }


        while (!q.isEmpty()) {
            int curr = q.poll();

            for (int next : adj[curr]) {
                indgree[next]--;

                if (indgree[next] == 0) {
                    q.add(next);

                    if(parents[next].isEmpty()){
                        continue;
                    }
                    blood[next] = blood[parents[next].get(0)] + blood[parents[next].get(1)];
                    blood[next] /= 2;
                }
            }
        }

        double max = 0;
        String name = null;
        for(String str : set){
            if(!map.containsKey(str)){
                continue;
            }
            if(blood[map.get(str)] > max){
                max = blood[map.get(str)];
                name = str;
            }
        }

        System.out.println(name);
    }

    public static void init() throws Exception {
        st = new StringTokenizer(in.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new HashMap<>();

        adj = new List[201];
        parents = new List[201];

        idxToName = new String[201];
        indgree = new int[201];
        blood = new double[201];

        for(int i=1;i<201;i++){
            adj[i] = new ArrayList<>();
            parents[i] = new ArrayList<>();
        }

        first = in.readLine();

        for(int i=0;i<N;i++){
            st = new StringTokenizer(in.readLine());

            int child = nameToIdx(st.nextToken());
            int p1 = nameToIdx(st.nextToken());
            int p2 = nameToIdx(st.nextToken());

            indgree[child] = 2;
            adj[p1].add(child);
            adj[p2].add(child);

            parents[child].add(p1);
            parents[child].add(p2);
        }

        set = new HashSet<>();
        for(int i=0;i<M;i++){
            String tmp = in.readLine();
            set.add(tmp);
        }

    }

    public static int nameToIdx(String name){

        if(!map.containsKey(name)){
            map.put(name,cnt);
            idxToName[cnt] = name;
            cnt++;
        }

        return map.get(name);
    }

}