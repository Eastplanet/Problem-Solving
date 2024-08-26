import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N;
    static int[][] arr;

    public static void main(String[] args) throws Exception {
        N = Integer.parseInt(in.readLine());

        arr = new int[26][26];

        for(int i=0;i<N;i++){
            st = new StringTokenizer(in.readLine());
            char a = st.nextToken().charAt(0);
            String tmp = st.nextToken();
            char b = st.nextToken().charAt(0);

            arr[charToInt(a)][charToInt(b)] = 1;
        }

        for(int k=0;k<26;k++){
            for(int i=0;i<26;i++){
                for(int j=0;j<26;j++){
                    if(arr[i][k] == 0 || arr[k][j] == 0)continue;
                    arr[i][j] = 1;
                }
            }
        }

        N = Integer.parseInt(in.readLine());
        for(int i=0;i<N;i++){
            st = new StringTokenizer(in.readLine());
            char a = st.nextToken().charAt(0);
            String tmp = st.nextToken();
            char b = st.nextToken().charAt(0);

            if(arr[charToInt(a)][charToInt(b)] == 1){
                System.out.println("T");
            }
            else{
                System.out.println("F");
            }
        }


    }

    static int charToInt(char c) {
        return c - 'a';
    }

    static char intToChar(int i) {
        return (char) (i + 'a');
    }


}