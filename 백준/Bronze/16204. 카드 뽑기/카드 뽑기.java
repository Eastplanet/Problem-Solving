import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(in.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int frontO = m;
        int frontX = n-m;

        int backO = k;
        int backX = n-k;

        int sum = Math.min(frontO,backO);
        sum += Math.min(frontX,backX);
        System.out.println(sum);

    }


}