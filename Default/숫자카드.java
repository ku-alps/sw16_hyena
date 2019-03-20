package Default;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 숫자카드 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int arr[][] = new int[2][10000001];
		int n = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++) {
			int tmp = Integer.parseInt(st.nextToken());
			if(tmp>=0)
				arr[0][tmp]++;
			else
				arr[1][Math.abs(tmp)]++;		
		}
		int m = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<m;i++) {
			int tmp = Integer.parseInt(st.nextToken());
			if(tmp>=0) {
				if(arr[0][tmp]==1)
					bw.write("1 ");
				else
					bw.write("0 ");
			}
			else if(tmp<0) {
				if(arr[1][Math.abs(tmp)]==1)
					bw.write("1 ");
				else
					bw.write("0 ");
			}
		}
		bw.close();
	}

}
