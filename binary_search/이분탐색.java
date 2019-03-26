package binary_search;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class ÀÌºÐÅ½»ö {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		int arr[] = new int[n];
		for(int i=0;i<n;i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		while(true) {
			int input = Integer.parseInt(br.readLine());
			if(input == -1)
				break;
			System.out.println(upper_bound(arr,input,0,arr.length-1));
			//bw.write(String.valueOf(lower_bound(arr,input,0,arr.length)));
		}
		bw.close();
	}
	public static int lower_bound(int[] array,int k, int l,int r) {
		int m;
		while(l<r) {
			m = (l+r)/2;
			if(array[m]<k) l = m+1;
			else r = m;
		}
		return l;
	}
	public static int upper_bound(int[] array,int k,int l,int r) {
		int m;
		while(l<r) {
			m = (l+r)/2;
			if(array[m]<=k) l = m+1;
			else r = m;
		}
		return l;
	}

}
