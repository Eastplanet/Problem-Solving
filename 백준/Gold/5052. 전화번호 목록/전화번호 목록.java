import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static int N;
    public static String[] arr;

    public static class Trie {
        Trie[] child;
        // 여기서 끝나는 전화번호가 있나요
        boolean isOutput;
        // 자식이 있나요
        boolean goExist;
        char now;

        public Trie(){
            child = new Trie[10];
        }


        public void makeTrie(String num , int idx){

            // 끝이 아닌 경우 재귀
            if(idx + 1 < num.length()){

                if(child[num.charAt(idx+1)-'0'] != null){
                    child[num.charAt(idx+1)-'0'].makeTrie(num, idx + 1);
                }
                else{
                    Trie t = new Trie();
                    t.makeTrie(num,idx + 1);
                    child[num.charAt(idx+1)-'0'] = t;
                }

                if(idx != -1){
                    now = num.charAt(idx);
                }
                goExist = true;
            }
            // 끝인 경우
            else {
                isOutput = true;
            }
        }

        public boolean recursiveFindInvalid(){
            // 일관성 없음 !
            if(isOutput && goExist){
                return true;
            }

            if(goExist){
                boolean ans = false;
                for(Trie t : child){
                    if(t == null){
                        continue;
                    }
                    ans = ans | t.recursiveFindInvalid();
                }
                return ans;
            }

            return false;
        }


    }

    public static void main(String[] args) throws Exception{

        int T = Integer.parseInt(in.readLine());
        while(T-- > 0){
            init();

            Trie root = new Trie();
            for(int i=0;i<arr.length;i++){
                root.makeTrie(arr[i],-1);
            }

            if(root.recursiveFindInvalid()){
                System.out.println("NO");
            }
            else{
                System.out.println("YES");
            }

        }


    }

    public static void init() throws Exception{
        N = Integer.parseInt(in.readLine());
        arr = new String[N];
        for(int i=0;i<N;i++){
            arr[i] = in.readLine();
        }
    }




}