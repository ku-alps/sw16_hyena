package dynamic_programming;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 퇴사 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
				BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
				StringTokenizer st;
				int n = Integer.parseInt(br.readLine());
				int dp[] = new int[n+1];//n일까지 수익
				int t[] = new int[n+1];
				int p[] = new int[n+1];
				for(int i=1;i<=n;i++) {
					st = new StringTokenizer(br.readLine());
					int ti = Integer.parseInt(st.nextToken());
					int pi = Integer.parseInt(st.nextToken());
					t[i] = ti; p[i] = dp[i] = pi;
				}
				for(int i=2;i<=n;i++) {
					for(int j=1;j<=n;j++) {
						if(i-j>=t[j])
							//i=기준일 //j=(1~i-1)일
							//dp[5] = max(상담했을때, 상담안했을때)
							dp[i] = Math.max(p[i]+dp[j], dp[i]);
					}
				}
				int max = 0;
				for(int i=1;i<=n;i++) {
					if(i+t[i]-1<=n && max<dp[i])
						max = dp[i];
				}
				bw.write(String.valueOf(max));
				bw.close();
			}

		}