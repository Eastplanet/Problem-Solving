import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws Exception{
        st = new StringTokenizer(in.readLine());
        int[] person = new int[4];
        for(int i=0;i<4;i++){
            person[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(in.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        for(int i=0;i<4;i++){
            if( x == person[i]){
                System.out.println(i+1);
                return;
            }
        }

        System.out.println(0);


    }


}