package 재귀완탐;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 스타트와링크 {
	static int n;
	static int arr[][];
	static boolean comb[];
	static int min = 987654321;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		n = Integer.parseInt(br.readLine());
		arr = new int[n+1][n+1];
		comb = new boolean[n+1];
		for(int i=1;i<=n;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1;j<=n;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		dfs(0,0);
		System.out.println(String.valueOf(min));
	}
	public static void dfs(int num,int count) {
		if(count==(n/2)) {
			ArrayList<Integer> start = new ArrayList<Integer>();
			ArrayList<Integer> link = new ArrayList<Integer>();
			for(int i=1;i<=n;i++) {
				if(comb[i]==true)
					start.add(i);
				else link.add(i);
			}
			//차이 계산
			int sum_start=0,sum_link=0;
			for(int i=0;i<(n/2);i++) {
				for(int j=i+1;j<(n/2);j++) {
					sum_start += arr[start.get(i)][start.get(j)]
							+ arr[start.get(j)][start.get(i)];
					sum_link += arr[link.get(i)][link.get(j)]
							+ arr[link.get(j)][link.get(i)];
				}
			}
			min = Math.min(min, Math.abs(sum_start-sum_link));
		}
		//완탐 시작
		for(int i=num+1;i<=n;i++) {
			if(comb[i]==false) {
				comb[i] = true;
				dfs(i,count+1);
				comb[i] = false;
			}
		}
	}
}
