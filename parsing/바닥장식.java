package parsing;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class ¹Ù´ÚÀå½Ä {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		Character arr[][] = new Character[n][m];
		for(int i=0;i<n;i++) {
			String tmp = br.readLine();
			for(int j=0;j<m;j++) {
				arr[i][j] = tmp.charAt(j);
			}
		}
		int a = 0,b=0,i=0,j=0; boolean cona = false,conb = false;
		for(i=0;i<n;i++) {
			cona = false;
			for(j=0;j<m;j++) {
				if(arr[i][j] == '|') cona = false;
				else if(cona==false) {cona = true;a++;}
			}
		}
		for(i=0;i<m;i++) {
			conb = false;
			for(j=0;j<n;j++) {
				if(arr[j][i] == '-') conb = false;
				else if(conb==false){conb = true;b++;}
			}
		}
		bw.write(String.valueOf(a+b));
		bw.close();
	}

}
