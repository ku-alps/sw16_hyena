package Default;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class �����Ǽ��н��� {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int now = 1,sum=0,cnt=0;int i,j;
		for(i=1;i<=1001;i++) {// ex) i�� 3�̸�
			for(j=0;j<i;j++) {//	 j�� now(3) 3�� �ݺ�
				cnt++;
				if(cnt>b) {
					System.out.println(sum);	//���� ������ ���
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
