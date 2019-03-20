package Default;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.StringTokenizer;

public class 회장뽑기 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		int arr[][] = new int[n+1][n+1];
		while(true) {
			st = new StringTokenizer(br.readLine());
			int p1 = Integer.parseInt(st.nextToken());
			int p2 = Integer.parseInt(st.nextToken());
			if(p1==-1)
				break;
			arr[p1][p2] = 1; arr[p2][p1] = 1;
		}
		//플로이드 알고리즘
		for(int k=1;k<=n;k++) {
			for(int i=1;i<=n;i++) {
				for(int j=1;j<=n;j++) {
					if(i==j || i==k || k==j || arr[i][k]==0 || arr[k][j]==0)
						continue;	
					if(arr[i][j]==0) {
						arr[i][j] = arr[i][k]+arr[k][j]; 
						continue;
					}
					if(arr[i][j] > arr[i][k]+arr[k][j] ) {
						arr[i][j] = arr[i][k]+arr[k][j];
					}
				}
			}
		}
		//각 열중 max값 찾기
		int max[] = new int[n+1];
		for(int i=1;i<=n;i++) {
			int tmp = arr[i][1];
			for(int j=2;j<=n;j++) {
				if(tmp<arr[i][j])
					tmp = arr[i][j];
			}
			max[i] = tmp;
		}
		//max들중 min값 찾기 
		int tmp = max[1];
		for(int i=2;i<=n;i++) {
			if(tmp > max[i])
				tmp = max[i];
		}
		int cnt=0;
		for(int i=1;i<=n;i++) {
			if(max[i]==tmp) {
				max [i] = -1;
				cnt++;
			}
		}
		bw.write(String.valueOf(tmp)+" "+String.valueOf(cnt)+"\n");
		for(int i=1;i<=n;i++)
			if(max[i]==-1)
				bw.write(String.valueOf(i)+" ");
		bw.close();
	}

}
