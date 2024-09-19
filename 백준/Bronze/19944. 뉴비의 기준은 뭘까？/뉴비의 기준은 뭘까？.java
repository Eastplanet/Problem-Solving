import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;


    public static void main(String[] args) throws Exception{

        st = new StringTokenizer(in.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        if(M == 1 || M == 2){
            System.out.println("NEWBIE!");
        }
        else if(M <= N){
            System.out.println("OLDBIE!");
        }
        else{
            System.out.println("TLE!");
        }
    }


}