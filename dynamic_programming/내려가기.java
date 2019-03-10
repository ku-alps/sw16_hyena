package dynamic_programming;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 내려가기 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		int arr[][] = new int[n+1][3];
		int arr2[][] = new int[n+1][3];
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<3;j++)
				arr[i][j] = arr2[i][j] = Integer.parseInt(st.nextToken());
		}
		for(int i=0;i<n;i++) {
			for(int j=0;j<3;j++) {
				if(j==1) {
					arr[i+1][j] += Math.max(arr[i][0], Math.max(arr[i][1], arr[i][2]));
					arr2[i+1][j] += Math.min(arr2[i][0], Math.min(arr2[i][1], arr2[i][2]));
				}
				else {
					arr[i+1][j] += Math.max(arr[i][j], arr[i][1]);
					arr2[i+1][j] += Math.min(arr2[i][j], arr2[i][1]);
				}
			}
		}
			
		bw.write(String.valueOf(Math.max(arr[n][0], Math.max(arr[n][1], arr[n][2]))+" "+
				Math.min(arr2[n][0], Math.min(arr2[n][1], arr2[n][2]))));
		bw.close();
	}

}
