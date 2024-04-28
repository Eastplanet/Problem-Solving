class Solution {
    public int[] solution(int[] sequence, int k) {
    
        // a~ b 까지 더해서 k 인 부분 수열을 구하라?
        // 길이가 짧은 수열 -> 뒤에 원소를 우선으로 넣기
        // 여러개인 경우 앞쪽에 나오는 수열 -> 정답을 찾아도 앞으로 더 찾아나가기
        
        // 맨 뒤의 원소부터 순차탐색
        // 앞의 원소는 binary search 로 검색
        // N log N  
        
        int L = sequence.length;
        
        int[] arr = new int[L];
        
        for(int i=0;i<L;i++){
            if(i==0){
                arr[i] = sequence[i];
            }
            else{
                arr[i] = arr[i-1]+ sequence[i];
            }
        }
        
        int minLeng = 100000000;
        int start = -1;
        int end = -1;
        
        for(int i=L-1;i>=0;i--){
            // 뒤의 원소 i
            // 앞의 원소를 찾아야 함
            // 0 ~ i 범위에서 앞의 원소 찾아야 하고
            // 앞의 원소 ~ 뒤의 원소를 더한 값이 k 여야 한다.
            int front = BS(0, i, k,arr,sequence);
            if(front != -1){
                if(minLeng >= i-front+1){
                    minLeng = i-front+1;
                    start  = front;
                    end = i;
                }
            }
        }
        
        
        
        
        int[] answer = {start,end};
        return answer;
    }
    
    
    public int BS(int start,int end,int k,int []arr ,int[] sequence){
        int saveEnd = end;
        
        
        while(start <= end){
            int mid = (start + end) / 2;
            
            if(calc(mid,saveEnd,arr,sequence) > k){
                start = mid + 1;
            }
            else if(calc(mid,saveEnd,arr,sequence) < k){
                end = mid - 1;
            }
            else{
                return mid;
            }
        }
        
        
        return -1;
        
    }

    public int calc(int a,int b, int[] arr, int[] sequence){
        if(a==b){
            return sequence[a];
        }
        if(a==0){
            return arr[b];
        }
        else{
            return arr[b] - arr[a-1];
        }
    }
}