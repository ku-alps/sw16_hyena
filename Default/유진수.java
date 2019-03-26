package Default;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class À¯Áø¼ö {
	static int num[];
	static String input;
	static int len;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		input = br.readLine(); 
		len = input.length();
		num = new int[11];
		for(int i=0;i<len;i++) {
			num[i] = input.charAt(i)-48;
		}
		if(isYujinsu())
			bw.write("YES");
		else
			bw.write("NO");
		bw.close();
	}
	public static boolean isYujinsu() {
		for(int i=1;i<len;i++) {
			if(left(i) == right(i))
				return true;
		}
		return false;
	}
	public static int left(int ind) {
		int tmp = 1;
		for(int i=0;i<ind;i++)
			tmp = tmp*num[i];
		return tmp;
	}
	public static int right(int ind) {
		int tmp = 1;
		for(int i=ind;i<len;i++)
			tmp = tmp*num[i];
		return tmp;
	}

}
