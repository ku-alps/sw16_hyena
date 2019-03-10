import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 지능형기차 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int max = 0,now = 0;
		for(int i=0;i<4;i++) {
			st = new StringTokenizer(br.readLine());
			if(max < (now = now - Integer.parseInt(st.nextToken()) + Integer.parseInt(st.nextToken())))
				max = now;
		}
		bw.write(String.valueOf(max));
		bw.close();
	}

}
