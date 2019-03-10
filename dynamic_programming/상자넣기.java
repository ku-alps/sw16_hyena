package dynamic_programming;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.util.Vector;

public class 상자넣기 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		int arr[] = new int[n];
		Vector<Integer> v = new Vector<>();
		for(int i=0;i<n;i++)
			arr[i] = Integer.parseInt(st.nextToken());
		v.add(Integer.MAX_VALUE);
		for(int i=0;i<n;i++) {
			if(arr[i]>v.get(v.size()-1)) 
				v.add(arr[i]);
			else 
				v.set(lower_bound(v,arr[i],0,v.size()-1), arr[i]);
		}
		bw.write(String.valueOf(v.size()));
		bw.close();
	}
	//이분탐색 (k의 index반환)
	public static int lower_bound(Vector<Integer> v,int k,int l,int r) {
		while(r>l) {
			int m = (l+r)/2;
			if(v.get(m)<k) l = m+1;
			else r = m;
		}
		return l;
	}
}
