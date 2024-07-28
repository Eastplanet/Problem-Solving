import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws Exception{
        int N = 6;
        st = new StringTokenizer(in.readLine());
        int sum = 0;
        for(int i=0;i<N;i++)sum += Integer.parseInt(st.nextToken())*5;
        System.out.println(sum);

    }


}