import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class 트로피진열 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n= Integer.parseInt(br.readLine());
		int arr[] = new int[n];
		int max = Integer.MIN_VALUE,maxInd = 0;
		for(int i=0;i<n;i++) {
			int input = Integer.parseInt(br.readLine());
			if(max < input) {
				max = input;
				maxInd = i;
			}
			arr[i] = input;
		}
		int left=1,right=1,tmp=arr[0];
		for(int i=1;i<=maxInd;i++) { //왼쪽에서 볼때
			if(arr[i]>tmp) {
				left++;
				tmp = arr[i];
			}
		}
		tmp = arr[n-1];
		for(int i=n-2;i>=maxInd;i--) { //오른쪽에서 볼때
			if(arr[i]>tmp) {
				right++;
				tmp = arr[i];
			}
		}
		bw.write(String.valueOf(left)+"\n"+String.valueOf(right));
		bw.close();
	}

}
