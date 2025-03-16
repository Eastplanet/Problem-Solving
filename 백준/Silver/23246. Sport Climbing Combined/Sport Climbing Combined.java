import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;
    public static List<Ath> list;


    public static void main(String[] args) throws Exception{
        init();

        Collections.sort(list);

        System.out.println(list.get(0).num + " " + list.get(1).num + " " + list.get(2).num);
    }


    public static void init() throws Exception{
        int N = Integer.parseInt(in.readLine());

        list = new ArrayList<>();

        for(int i=0;i<N;i++){
            st = new StringTokenizer(in.readLine());
            int num = Integer.parseInt(st.nextToken());
            int a= Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            list.add(new Ath(num,a,b,c));
        }
    }

    public static class Ath implements Comparable<Ath>{
        int num, cross,sum;
        public Ath(int num,int a,int b,int c){
            this.num = num;
            this.cross = a*b*c;
            this.sum = a+b+c;
        }

        @Override
        public int compareTo(Ath o) {
            if(this.cross != o.cross){
                return this.cross - o.cross;
            }

            if(this.sum != o.sum){
                return this.sum - o.sum;
            }

            return this.num - o.num;
        }
    }

}