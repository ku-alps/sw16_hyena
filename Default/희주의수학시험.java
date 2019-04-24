package Default;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 희주의수학시험 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int now = 1,sum=0,cnt=0;int i,j;
		for(i=1;i<=1001;i++) {// ex) i가 3이면
			for(j=0;j<i;j++) {//	 j로 now(3) 3번 반복
				cnt++;
				if(cnt>b) {
					System.out.println(sum);	//범위 끝나면 출력
					return;
				}
				if(cnt >=a)
					sum += now;
				System.out.println(now);
			}
			now++;
		}
	}

}
