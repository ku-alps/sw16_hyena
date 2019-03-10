import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 다리놓기 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for(int t=0;t<T;t++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int dp[][] = new int[n+1][m+1];
			for(int i=1 ;i<=m;i++) dp[1][i] = i;
			for(int i=2;i<=n;i++) {
				for(int j=i;j<=m;j++) {
					for(int k=j;k>=i;k--)
						dp[i][j] += dp[i-1][k-1];
				}
			}
			bw.write(String.valueOf(dp[n][m])+'\n');
		}
		bw.close();
	}

}
