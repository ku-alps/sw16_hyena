package Default;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class 단지번호붙이기 {

	static int n;
	static int visit[][];
	static int arr[][];
	static int cnt;
	static int dx[] = {1,0,-1,0};
	static int dy[] = {0,1,0,-1};
	static LinkedList<Integer> q;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		n = Integer.parseInt(br.readLine());
		arr = new int[n][n];
		visit = new int[n][n];
		cnt = 0;
		q = new LinkedList<Integer>();
		for(int i=0;i<n;i++) {
			String tmp = br.readLine();
			for(int j=0;j<n;j++) {
				arr[i][j] = tmp.charAt(j)-'0';
			}
		}
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				if(visit[i][j] == 0 && arr[i][j]==1) {
					cnt++;
					q.add(dfs(i,j,1));
				}
			}
		}
		bw.write(String.valueOf(cnt)+"\n");
		Collections.sort(q);
		while(!q.isEmpty())
			bw.write(q.poll()+"\n");
		bw.close();
	}
	private static int dfs(int cy, int cx, int num) {
		// TODO Auto-generated method stub
		visit[cy][cx] = 1;
		for(int i=0;i<4;i++) {
			if(cy+dy[i]>=0 && cy+dy[i]<n && cx+dx[i]>=0 && cx+dx[i]<n) {
				if(arr[cy+dy[i]][cx+dx[i]] == 1 && visit[cy+dy[i]][cx+dx[i]] == 0) {
					num = dfs(cy+dy[i],cx+dx[i], num+1);
				}
			}
		}
		return num;
	}
}
