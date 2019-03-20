package Default;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class 영화수집 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int t = Integer.parseInt(br.readLine());
		for(int i=0;i<t;i++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			LinkedList<Integer> ll = new LinkedList<Integer>();
			for(int j=0;j<n;j++)
				ll.add(j+1);
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<m;j++) {
				int tmp = Integer.parseInt(st.nextToken());
				int ind = ll.indexOf(new Integer(tmp));
				ll.remove(new Integer(tmp));
				bw.write(String.valueOf(ind)+" ");
				ll.push(tmp);
			}bw.write("\n");
		}
		bw.close();
	}

}
