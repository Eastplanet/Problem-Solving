import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws Exception{

        int N = Integer.parseInt(in.readLine());
        st = new StringTokenizer(in.readLine());

        int maxPropit = 0;
        int minVal = Integer.MAX_VALUE;
        for(int i=0;i<N;i++){
            int today = Integer.parseInt(st.nextToken());
            if(today - minVal > maxPropit){
                maxPropit = today - minVal;
            }

            minVal = Math.min(minVal,today);
        }

        System.out.println(maxPropit);
    }



}