package floyd_warshall;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class ±√±›«—πŒ»£ {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		int arr[][] = new int[n][n];
		int chk[][] = new int[n][n];
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<n;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int ans=0;
		for (int k = 0; k < n; k++){//k-∞Ê¿Ø
			for (int i = 0; i < n; i++){//i-√‚πﬂ
				for (int j = 0; j < n; j++){//j-µµ¬¯
					if (i <= j || k == i || k == j)
						continue;
					if (arr[i][k] + arr[k][j] == arr[i][j])
						chk[i][j] = 1;
					else if (arr[i][k] + arr[k][j] < arr[i][j]){
						System.out.println("-1");
						return;
					}
				}
			}
			
		}
		for (int i = 0; i < n; i++){
			for (int j = 0; j < n; j++){
				if (i <= j)
					continue;
				if (chk[i][j] != 1)
					ans += arr[i][j];
			}
		}
		System.out.println(ans);
		return ;
	}

}
