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
	public int compareTo(Score target) {	//������������ �������� ���� (������ 1��)
		if(this.a > target.a) {
			return 1;
		}else
			return -1;
	}
}
public abstract class ���Ի�� {

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
			Score score = ps.poll();	//ť �������� ������
			int max = score.b;
			while(!ps.isEmpty()) {	
				Score tmp = ps.poll();
				if(max > tmp.b) {	//�������� �� 
					ans++;
					max = tmp.b;	
				}
			}
			bw.write(String.valueOf(ans)+'\n');
		}
		bw.close();
	}
	private static PriorityQueue<Score> getPs(int cnt) throws IOException{ //���� �޾ƿ´�
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
