package network_flow;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 축사배정 {

	static int adj[][];		//소와 원하는 축사 표시
	static int aMatch[],bMatch[];		//소와 축사가 연결되어 있는지
	static int visit[];		//dfs돌때 방문했는지 확인
	static int n,m,match;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		//이분매칭
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());	//동물 수
		m = Integer.parseInt(st.nextToken());	//축사 수
		adj = new int[201][201];
		aMatch = new int[n+1];bMatch = new int[m+1];
		for(int i=1;i<=n;i++) {
			st = new StringTokenizer(br.readLine());
			int k = Integer.parseInt(st.nextToken());
			for(int j=0;j<k;j++) {
				int tmp = Integer.parseInt(st.nextToken());
				adj[i][tmp] = 1;
			}
		}
		match = 0;
		for(int i=1;i<=n;i++) {
			if(aMatch[i]==0) {
				visit = new int[n+1];
				if(dfs(i)) match++;
			}
		}
		bw.write(String.valueOf(match));
		bw.close();
	}
	//a를 매칭시키면 true,못하면 false
	public static boolean dfs(int a) {
		if(visit[a]==1) return false;
		visit[a] = 1;
		for(int b=1;b<=m;b++) {
			//연결되어 있고
			//매칭이 아직 안되었거나 다른거랑 매칭 되면
			if(adj[a][b]==1 && (bMatch[b]==0||dfs(bMatch[b]))) {
				aMatch[a] = b;
				bMatch[b] = a;
				return true;
			}
		}
		//매칭 실패
		return false;
	}

}
