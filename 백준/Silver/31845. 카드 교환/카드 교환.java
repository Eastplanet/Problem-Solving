import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;


    static int[] check;
    static List<Integer> arr;
    static int N,M;

    public static void main(String[] args) throws Exception{

        init();

        Collections.sort(arr, (o1,o2)->o2-o1);

        int sum = 0;

        for(int turn = 0; turn< M ; turn++){
            if(isEnd()){
                break;
            }

            int idx = findFirstFitIdx();
            if(idx == -1){
                break;
            }

            check[idx] = 1;
            sum += arr.get(idx);

            idx = findLastFitIdx();
            if(idx == -1){
                break;
            }

            check[idx] = 1;



        }

        System.out.println(sum);
    }

    static int findLastFitIdx(){
        for(int i=N-1;i>=0;i--){
            if(check[i] == 1) {
                continue;
            }
            return i;
        }

        return -1;
    }

    static int findFirstFitIdx(){
        for(int i=0;i<N;i++){
            if(check[i] == 1){
                continue;
            }
            if(arr.get(i) > 0){
                return i;
            }
        }

        return -1;
    }

    static boolean isEnd(){
        for(int i=0;i<N;i++){
            if(check[i] == 0){
                return false;
            }
        }

        return true;
    }

    static void init() throws Exception{
        st = new StringTokenizer(in.readLine());
        N =  Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        check = new int[N];

        st = new StringTokenizer(in.readLine());
        arr = new ArrayList<>();
        for(int i=0;i<N;i++){
            arr.add(Integer.parseInt(st.nextToken()));
        }
    }



}