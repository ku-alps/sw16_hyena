package floyd_warshall;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 친구 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		int arr[][] = new int[n][n];
		for(int i=0;i<n;i++) {
			String tmp = br.readLine();
			for(int j=0;j<n;j++){
				if(tmp.charAt(j)=='N')
					arr[i][j] = 0;
				else
					arr[i][j] = 1;
			}
		}
		//플로이드와샬
		int min = 0,cnt=0;
		for(int i=0;i<n;i++) {
			cnt=0;
			for(int j=0;j<n;j++) {
				if(i==j)
					continue;
				for(int k=0;k<n;k++) {
					if((arr[i][k]==1 && arr[k][j]==1) || arr[i][j]==1) {
						cnt++;
						break;
					}
				}
			}
			if(cnt > min)
				min = cnt;
		}
		bw.write(String.valueOf(min));
		bw.close();
	}

}
