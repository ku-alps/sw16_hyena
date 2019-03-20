package ��Ϳ�Ž;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class ���ǿ���ȸ {
	static int n;			//���ü�
	static double min;		//�ּҰ�α���
	static double arr[][];	//���ð��� �Ÿ�
	static int visit[];		//���� �湮 Ȯ��
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		min = Double.MAX_VALUE;
		n = Integer.parseInt(br.readLine());	
		arr = new double[n][n];
		visit = new int[n];
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<n;j++) {
				arr[i][j] = Double.parseDouble(st.nextToken());
			}
		}
		//����Ž�� ����
		for(int i=0;i<n;i++) {		//���۵���
			dfs(i,0,1);	
			visit[i] = 0;
		}
		System.out.println(String.format("%.12f", min));
		
	}
	public static void dfs(int city,double sum,int count) {
		visit[city] = 1;
		if(count==n) {	//��� ���ø� Ž��������
			min = Math.min(min, sum);
			return;
		}
		for(int i=0;i<n;i++) {
			if(visit[i]==0 && i!=city) {
				dfs(i,sum+=arr[city][i],count+1);
				visit[i] = 0; sum-=arr[city][i];
			}
		}
		return;
	}

}
