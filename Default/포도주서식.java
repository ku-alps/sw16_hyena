package Default;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
public class 포도주서식 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		int p[] = new int[n+1];
		int dp[] = new int[n+1];
		for(int i=1;i<=n;i++) 
			p[i] = Integer.parseInt(br.readLine());
		for(int i=1;i<=n;i++) {
			if(i<=2)
				dp[i] = dp[i-1]+p[i];
			else
				dp[i] = Math.max(dp[i-3]+p[i-1]+p[i], Math.max(dp[i-2]+p[i], dp[i-1]));
		}
		bw.write(String.valueOf(dp[n]));
		bw.close();
	}
}
