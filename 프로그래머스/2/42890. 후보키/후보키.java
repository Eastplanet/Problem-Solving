import java.lang.*;
import java.util.*;

class Solution {
    
    int C,R;
    int[] forbidden;
    // [학생][속성]
    String[][] arr;
    
    List<int[]>[]u1Arr;
    
    int cnt;
    
    public int solution(String[][] relation) {
        init(relation);
        
        List<int[]> first = new ArrayList<>();    
        for(int i=0;i<C;i++){
            
            int[] tmp = new int[]{i};
            
            
            
            if(checkIsU1(tmp, 1)){
                cnt++;
                u1Arr[0].add(tmp);
                
                
                // System.out.print("카운트! [");
                // for(int j=0;j<tmp.length;j++){
                //     System.out.print(tmp[j] + " ,");    
                // }
                // System.out.print("]");
                
            }
            else{
                first.add(tmp);
            }
        }
        
        // System.out.println("1개 검사 끝");
        
        
        for(int i=1;i<C;i++){
            
            first = makeCombAndRetFailList(first);
            
            List<int[]> second = new ArrayList<>();
            
            for(int j=0;j<first.size();j++){
                int[] tmp = first.get(j);
                
                Arrays.sort(tmp);
                
                if(checkIsU1(tmp, tmp.length)){
                    cnt++;
                    u1Arr[tmp.length-1].add(tmp);
                    
                    // System.out.print("카운트! [");
                    // for(int k=0;k<tmp.length;k++){
                    //     System.out.print(tmp[k] + " ,");    
                    // }
                    // System.out.println("]");
                    
                }
                else{
                    second.add(tmp);
                }
            }
            first = second;
        }
        
        
        
        return cnt;
    }
    
    public List<int[]> makeCombAndRetFailList(List<int[]> candidate){
        
        List<int[]> result = new ArrayList<>();
        
        // 후보에 배열 들 붙이기
        for(int i=0;i<candidate.size();i++){
            int[] candi = candidate.get(i);
            
            // j 를 붙인다.
            for(int j=0;j<C;j++){
                
                boolean duplicate = false;
                
                // 겹치지는 않는지 체크 1 1 2 같은 경우
                for(int k=0;k<candi.length;k++){
                    if(j == candi[k]){
                        duplicate = true;
                        break;
                    }
                }
                
                if(!duplicate){
                    int[] list = new int[candi.length+1];
                    for(int ii=0;ii<candi.length;ii++){
                        list[ii] = candi[ii];
                    }
                    list[candi.length] = j;
                    result.add(list);
                }
                
            }
        }
        
        
        return result;
    }
    
    // cols Ex 1번 3번 4번 속성이 유일한가요??
    public boolean checkIsU1(int[] cols,int dept){
        
        // if(cols.length == 2 && cols[0] == 1 && cols[1] == 2){
        //     System.out.println("HERE!");
        // }
        
        
        
//         System.out.print("이 col을 검사할꺼야! [");
//         for(int j=0;j<cols.length;j++){
//             System.out.print(cols[j] + " ,");    
//         }
//         System.out.print("]");
        
        // 이전 규칙들과 문제가 되는지 체크
        // 속성 1개만 가진애들과 비교했을떄 문재가 있는지
        // 속성 2개만 가진 애들과 
        // ...
        boolean isPass = true;
        
        for(int i=1;i<=dept;i++){
            
            // System.out.println("dept : "+ i);
            
            // i가 1이면 i-1리스트에서 내 값이 있는지 체크해야함
            // 속성 i개만 가진 유일 키 리스트
            
            List<int[]> check = u1Arr[i-1];
            
            
            for(int[] item : check){
                //여기서 아이템 리스트가 cols에 있다면 안됨!
                
                //item의 첫번째~마지막 글자가 있나요??
                
//                 System.out.print("아이템 리스트!  [ ");
//                 for(int aa=0;aa<item.length;aa++){
//                     System.out.print(item[aa]);
//                 }
//                 System.out.println("] ");
                
                
                boolean allExist = true;
                
                for(int k=0;k<item.length;k++){
                    
                    boolean exist = false;
                    //item의 k 번째 글자가 cols 에 있나요?
                    for(int z=0;z<cols.length;z++){
                        if(item[k] == cols[z]){
                            
                            // 1개인거와 같으면 바로 취소
                            // if(i == 1){
                            //     return false;
                            // }
                            
                            exist = true;   
                        }
                    }
                    if(exist == false){
                        allExist = false;
                    }
                }
                
                if(allExist)return false;
                
            }
            
            
        }
            
          
        
        
        
        // 진짜 값이 유일하게 식별 되는 지 체크
        
        Set<String> set = new HashSet<>();
        
        // System.out.println();
        // System.out.println("셋검사 시작");
        
        for(int i=0;i<R;i++){
            
            StringBuilder sb = new StringBuilder();
            
            for(int j=0;j<cols.length;j++){
                sb.append(arr[i][cols[j]]);
            }
            
            // System.out.println("셋에 있는 내용" + set);
            // System.out.println("넣을 내용"+ sb.toString());
            if(set.contains(sb.toString())){
                // System.out.println("실패!");
                return false;
            }
            // System.out.println("성공!");
            set.add(sb.toString());
        }
        
        return true;
    }
    
    public void init(String[][] relation){
        arr = relation;
        R = relation.length;
        C = relation[0].length;
        
        forbidden = new int[C];
        
        u1Arr = new ArrayList[C];
        for(int i=0;i<C;i++){
            u1Arr[i] = new ArrayList<>();
        }
    }
}