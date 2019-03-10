import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 연산자끼워넣기 {

	static int n;
	static int num[];
	static int operNum[];
	static int min = Integer.MAX_VALUE;
	static int max = Integer.MIN_VALUE;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		n = Integer.parseInt(br.readLine());
		num = new int[11];
		operNum = new int[4];
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<4;i++) {
			operNum[i] = Integer.parseInt(st.nextToken());
		}
		dfs(operNum,1,num[0]);
		bw.write(String.valueOf(max)+"\n"+String.valueOf(min));
		bw.close();
	}
	public static void dfs(int[] remainCount,int count,int res) {
		if(count==n) {
			min = Math.min(min, res);
			max = Math.max(max, res);
			return;
		}
		for(int i=0;i<4;i++) {
			if(remainCount[i]>0) {
				remainCount[i]--;
				switch(i) {
				case 0:
					dfs(remainCount,count+1,res+num[count]);
					break;
				case 1:
					dfs(remainCount,count+1,res-num[count]);
					break;
				case 2:
					dfs(remainCount,count+1,res*num[count]);
					break;
				case 3:
					dfs(remainCount,count+1,res/num[count]);
					break;
				}remainCount[i]++;
			}
		}
	}
}
