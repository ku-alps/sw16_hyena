package binary_search;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ThreeDots {

	static int arr[];
	static int count;
	static int n;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int t = Integer.parseInt(br.readLine());
		while(t>0) {
			t--;
			count=0;
			n = Integer.parseInt(br.readLine());
			arr = new int[n];
			st = new StringTokenizer(br.readLine());
			for(int i=0;i<n;i++) 
				arr[i] = Integer.parseInt(st.nextToken());
			Arrays.sort(arr);	//����(7�� �̻��� ��� ������Ʈ,float�� ����Ʈ)
			for(int bind=1;bind<n-1;bind++)	//b�� �������� ��ã�� 
				searchDot(0,bind,n-1);
			bw.write(String.valueOf(count)+"\n");
		}	
		bw.close();
	}
	public static void searchDot(int aind,int bind,int cind) {
		int a,b,c;
		while(aind<bind&&bind<cind) {
			a = arr[aind]; b= arr[bind]; c=arr[cind];	//�� ����
			if(b-a > c-b)
				aind++;
			else if(b-a == c-b) {
				count++;
				aind++;
			}
			else
				cind--;
		}
	}

}
