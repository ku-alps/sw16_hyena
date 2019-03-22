package dynamic_programming;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Prodo{

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int n;
		n = Integer.parseInt(br.readLine());
		int[][] arr= new int[2][500001];
		int[] ans = new int[n-1];
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			arr[0][i] = x; arr[1][i] = y;
		} // 입력
		int ind = n/2;
		for(int i=0;i<ind-1;i++) {
			int sum = 0;
			if(i==0) {//맨 왼
				sum = Math.abs(arr[0][0]-arr[0][2])*arr[1][1]; 
			}else if(i==ind-1-1){//맨 오
				
			}else {//중간
				
				
			}
		}
		
	}
}
