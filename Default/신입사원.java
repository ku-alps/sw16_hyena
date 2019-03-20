package Default;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
class Score implements Comparable<Score>{
	int a;
	int b;
	public Score(int a, int b) {
		super();
		this.a = a;
		this.b = b;
	}
	public int compareTo(Score target) {	//서류점수기준 내림차순 정렬 (맨위가 1등)
		if(this.a > target.a) {
			return 1;
		}else
			return -1;
	}
}
public abstract class 신입사원 {

	static StringTokenizer st;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		int t = Integer.parseInt(br.readLine());
		for(int i=0;i<t;i++) {
			int ans=1;
			int n = Integer.parseInt(br.readLine());
			PriorityQueue<Score> ps = getPs(n);
			Score score = ps.poll();	//큐 맨위에꺼 꺼내기
			int max = score.b;
			while(!ps.isEmpty()) {	
				Score tmp = ps.poll();
				if(max > tmp.b) {	//면접점수 비교 
					ans++;
					max = tmp.b;	
				}
			}
			bw.write(String.valueOf(ans)+'\n');
		}
		bw.close();
	}
	private static PriorityQueue<Score> getPs(int cnt) throws IOException{ //점수 받아온다
		PriorityQueue<Score> priorityQueue = new PriorityQueue<Score>();
		for(int j=0;j<cnt;j++) {
			st = new StringTokenizer(br.readLine());
			int s1 = Integer.parseInt(st.nextToken());
			int s2 = Integer.parseInt(st.nextToken());
			Score s = new Score(s1,s2);
			priorityQueue.offer(s);
		}
		return priorityQueue;
	}

}
