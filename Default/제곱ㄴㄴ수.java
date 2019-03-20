package Default;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Á¦°ö¤¤¤¤¼ö {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		//st = new StringTokenizer(br.readLine());
		//int min = Integer.parseInt(st.nextToken());
		//int max = Integer.parseInt(st.nextToken());
		Scanner s = new Scanner(System.in);
		long min = s.nextLong();
		long max = s.nextLong();
		int arr[] = new int[1000010];
		int arr2[] = new int[1000010];
		int start = (int) Math.sqrt(min);
		int end = (int) Math.sqrt(max);
		int cnt=0;
		for(long i=min;i<=max;i++) {
			for(int j=start;j<=end;j++) {
				if(j==1)
					continue;
				if(i<=1000001) {
					if(arr[(int)i] == 0 && i%(j*j)==0) {
						arr[(int)i] = 1;
					}
				}
				else {
					int tmp = (int) Math.sqrt(i);
					if(arr2[tmp] == 0 && i%(j*j)!=0)
						arr2[tmp] = 1; 
				} 
			}
		}
		for(long i=min;i<=max;i++) {
			if(min<=1000001 && arr[(int)i]!=1)
				cnt++;
			else if(min>1000001 && arr2[(int)Math.sqrt(i)]!=1)
				cnt++;
		}
		bw.write(String.valueOf(cnt));
		bw.close();
	}

}