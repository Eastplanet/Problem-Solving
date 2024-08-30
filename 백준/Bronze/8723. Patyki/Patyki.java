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



        if(a * a == b *b + c * c || b * b == c *c + a *a || c * c == b *b + a *a){
            System.out.println(1);
        }
        else if(a == b && b == c){
            System.out.println(2);
        }
        else{
            System.out.println(0);
        }
    }



}