package Default;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class 이진검색트리 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int arr[];
	static int ind;
	public static void go(int l, int r) throws IOException {
		//System.out.println(l+" "+r);
		if(l>=r) { //l>r - 자식이 하나인 경우
			if(l==r) //단말노드일때 
				bw.write(String.valueOf(arr[l])+'\n');
			return;
		}
		int root = l;
		int leftIndex = l+1;
		int rightIndex = r;
		while(arr[leftIndex] > arr[root]) leftIndex++;
		while(arr[rightIndex] > arr[root]) rightIndex--;
		go(leftIndex,rightIndex);//왼쪽 탐색
		go(rightIndex+1,r);		 //오른쪽 탐색 
		bw.write(String.valueOf(arr[root])+'\n');
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		//txt파일로 테스트 (fr.readLine())
		//BufferedReader fr = new BufferedReader(new InputStreamReader(new FileInputStream("src/input.txt")));
		ind=0;
		String tmp = "";
		arr = new int[10001];
		while((tmp = br.readLine()) != null ) { //End Of File 처리
			arr[ind++] = Integer.parseInt(tmp);
		}
		br.close();
		go(0,ind-1);
		bw.close();
	}
}
