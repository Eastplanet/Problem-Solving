import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(in.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        int sum = a+b+c+d;

        int min = Math.min(a,Math.min(b,c));
        min = Math.min(min,d);

        int max = Math.max(a,Math.max(b,c));
        max = Math.max(max,d);

        System.out.println(Math.abs((max+min)-(sum-(max+min))));

    }


}