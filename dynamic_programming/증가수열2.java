package dynamic_programming;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 증가수열2 {	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
			StringTokenizer st;
			int arr[] = new int[1000005];
			int ans[] = new int[1000005];
			int n = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			for(int i=0;i<n;i++)
				arr[i] = Integer.parseInt(st.nextToken());
			int now = 0;
			for(int i=0;i<n;i++) {
				if(i!=0 && ans[now-1]>=arr[i])
					ans[lower_bound(ans, arr[i],0,now-1)] = arr[i];
				else {
					ans[now] = arr[i];
					now++;
				}
			}
			bw.write(String.valueOf(now));
			bw.close();
	}
	public static int lower_bound(int[] array, int input,int l,int r) {
		while(l<r) {
			int m = (r+l)/2;
			if(array[m] < input) l = m+1;
			else r = m;
		}
		return l;
	}
}