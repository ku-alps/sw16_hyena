package binary_search;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 개똥벌레 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int h = Integer.parseInt(st.nextToken());
		int arr[] = new int[n/2+1];
		int arr2[] = new int[n/2+1];
		int ans[] = new int[h];
		int cnt = 1, k=0;
		for(int i=1;i<=n;i++) {
			int tmp = Integer.parseInt(br.readLine());
			if(i%2 != 0) //석순일때
				arr[k] = tmp;
			else //종유석일때
				arr2[k++] = tmp; 
		}
		arr[n/2] = Integer.MAX_VALUE;
		arr2[n/2] = Integer.MAX_VALUE;
		Arrays.sort(arr);
		Arrays.sort(arr2);
		for(int i=1;i<=h;i++) {
			ans[i-1] = (n/2-lower_bound(arr,i,0,n/2))
			+ (n/2-upper_bound(arr2,h-i,0,n/2));
		}
		Arrays.sort(ans);
		for(int i=1;i<h;i++) 
			if(ans[0]==ans[i])
				cnt++;
		bw.write(String.valueOf(ans[0])+" "+String.valueOf(cnt));
		bw.close();
	}
	public static int lower_bound(int[] array,int k, int l,int r) {
		int m;
		while(r-l>0) {
			m = (l+r)/2;
			if(array[m]<k) l = m+1;
			else r = m;
		}
		return l;
	}
	public static int upper_bound(int[] array,int k, int l,int r) {
		int m;
		while(r-l>0) {
			m = (l+r)/2;
			if(array[m]<=k) l = m+1;
			else r = m;
		}
		return l;
	}
}
