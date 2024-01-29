package ps;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class BOJ_16678 {
public static void main(String[] args) throws Exception{
	BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	
	int N = Integer.parseInt(in.readLine());
	
	Long[] arr = new Long[N];
	
	for(int i=0;i<N;i++) {
		arr[i] = Long.parseLong(in.readLine());
	}
	
	Arrays.sort(arr);
	
	long now = 1;
	long sum = 0;
	for(int i=0;i<arr.length;i++) {
		if(now > arr[i].longValue())continue;
		
		if(now == arr[i].longValue()) {
			now++;
			continue;
		}
		
		sum += (arr[i] - now);
		now++;
	}
	
	System.out.println(sum);
}
}
