import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class p1697 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());	//내 위치
		int k = Integer.parseInt(st.nextToken());	//동생 위치
		Queue<Integer> q1 = new LinkedList<Integer>();	//이동하는 위치 
		Queue<Integer> q2 = new LinkedList<Integer>();	//이동 횟수
		int visit[] = new int[100001];	//방문한 곳 체크
		int count=0, front;
		q1.add(n);
		q2.add(count);
		while(!q1.isEmpty()) {
			count++;
			front = q1.poll();
			if(front==k)
				break;
			count = q2.poll();
			visit[front] = 1;
			if((front-1) >=0) {
				if(visit[front-1]==0) {
					q1.add(front-1);
					q2.add(count+1);
				}
			}
			if((front+1) <= 100000) {
				if(visit[front+1]==0) {
					q1.add(front+1);
					q2.add(count+1);
				}
			}
			if((front*2) <= 100000) {
				if(visit[front*2]==0) {
					q1.add(front*2);
					q2.add(count+1);
				}
			}
		}
		bw.write(String.valueOf(q2.poll()));
		bw.close();
	}

}
