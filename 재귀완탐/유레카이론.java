package ��Ϳ�Ž;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class ����ī�̷� {

	static int isSam[];		//�ε��� ���� �ﰢ���̸�1, �ƴϸ�0 
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		isSam = new int[1100];
		for(int i=1;i<=45;i++) 
			isSam[(i*(i+1))/2] = 1;
		int t = Integer.parseInt(br.readLine());	//�׽�Ʈ���̽�
		while(t>0) {
			t--;
			int k = Integer.parseInt(br.readLine());
			if(isUr(k,0))
				System.out.println(1);
			else
				System.out.println(0);
		}
	}
	public static boolean isUr(int num,int count) {		//����ī���� Ȯ��(����ī-3���� �ﰢ���� �̷���� ��,�ߺ�����)
		if(num==0 && count==3)
			return true;
		for(int i=1;i<=num;i++) {
			if(isSam[i]==1 && count<3)
				if(isUr(num-i,count+1))
					return true;
		}
		return false;
	}

}
