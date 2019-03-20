package Default;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class ªÍ√• {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int h = Integer.parseInt(st.nextToken());
		int w = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		int arr[][] = new int[h][w];
		for(int i=0;i<h;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<w;j++)
			arr[i][j] = Integer.parseInt(st.nextToken());
		}
		int y=0,x=0;
		for(int i=0;i<n;i++) {
			y=0;x=0;
			while(y!=h && x!=w) {
				if(arr[y][x]==0) {
					arr[y][x] = 1;
					y++;
					continue;
				}
				else {
					arr[y][x] = 0;
					x++;
				}
			}
		}
		bw.write(String.valueOf(y+1)+" "+String.valueOf(x+1));
		bw.close();
	}

}
