package dynamic_programming;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;
import java.util.Vector;

public class 증가수열4 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int arr[] = new int[1000005];	//수열 A
		int ans[] = new int[1000005];	//부분수열 저장
		int dp[] = new int[1000005];
		Stack<Integer> s = new Stack();
		int n = Integer.parseInt(br.readLine());	//수열 A 크기
		st = new StringTokenizer(br.readLine());	
		for(int i=0;i<n;i++)
			arr[i] = Integer.parseInt(st.nextToken());
		int now = 0;	//부분수열 마지막 인덱스
		for(int i=0;i<n;i++) {
			if(i!=0 && ans[now-1]>=arr[i])
				ans[dp[i] = lower_bound(ans, arr[i],0,now-1)] = arr[i];	
			else {
				ans[now] = arr[i];
				dp[i] = now;
				now++;
			}
		}
		bw.write(String.valueOf(now)+"\n");
		int index = n-1;
		while(index>=0) {	//뒤에서부터 저장
			if(dp[index]==now-1) {
				s.add(arr[index]);
				now--;
			}
			index--;
		}
		while(!s.isEmpty()) {	//스택 꺼내서 출력
			bw.write(String.valueOf(s.pop())+" ");
		}
		for(int i=0;i<now;i++)
			System.out.print(ans[i]+" ");
		bw.close();
	}
	//이분탐색 (input의 index반환)
	public static int lower_bound(int[] array, int input,int l,int r) {
		while(l<r) {
			int m = (r+l)/2;
			if(array[m] < input) l = m+1;
			else r = m;
		}
		return l;
	}

}
