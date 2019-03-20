package Default;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class ªÁ≈¡ {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		int sum[] = new int[n+1];
		int ans[] = new int[n+1];
		for(int i=0;i<n;i++) {
			sum[i+1] = Integer.parseInt(br.readLine());
		}
		int tmp = 0, mid = n/2+1; 
		for(int i=1;i<=mid;i++) {
			if(i==mid) {
				ans[mid] = (sum[mid] + tmp)/2;
				ans[mid+1] = (sum[mid] - tmp)/2;
			}
			tmp = sum[i] - sum[n+1-i] - tmp;
		}
		for(int i=1;i<=n-mid;i++) {
			ans[mid-i] = sum[mid-i] - ans[mid-i+1];
			if(mid+i == n) {
				ans[mid+i] = sum[mid+i] - ans[1];
				continue;
			}
			if(i!=1)
				ans[mid+i] = sum[mid+i-1] - ans[mid+i-1]; 
		}
		for(int i=1;i<=n;i++)
			bw.write(String.valueOf(ans[i]+"\n"));
		bw.close();
	}

}
