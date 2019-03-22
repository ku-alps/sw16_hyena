package Default;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class ÃÌ¼ö°è»ê {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		boolean arr[][] = new boolean[101][101];
		boolean visit[] = new boolean[101];
		int depth[] = new int[101];
		st = new StringTokenizer(br.readLine());
		int p1 = Integer.parseInt(st.nextToken());
		int p2 = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(br.readLine());
		int x,y;
		for(int i=0;i<m;i++) {
			st = new StringTokenizer(br.readLine());
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			arr[x][y] = arr[y][x] = true;
		}//ÀÔ·Â
		
		Queue<Integer> q = new LinkedList<>();
		q.add(p1); 
		while(!q.isEmpty()) { //p1ºÎÅÍ bfsÅ½»ö
			int front = q.poll();
			visit[front] = true;
			for(int i=1;i<=n;i++) {
				if(visit[i] == false && arr[front][i]==true) {
					q.add(i);
					depth[i] = depth[front]+1;
				}
			}
		}
		if(depth[p2]==0)
			bw.write(String.valueOf(-1));
		else
			bw.write(String.valueOf(depth[p2]));
		bw.close();
		
	}

}
