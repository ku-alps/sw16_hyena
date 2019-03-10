import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;

public class 난쟁이 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static ArrayList<Integer> al = new ArrayList<>();
	static void printArr(int i, int j) throws IOException {
		for(int k=0;k<9;k++) {
			if(k==i || k==j)
				continue;
			bw.write(String.valueOf(al.get(k))+'\n');
		}
		bw.close();
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		int sum=0;
		for(int i=0;i<9;i++) {
			al.add(Integer.parseInt(br.readLine()));
			sum += al.get(i);
		}
		Collections.sort(al); 
		for(int i=0;i<9;i++) { //브루트 포스-다해보기
			for(int j=0;j<9;j++) {
				if(i==j)
					continue;
				if(sum-al.get(i)-al.get(j)==100) {
					printArr(i,j);	
					return;
				}
			}
		}
	}
}
