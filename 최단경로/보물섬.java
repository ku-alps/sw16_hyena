package 최단경로;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class 보물섬 {
	static class position{
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
	static int n,m,max,cnt;
	static char arr[][];
	static int visit[][];
	static int dx[] = {1,0,-1,0};
	static int dy[] = {0,-1,0,1};
	static Queue<position> q;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new char[n][m];
		for(int i=0;i<n;i++) {
			String tmp = br.readLine();
			for(int j=0;j<m;j++) {
				arr[i][j] = tmp.charAt(j);
			}
		}
		max = Integer.MIN_VALUE;
		cnt = 0; 
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				if(arr[i][j]=='L') {
					position p = new position(i,j);
					visit = new int[n][m];visit[i][j] = 0;
					q = new LinkedList<>();q.add(p);
					bfs();
				}
			}
		}
		
		bw.write(String.valueOf(max));
		bw.close();
	}
	public static void bfs() {
		while(!q.isEmpty()) { //최단경로는 무조건 bfs돌기 
			position tmp = q.poll();
			int cy = tmp.getY(); int cx = tmp.getX();
			for(int i=0;i<4;i++) {
				if(cy+dy[i]>=0 && cy+dy[i]<n && cx+dx[i]>=0 && cx+dx[i]<m) {
					if(arr[cy+dy[i]][cx+dx[i]] == 'L' && visit[cy+dy[i]][cx+dx[i]] == 0) {
						position newP = new position(cy+dy[i],cx+dx[i]);
						visit[cy+dy[i]][cx+dx[i]] = visit[cy][cx] + 1;
						max = Math.max(max, visit[cy+dy[i]][cx+dx[i]]);	//모든길이의 최단시간 갱신
						q.add(newP);
					}
				}
			}
		}
	}

}
