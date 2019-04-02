package dynamic_programming;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 보드점프 {

	static int n;
	static int arr[][];
	static int visit[][];
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		n = Integer.parseInt(br.readLine());
		arr = new int[n][n];
		visit = new int[n][n];
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<n;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		bw.write(String.valueOf(isArrive(0,0)));
		bw.close();
	}
	public static int isArrive(int cy,int cx) {
		if(cy==n-1 && cx==n-1)	{//도착했을때
			return 1;
		}
		if(visit[cy][cx]>0) return visit[cy][cx];
		visit[cy][cx] = 0;
		int move = arr[cy][cx];
		int ny = cy+move,nx = cx+move;
		if(move>0) {
			if(ny<n) //y축이동
				visit[cy][cx] += isArrive(cy+move,cx);
			if(nx<n)//x축이동
				visit[cy][cx] += isArrive(cy,cx+move);
		}
		return visit[cy][cx];
	}

}

