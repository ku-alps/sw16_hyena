package Default;

import java.io.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class 치킨배달 {
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
    static int n;           //입력 배열 크기
    static int m;           //치킨집 최소 수
    static LinkedList<pos> h = new LinkedList<>();  //집 위치
    static LinkedList<pos> c = new LinkedList<>();  //치킨집 위치
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
    //조합 (n개중 r개 뽑기)(중복X,순서X)
    public static void doCombination(int[] combArr, int n, int r, int index, int target, int[] arr){
        if(r == 0){ //원소를 다 뽑음
            int sum = 0;
            for(int i=0;i<h.size();i++){    //집마다 젤 가까운 치킨집 거리 계산
                int value = 987654321;
                for(int j=0;j<index;j++){
                    value = Math.min(value,Math.abs(h.get(i).y-c.get(arr[combArr[j]]).y) + Math.abs(h.get(i).x-c.get(arr[combArr[j]]).x));
                }
                sum += value;
            }
            ans = Math.min(ans,sum);
            //끝까지 다 검사한 경우
        }else if(target == n){
            return;
        }else{
            combArr[index] = target;
            //뽑는 경우
            doCombination(combArr, n, r-1, index+1, target+1, arr);
            //안 뽑는경우
            doCombination(combArr, n, r, index, target+1, arr);
        }
    }
}
