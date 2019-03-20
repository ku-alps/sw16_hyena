package Default;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 경로찾기 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		int arr[][] = new int[n+1][n+1];
		for(int i=1;i<=n;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1;j<=n;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}//입력
		Queue<Integer> q = new LinkedList<Integer>();
		for(int i=1;i<=n;i++) {
			q.add(i);
			while(!q.isEmpty()) {
				int front = q.poll();
				for(int j=1;j<=n;j++) {
					if(arr[i][j]==2) //이미 방문했던곳이면
						continue;
					if(arr[front][j]==1 || arr[front][j]==2) {
						q.add(j);
						arr[i][j] = 2;
					}
				}
			}
		}
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=n;j++) {
				if(arr[i][j]==2)
					arr[i][j]=1;
				bw.write(String.valueOf(arr[i][j]+" "));
			}bw.write('\n');
		}
		bw.close();
	}

}
