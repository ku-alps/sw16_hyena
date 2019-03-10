package parsing;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.PriorityQueue;
class numberArray implements Comparable<numberArray>{
	ArrayList<Integer> numArr = new ArrayList<>();
	int num;
	public void add(int num) {
		numArr.add(num);
	}
	public int getSize() {
		return numArr.size();
	}
	public int getNum(int index) {
		if(numArr.size()==0)
			return -1;
		return numArr.get(index);
	}
	public void printNum() {
		for(int i=0;i<numArr.size();i++)
			System.out.print(numArr.get(i));
		System.out.println();
	}
	@Override
	public int compareTo(numberArray target) {
		// TODO Auto-generated method stub
		if(this.getSize()>target.getSize())
			return 1;
		else if(this.getSize()==target.getSize()) {
			for(int i=0;i<this.getSize();i++) {
				if(this.getNum(i)>target.getNum(i))
					return 1;
				else if(this.getNum(i)<target.getNum(i))
					return -1;
			}
		}else
			return -1;
		return -1;
	}
}
public class 수학숙제 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		PriorityQueue<numberArray> pq = new PriorityQueue<numberArray>();
		int n = Integer.parseInt(br.readLine());
		for(int i=0;i<n;i++) {
			String tmp = br.readLine();
			numberArray arr = new numberArray();
			for(int j=0;j<tmp.length();j++) {
				if(arr.getSize()==0 && tmp.charAt(j)=='0' && j!=tmp.length()-1) //앞에 0은 업앰
					if(tmp.charAt(j+1)<='9' && tmp.charAt(j+1)>='0')
						continue;
				if(tmp.charAt(j)<='9' && tmp.charAt(j)>='0') { 
					arr.add(tmp.charAt(j)-'0');
				}else if(arr.getSize()>0) { //숫자가 이제 안나올때
					pq.add(arr);
					arr = new numberArray();
				}
			}
			if(arr.getSize()>0)
				pq.add(arr);
		}
		while(!pq.isEmpty()) {
			numberArray tmp = new numberArray();
			tmp = pq.poll();
			tmp.printNum();
		}
	}

}
