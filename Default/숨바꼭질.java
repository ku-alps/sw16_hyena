package Default;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class ¼û¹Ù²ÀÁú {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int n,m;
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		int dist[] = new int[n+1];
		@SuppressWarnings("unchecked")
		LinkedList<Integer> ll[] = new LinkedList[n+1];
		Queue<Integer> q = new LinkedList<Integer>();
		for(int i=1;i<=n;i++) {
			ll[i] = new LinkedList<>();
			dist[i] = -1;
		} dist[1] = 0;
		for(int i=0;i<m;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			ll[a].add(b); ll[b].add(a);
		}
		q.add(1);
		while(!q.isEmpty()) {
			int tmp = q.poll();
			for(int i=0;i<ll[tmp].size();i++) {
				if(dist[ll[tmp].get(i)] == -1) {
					q.add(ll[tmp].get(i));
					dist[ll[tmp].get(i)] = dist[tmp]+1;
				}
			}
		}
		int max = Integer.MIN_VALUE;
		for(int i=2;i<=n;i++) {
			if(max < dist[i])
				max = dist[i];
		}
		int num=-1,cnt=0;
		for(int i=2;i<=n;i++) {
			if(dist[i] == max) {
				if(num==-1) num = i;
				cnt++;
			}
		}
		bw.write(String.valueOf(num)+" "+String.valueOf(dist[num])+" "+String.valueOf(cnt));
		bw.close();
	}

}
