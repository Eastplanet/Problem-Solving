import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;
    public static int N;
    public static List<String>[] child;
    public static List<Integer>[] adj;
    public static Converter con;
    public static int[] indegre;



    public static void main(String[] args) throws Exception {

        input();

        int cnt = 0;

        List<Integer> first = new ArrayList<>();
        Queue<Integer> q = new ArrayDeque<>();

        for(int i=0;i<N;i++){
            if(indegre[i] == 0){
                cnt++;
                q.add(i);
                first.add(i);
            }
        }

        while(!q.isEmpty()){
            int curr = q.poll();

            for(int next : adj[curr]){
                indegre[next]--;
                if(indegre[next]==0){
                    child[curr].add(con.idxToName(next));
                    q.add(next);
                }
            }
        }

        System.out.println(cnt);
        for(int idx : first){
            System.out.print(con.idxToName(idx) + " ");
        }
        System.out.println();

        for(int i=0;i<N;i++){
            System.out.print(con.idxToName(i)+" ");
            System.out.print(child[i].size()+" ");
            if(!child[i].isEmpty()){
                Collections.sort(child[i]);
                for(String name : child[i]){
                    System.out.print(name + " ");
                }
            }
            System.out.println();
        }


    }

    public static void input() throws Exception{
        N = Integer.parseInt(in.readLine());

        String[] arr = new String[N];
        st = new StringTokenizer(in.readLine());
        for(int i=0;i<N;i++){
            arr[i] = st.nextToken();
        }
        Arrays.sort(arr);
        con = new Converter(arr);

        indegre = new int[N];

        child = new List[N];
        adj = new List[N];
        for(int i=0;i<N;i++){
            child[i] = new ArrayList<>();
            adj[i] = new ArrayList<>();
        }

        int M = Integer.parseInt(in.readLine());
        for(int i=0;i<M;i++){
            st = new StringTokenizer(in.readLine());
            int c = con.nameToIdx(st.nextToken());
            int p = con.nameToIdx(st.nextToken());
            indegre[c]++;
            adj[p].add(c);
        }
    }

    public static class Converter {
        String[] idxToName;
        Map<String,Integer> nameToIdx;
        public Converter(String[] arr){
            idxToName = new String[arr.length];
            nameToIdx = new HashMap<>();

            for(int i=0;i<arr.length;i++){
                idxToName[i] = arr[i];
                nameToIdx.put(arr[i], i);
            }
        }

        public int nameToIdx(String name){
            return nameToIdx.get(name);
        }

        public String idxToName(int idx){
            return idxToName[idx];
        }
    }

}