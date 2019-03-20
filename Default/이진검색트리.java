package Default;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class �����˻�Ʈ�� {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int arr[];
	static int ind;
	public static void go(int l, int r) throws IOException {
		//System.out.println(l+" "+r);
		if(l>=r) { //l>r - �ڽ��� �ϳ��� ���
			if(l==r) //�ܸ�����϶� 
				bw.write(String.valueOf(arr[l])+'\n');
			return;
		}
		int root = l;
		int leftIndex = l+1;
		int rightIndex = r;
		while(arr[leftIndex] > arr[root]) leftIndex++;
		while(arr[rightIndex] > arr[root]) rightIndex--;
		go(leftIndex,rightIndex);//���� Ž��
		go(rightIndex+1,r);		 //������ Ž�� 
		bw.write(String.valueOf(arr[root])+'\n');
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		//txt���Ϸ� �׽�Ʈ (fr.readLine())
		//BufferedReader fr = new BufferedReader(new InputStreamReader(new FileInputStream("src/input.txt")));
		ind=0;
		String tmp = "";
		arr = new int[10001];
		while((tmp = br.readLine()) != null ) { //End Of File ó��
			arr[ind++] = Integer.parseInt(tmp);
		}
		br.close();
		go(0,ind-1);
		bw.close();
	}
}
