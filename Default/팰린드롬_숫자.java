package Default;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;

public class 팰린드롬_숫자 {

	static BigInteger n;
	static String output;
	public static boolean check(String palin) { //팰린드롬 체크
		int last = palin.length()-1;
		int center = palin.length()/2;
		for(int i=0;i<center;i++) {
			if(palin.charAt(i) != palin.charAt(last-i)) {
				return false;
			}
		}
		return true;
	}
	public static boolean cal(int num) { //n진법 계산
		output = "";
		BigInteger tmp = n;
		while(tmp.compareTo(BigInteger.valueOf(num)) == 1 || tmp.compareTo(BigInteger.valueOf(num))==0) {
			output = output + String.valueOf(tmp.remainder(BigInteger.valueOf(num)).intValue());
			tmp = tmp.divide(BigInteger.valueOf(num));
		}
		int tmp2 = tmp.intValue();
		output = output + tmp2;
		if(check(output))
			return true;
		return false;
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		//n = Integer.parseInt(in.readLine());
		n = new BigInteger(in.readLine());
		int cnt=0;
		for(int i=2;i<=10;i++) {
			if(cal(i)) {
				StringBuffer sb = new StringBuffer(output);
				out.write(String.valueOf(i)+" "+sb.reverse().toString()+"\n");
				cnt++;
			}
		}
		if(cnt==0)
			out.write("NIE");
		out.close();
	}

}
