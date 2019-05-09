package Å½¿å¹ý;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class µ¿Àü0 {
	static int n;
	static int k;
	static int a[];
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		a = new int[n];
		for(int i=0;i<n;i++) {
			a[i] = Integer.parseInt(br.readLine());
		}
		int ind = n-1;
		int count = 0;
		while(k>0) {
			if(k>=a[ind]) {
				k -= a[ind];
				count++;
			}else {
				ind--;
			}
		}
		System.out.println(String.valueOf(count));
	}

}
