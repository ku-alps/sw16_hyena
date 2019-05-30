package binary_search;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 이분탐색 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());	//arr의 길이
		int arr[] = new int[n];						//정렬된 배열
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++)
			arr[i] = Integer.parseInt(st.nextToken());
		int input = Integer.parseInt(br.readLine());
		bw.write("upper_bound : "+upper_bound(arr,input,0,arr.length));
		bw.write("\n");
		bw.write("lower_bound : "+lower_bound(arr,input,0,arr.length));
		bw.close();
	}
	/*
	* array - 정렬된 배열
	* k - 찾고자 하는 값
	* lo - 범위 내 제일 낮은 인덱스
	* hi - 범위 내 제일 높은 인덱스
	* */
	//정렬된 배열 array에서 k가 들어갈 수 있는 인덱스 중 높은 인덱스 반환
	public static int upper_bound(int[] array,int k,int lo,int hi) {
		int mid;
		while(lo<hi) {
			mid = (lo+hi)/2;
			if(array[mid]<=k) lo = mid+1; //k와 같은 값이 나오면 오른쪽으로 이동
			else hi = mid;
		}
		return lo;
	}
	//정렬된 배열 array에서 k가 들어갈 수 있는 인덱스 중 낮은 인덱스 반환
	public static int lower_bound(int[] array,int k, int lo,int hi) {
		int mid;
		while(lo<hi) {
			mid = (lo+hi)/2;
			if(array[mid]<k) lo = mid+1; //k보다 크거나 같으면 왼쪽으로 이동
			else hi = mid;
		}
		return lo;
	}
}
