import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class 일로만들기 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		int arr[] = new int[n+1]; arr[1] = 0;
		for(int i=2;i<=n;i++) {
			arr[i] = Integer.MAX_VALUE;
			if(i<=3)
				arr[i] = 1;
			else {
				if(i%3==0)
					arr[i] = Math.min(arr[i], 1+arr[i/3]);
				if(i%2==0)
					arr[i] = Math.min(arr[i], 1+arr[i/2]);
				arr[i] = Math.min(arr[i], 1+arr[i-1]);
			}
		}
		bw.write(String.valueOf(arr[n]));
		bw.close();
	}

}
