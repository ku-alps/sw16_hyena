package 재귀완탐;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class 유레카이론 {

	static int isSam[];		//인덱스 값이 삼각수이면1, 아니면0 
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		isSam = new int[1100];
		for(int i=1;i<=45;i++) 
			isSam[(i*(i+1))/2] = 1;
		int t = Integer.parseInt(br.readLine());	//테스트케이스
		while(t>0) {
			t--;
			int k = Integer.parseInt(br.readLine());
			if(isUr(k,0))
				System.out.println(1);
			else
				System.out.println(0);
		}
	}
	public static boolean isUr(int num,int count) {		//유레카인지 확인(유레카-3개의 삼각수로 이루어진 수,중복가능)
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
