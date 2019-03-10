import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 내리막길 {
	static int visit[][] = new int[501][501];
	static int height[][] = new int[501][501];
	static int m,n;
	static int dx[] = {0, 1, 0, -1};
	static int dy[] = {1, 0, -1, 0};
	static int dfs(int x, int y) {
		if(x==n && y==m)
			return 1;
		if(visit[y][x]!=-1) return visit[y][x];
		visit[y][x] = 0;
		for(int i=0;i<4;i++) {
			int nx = x+dx[i]; 
			int ny = y+dy[i];
			if(nx>=0 && nx<n && ny>=0 && ny<m) 
				if(height[ny][nx] < height[y][x]) 
					visit[y][x] += dfs(nx,ny);					
		}
		return visit[y][x];
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		for(int i=0;i<m;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<n;j++) {
				height[i][j] = Integer.parseInt(st.nextToken());
				visit[i][j] = -1;
			}
		}
		visit[m-1][n-1] = 1;
		dfs(0,0);
		bw.write(String.valueOf(visit[0][0]));
		bw.close();
	} 

}
