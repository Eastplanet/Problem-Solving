import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;
    public static int N;
    public static int[] arr, reArr, numToIdx, idxToNum, dp, prev;

    public static void main(String[] args) throws Exception {

        init();

        int maxIdx = 0;

        for(int i=0;i<N;i++){
            for(int j=0;j<i;j++){
                if(reArr[j] < reArr[i]){
                    if(dp[i] < dp[j] + 1){
                        dp[i] = dp[j] + 1;
                        prev[i] = j;

                        if(dp[maxIdx] < dp[i]){
                            maxIdx = i;
                        }
                    }
                }
            }
        }

        List<Integer> ans = new ArrayList<>();

        while(true){
            ans.add(reArr[maxIdx]);
            if(prev[maxIdx] == -1){
                break;
            }

            maxIdx = prev[maxIdx];
        }

        List<Integer> result = new ArrayList<>();
        for(int idx : ans){
            result.add(idxToNum[idx]);
        }

        Collections.sort(result);


        System.out.println(result.size());
        for(int num : result){
            System.out.print(num + " ");
        }


    }

    public static void init() throws Exception {

        N = Integer.parseInt(in.readLine());

        arr = new int[N+1];
        reArr = new int[N];

        numToIdx = new int[N+1];
        idxToNum = new int[N];

        dp = new int[N];
        prev = new int[N];

        for(int i=0;i<N;i++){
            prev[i] = -1;
        }

        st = new StringTokenizer(in.readLine());
        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(in.readLine());
        for(int i=0;i<N;i++){
            int num = Integer.parseInt(st.nextToken());
            numToIdx[num] = i;
            idxToNum[i] = num;
        }

        for(int i=0;i<N;i++){
            reArr[i] = numToIdx[arr[i]];
        }

    }

}