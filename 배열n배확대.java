import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class �迭n��Ȯ�� {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n;
		int arr[][] = {{1,2},{3,4}};
		int ans[][] = new int[1001][1001];
		int height = 2,width=2;
		while(true) {
			bw.write("���� Ȯ���ұ��:");
			bw.flush();
			//System.out.println("���� Ȯ���ұ��:");
			n = Integer.parseInt(br.readLine());
			if(n==-1)
				break;
			for(int i=0;i<height*n;i++) {
				for(int j=0;j<width*n;j++) {
					ans[i][j] = arr[(int)i/n][(int)j/n];
				}
			}
			bw.write(String.valueOf(n)+"�� ���\n");
			for(int i=0;i<height*n;i++) {
				for(int j=0;j<width*n;j++) {
					bw.write(String.valueOf(ans[i][j])+" ");
				}bw.write("\n");
			}
		}
		bw.close();
	}

}
