package dynamic_programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class RGBdistance {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = 0;
		n = Integer.parseInt(in.readLine());
		int[][] arr = new int[n][3];
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(in.readLine());
			for(int j=0;j<3;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}// ют╥б 
		for(int i=1;i<n;i++) { 
			arr[i][0] += Math.min(arr[i-1][1],arr[i-1][2]);
			arr[i][1] += Math.min(arr[i-1][0],arr[i-1][2]);
			arr[i][2] += Math.min(arr[i-1][0],arr[i-1][1]);
		}
		System.out.println(Math.min(Math.min(arr[n-1][0], arr[n-1][1]), arr[n-1][2]));
		
	}

}
