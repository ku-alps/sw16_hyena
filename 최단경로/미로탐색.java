package 최단경로;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class position{
	int y;
	int x;
	public position(int y, int x) {
		super();
		this.y = y;
		this.x = x;
	}
	public int getY() {
		return this.y;
	}
	public int getX() {
		return this.x;
	}
}
public class 미로탐색 {
	public static int n,m;
	public static int[] dx = {0,1,0,-1};
	public static int[] dy = {1,0,-1,0};
	public static int[][] visit;
	public static int[][] arr;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[n][m];
		visit = new int[n][m];
		for(int i=0;i<n;i++) {
			String tmp = br.readLine();
			for(int j=0;j<m;j++) {
				arr[i][j] = tmp.charAt(j) - '0';
			}
		}
		Queue<position> q = new LinkedList<>();
		position p = new position(0,0);
		q.add(p);
		visit[0][0] = 1;
		while(!q.isEmpty()) { //최단경로는 무조건 bfs돌기 
			position tmp = q.poll();
			int cy = tmp.getY(); int cx = tmp.getX();
			for(int i=0;i<4;i++) {
				if(cy+dy[i]>=0 && cy+dy[i]<n && cx+dx[i]>=0 && cx+dx[i]<m) {
					if(arr[cy+dy[i]][cx+dx[i]] == 1 && visit[cy+dy[i]][cx+dx[i]] == 0) {
						position newP = new position(cy+dy[i],cx+dx[i]);
						visit[cy+dy[i]][cx+dx[i]] = visit[cy][cx] + 1;
						q.add(newP);
					}
				}
			}
		}
		bw.write(String.valueOf(visit[n-1][m-1]));
		bw.close();
	}

}
