
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;
    public static int N, M;
    public static HashMap<String,Integer> map;
    public static List<String> idxToName, result;
    public static int[] indegree;
    public static List<Integer>[] adj;

    public static void main(String[] args) throws Exception {

        init();

        List<Integer> list = new ArrayList<>();
        for(int i=0;i<M;i++){
            if(indegree[i] == 0){
                list.add(i);
            }
        }


        while(!list.isEmpty()){
            printItemNameOrderByASC(list);
            list = topologicalSort(list);
        }

        if(result.size() == M){
            for(String ans : result){
                System.out.println(ans);
            }
        }
        else{
            System.out.println(-1);
        }

    }

    public static void printItemNameOrderByASC(List<Integer> list){

        List<String> itemNameList = new ArrayList<>();
        for(int idx : list){
            itemNameList.add(idxToName.get(idx));
        }

        Collections.sort(itemNameList);
        for(String itemName : itemNameList){
            result.add(itemName);
        }
    }

    public static List<Integer> topologicalSort(List<Integer> list){

        List<Integer> nextList = new ArrayList<>();

        for(int curr : list){

            for(int next : adj[curr]){
                indegree[next]--;
                if(indegree[next] == 0){
                    nextList.add(next);
                }
            }
        }

        return nextList;
    }



    public static void init() throws Exception{

        map = new HashMap<>();
        idxToName = new ArrayList<>();
        result = new ArrayList<>();

        indegree = new int[400_001];
        adj = new List[400_001];

        for(int i=0;i<400_001;i++){
            adj[i] = new ArrayList<>();
        }

        N = Integer.parseInt(in.readLine());
        for(int i=0;i<N;i++){
            st = new StringTokenizer(in.readLine());

            int first = getIdx(st.nextToken());
            int second = getIdx(st.nextToken());

            indegree[second]++;
            adj[first].add(second);
        }

    }

    public static int getIdx(String itemName){

        if(!map.containsKey(itemName)){
            map.put(itemName, M);
            idxToName.add(itemName);
            M++;
        }

        return map.get(itemName);
    }
}