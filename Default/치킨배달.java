package Default;

import java.io.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class ġŲ��� {
    static class pos{
        int y;
        int x;
        public pos(int y, int x){
            super();
            this.y = y;
            this.x = x;
        }
    }
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int n;           //�Է� �迭 ũ��
    static int m;           //ġŲ�� �ּ� ��
    static LinkedList<pos> h = new LinkedList<>();  //�� ��ġ
    static LinkedList<pos> c = new LinkedList<>();  //ġŲ�� ��ġ
    static int ans=987654321;
    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<n;j++){
                int tmp = Integer.parseInt(st.nextToken());
                if(tmp==1){
                    h.add(new pos(i, j));
                }else if(tmp==2){
                    c.add(new pos(i,j));
                }
            }
        }
        int[] arr = new int[c.size()];
        for(int i=0;i<c.size();i++)
            arr[i] = i;
        int n = arr.length;
        int r = m;
        int[] combArr = new int[n];
        doCombination(combArr, n, r, 0, 0, arr);
        bw.write(String.valueOf(ans));
        bw.close();
    }
    //���� (n���� r�� �̱�)(�ߺ�X,����X)
    public static void doCombination(int[] combArr, int n, int r, int index, int target, int[] arr){
        if(r == 0){ //���Ҹ� �� ����
            int sum = 0;
            for(int i=0;i<h.size();i++){    //������ �� ����� ġŲ�� �Ÿ� ���
                int value = 987654321;
                for(int j=0;j<index;j++){
                    value = Math.min(value,Math.abs(h.get(i).y-c.get(arr[combArr[j]]).y) + Math.abs(h.get(i).x-c.get(arr[combArr[j]]).x));
                }
                sum += value;
            }
            ans = Math.min(ans,sum);
            //������ �� �˻��� ���
        }else if(target == n){
            return;
        }else{
            combArr[index] = target;
            //�̴� ���
            doCombination(combArr, n, r-1, index+1, target+1, arr);
            //�� �̴°��
            doCombination(combArr, n, r, index, target+1, arr);
        }
    }
}
