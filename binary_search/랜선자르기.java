package binary_search;

import java.io.*;
import java.util.StringTokenizer;

public class 랜선자르기 {
    static int k;
    static int n;
    static long len[];
    public static void main(String[] args) throws NumberFormatException, IOException {
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        k = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        len = new long[k];
        for(int i=0;i<k;i++){
            len[i] = Integer.parseInt(br.readLine());
        }
        System.out.println(optimize());
    }
    static long optimize(){
        long max = 0;
        long lo = 0;
        long hi = Integer.MAX_VALUE;
        hi++;
        for(int i=0;i<100;i++){
            long mid = (lo+hi)/2;
            if(decision(mid)) {//가능하면 더 긴것도 가능한지 해보기
                lo = mid;
            }
            else    //불가능하면 더 짧은거 해보기
                hi = mid;
            //System.out.println(mid);
        }
        return lo;
    }
    static boolean decision(long mid){
        int count = 0;
        for(int i=0;i<k;i++){
            count += len[i]/mid;
        }
        return n <= count;
    }
}
