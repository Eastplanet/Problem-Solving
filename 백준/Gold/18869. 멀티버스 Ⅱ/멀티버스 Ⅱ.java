import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

import static java.lang.System.in;

public class Main {

    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static int M,N;
    static List<Item>[] planet;
    static int[] visited;
    static int pairCnt = 0;

    public static void main(String[] args) throws Exception {
        input();
        posPressure();
        comb(0,0);
        System.out.println(pairCnt);

    }

    static void comb(int now, int cnt){
        if(cnt == 2){
            int a = visited[0];
            int b = visited[1];
            for(int i=0;i<N;i++){
                if(planet[a].get(i).val != planet[b].get(i).val){
                    return;
                }
            }
            pairCnt++;
        }
        else{
            for(int i=now;i<M;i++){
                visited[cnt] = i;
                comb(i+1,cnt+1);
            }
        }
    }

    static void posPressure(){

        for(int i=0;i<M;i++){
            Collections.sort(planet[i]);

            int prevVal = -1;
            int nowPos = 0;
            for(int j=0;j<N;j++){
                if(planet[i].get(j).val == prevVal){
                    planet[i].get(j).val = nowPos;
                }
                else{
                    nowPos++;
                    prevVal =  planet[i].get(j).val;
                    planet[i].get(j).val = nowPos;
                }
            }

            Collections.sort(planet[i], (o1,o2)->{
                return o1.order - o2.order;
            });
        }


    }

    static class Item implements Comparable<Item> {
        int val, order;

        public Item(int val, int order) {
            this.val = val;
            this.order = order;
        }

        @Override
        public int compareTo(Item o){
            return this.val - o.val;
        }
    }


    static void input() throws Exception{
        StringTokenizer st = new StringTokenizer(in.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        planet = new ArrayList[M];
        for(int i=0;i<M;i++)planet[i] = new ArrayList<Item>();
        
        for(int i=0;i<M;i++){
            st = new StringTokenizer(in.readLine());
            for(int j=0;j<N;j++){
                planet[i].add(new Item(Integer.parseInt(st.nextToken()),j));
            }
        }
        visited = new int[2];
    }


}