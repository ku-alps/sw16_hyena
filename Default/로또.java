package Default;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Stack;
import java.util.StringTokenizer;

public class 로또 {	
	static int n;
	static int[] arr;
	static Stack<Integer> s = new Stack<Integer>();
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void print() throws IOException {
		for(int i=0;i<6;i++) 
			bw.write(String.valueOf(s.get(i))+" ");
		bw.write('\n');
	}
	public static void dfs(int pos) throws IOException {
		if(s.size()==6) {
			print();
			return;
		}else {
			for(int i=pos;i<n;i++) {
				s.push(arr[i]);
				dfs(i+1);
				s.pop();
			}
		}
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		StringTokenizer st;
		while(true) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			if(n==0) {//종료
				bw.close();
				return;
			}
			arr = new int[n+1];
			for(int i=0;i<n;i++) {	//입력
				arr[i] = Integer.parseInt(st.nextToken());
			}
			dfs(0);
			bw.write('\n');
			
		}
		
	}
}
