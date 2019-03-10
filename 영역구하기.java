import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.StringTokenizer;
import java.util.Vector;

public class 영역구하기 {
	static boolean visit[][] ;
	static int arr[][];
	static Vector<Integer> v = new Vector<Integer>();
	static int cnt,m,n,k;
	static int[] dx = {0,1,0,-1};
	static int[] dy = {1,0,-1,0};
	public static void dfs(int x,int y) {
		visit[x][y] = true; //방문체크
		for(int i=0;i<4;i++) {
			if(x+dx[i]>=0&&x+dx[i]<m&&y+dy[i]>=0&&y+dy[i]<n) { //배열 범위 벗어나지 않게 
				if(arr[x+dx[i]][y+dy[i]]==0&&visit[x+dx[i]][y+dy[i]]==false) { //방문안한곳, 0인곳 방문하기
					dfs(x+dx[i],y+dy[i]);
					cnt++;
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
	
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		arr = new int[m][n];
		visit = new boolean[m][n];
		for(int i=0;i<k;i++) {
			st = new StringTokenizer(br.readLine());
			int y1 = Integer.parseInt(st.nextToken());
			int x1 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken())-1;
			int x2 = Integer.parseInt(st.nextToken())-1;
			for(int j=x1;j<=x2;j++) {
				for(int p=y1;p<=y2;p++) {
					arr[j][p] = 1;
				}
			}
		}
		//dfs돌기
		for(int i=0;i<m;i++) {
			for(int j=0;j<n;j++) {
				if(arr[i][j]==0 && visit[i][j]==false) {
					cnt = 1;
					dfs(i,j);
					v.add(cnt);
				}
			}
		}
		Collections.sort(v);
		System.out.println(v.size());
		for(int i=0;i<v.size();i++) {
			bw.write(String.valueOf(v.get(i))+" ");
		}
		bw.close();
	}

}
