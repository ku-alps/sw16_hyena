package network_flow;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 열혈강호2 {

    static int adj[][];		//직원이 할 수 있는 일 표시
    static int aMatch[],bMatch[];		//직원과 일이 연결되어 있는지
    static int visit[];		//dfs돌때 방문했는지 확인
    static int n,m,match;
    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        //이분매칭
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());	//직원 수
        m = Integer.parseInt(st.nextToken());	//일 수
        adj = new int[1001][1001];
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
                visit = new int[n+1];   //한번 더 호출
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
