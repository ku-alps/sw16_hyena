package dynamic_programming;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.StringTokenizer;
import java.util.Vector;

public class DragonCurve {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st; 
	static int dx[]= {1,0,-1,0};
	static int dy[] = {0,-1,0,1};
	static int ans[][]; 
	static int fin[][] = new int[102][102]; //최종결과 
	static int x,y,d,g;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		int n = Integer.parseInt(br.readLine());
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			d = Integer.parseInt(st.nextToken());
			g = Integer.parseInt(st.nextToken());
			ans = new int[102][102];
			Vector<Integer> v = new Vector<Integer>(); //방향키 나열
			v.add(d);
			for(int j=0;j<g;j++) {
				for(int k=(int) Math.pow(2, j)-1;k>=0;k--) {
					v.add((v.get(k)+1)%4); //4면 0이되야하니까
				}
			}
			//ans 채우기
			ans[y][x] = 1;
			for(int j=0;j<v.size();j++) {
				ans[y+dy[v.get(j)]][x+dx[v.get(j)]] = 1; 
				y = y+dy[v.get(j)]; x = x+dx[v.get(j)];
			}
			//fin(최종)에 더하기
			for(int j=0;j<=100;j++) {
				for(int k=0;k<=100;k++)
					if(ans[j][k]>0)
						fin[j][k]=1;
			}
		} 
		int cnt=0;
		for(int i=0;i<=99;i++) {
			for(int j=0;j<=99;j++) {
				if(fin[i][j]==1&&fin[i+1][j]==1&&fin[i][j+1]==1&&fin[i+1][j+1]==1)
					cnt++;
			}
		}
		bw.write(String.valueOf(cnt));
		bw.close();
	}
}
