package dynamic_programming;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 내리막길 {
	static int n,m;
	static int visit[][],arr[][];
	static int dx[] = {0,1,0,-1};
	static int dy[] = {1,0,-1,0};
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[n][m];
		visit = new int[n][m];
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<m;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				visit[i][j] = -1;	//0으로 하면 시간초과 난다(0으로 방문체크 할꺼라서)
			}
		}
		visit[n-1][m-1] = 1;
		dfs(0,0);
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				System.out.print(visit[i][j]+" ");
			}System.out.println();
		}
		System.out.println(visit[0][0]);
	}
	public static int dfs(int y, int x) {
		if(visit[y][x]!=-1) return visit[y][x];
		visit[y][x] = 0;	//방문 체크
		for(int i=0;i<4;i++) {
			int ny = y+dy[i]; int nx = x+dx[i];
			if(ny>=0 && ny<n && nx>=0 && nx<m) {
				if(arr[y][x] > arr[ny][nx]) {
					visit[y][x]+=dfs(ny,nx);
				}
			}
		}
		return visit[y][x];
	}
}
