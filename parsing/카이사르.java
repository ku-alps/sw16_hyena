package parsing;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class 카이사르 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String input = br.readLine();
		String ans = caesar_decrypt(input);
		bw.write(ans);
		bw.close();
	}
	public static String caesar_decrypt(String tmp) {
		StringBuffer sb = new StringBuffer();
		for(int i=0;i<tmp.length();i++) {
			char tmp2 = tmp.charAt(i);
			if(tmp2==' ') {
				sb.append(" ");
				continue;
			}
			if(tmp2>='x') {
				sb.append((char)('a'+tmp2%'x'));
				continue;
			}
			sb.append((char)(tmp2+3));		
		}
		return sb.toString();
	}
}
