package Àç±Í¿ÏÅ½;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Á¦°ö¼öÀÇÇÕ {

	static int min = Integer.MAX_VALUE;
	static int n,tmp;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		n = Integer.parseInt(br.readLine());
		int copy = n;
		for(int i=(int) Math.floor(Math.sqrt(n));i>=0;i--) {
			
		}
		dfs(n,0);
		bw.write(String.valueOf(min));
		bw.close();
	}
	public static void dfs(int num,int count) {
		if(num==1 || num==0) {
			min = Math.min(min, count);
			return;
		}
		for(int i=(int) Math.floor(Math.sqrt(num));i>=0;i--) {
			System.out.println(i);
			dfs(num-i*i,count+1);
			count=0;
		}
		return;
	}

}
