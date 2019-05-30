package binary_search;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class �̺�Ž�� {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());	//arr�� ����
		int arr[] = new int[n];						//���ĵ� �迭
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
	* array - ���ĵ� �迭
	* k - ã���� �ϴ� ��
	* lo - ���� �� ���� ���� �ε���
	* hi - ���� �� ���� ���� �ε���
	* */
	//���ĵ� �迭 array���� k�� �� �� �ִ� �ε��� �� ���� �ε��� ��ȯ
	public static int upper_bound(int[] array,int k,int lo,int hi) {
		int mid;
		while(lo<hi) {
			mid = (lo+hi)/2;
			if(array[mid]<=k) lo = mid+1; //k�� ���� ���� ������ ���������� �̵�
			else hi = mid;
		}
		return lo;
	}
	//���ĵ� �迭 array���� k�� �� �� �ִ� �ε��� �� ���� �ε��� ��ȯ
	public static int lower_bound(int[] array,int k, int lo,int hi) {
		int mid;
		while(lo<hi) {
			mid = (lo+hi)/2;
			if(array[mid]<k) lo = mid+1; //k���� ũ�ų� ������ �������� �̵�
			else hi = mid;
		}
		return lo;
	}
}
