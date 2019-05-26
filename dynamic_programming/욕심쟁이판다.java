package dynamic_programming;

import java.io.*;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class 욕심쟁이판다 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int n;           //입력 배열 크기
    static int dy[] = {0,1,0,-1};
    static int dx[] = {1,0,-1,0};
    static int arr[][];     //입력되는 배열
    static int visit[][];   //visit[1][1] - (1,1)에서 시작하는 최대경로
    static int ans = 0;     //최대경로길이
    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        visit = new int[n][n];
        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<n;j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                visit[i][j] = getMax(i,j);
                ans = Math.max(ans,visit[i][j]);
            }
        }
        bw.write(String.valueOf(ans));
        bw.close();
    }
    //getMax(1,1) - (1,1)에서 출발하는 최대경로 길이 반환
    static int getMax(int y, int x){
        if(visit[y][x]>0) return visit[y][x];
        int value[] = new int[4];   //상,하,좌,우에서 온 길이 반환
        for(int i=0;i<4;i++){
            int ny = y+dy[i]; int nx = x+dx[i];
            if(ny>=0&&ny<n&&nx>=0&&nx<n) {
                if(arr[ny][nx] > arr[y][x])
                    value[i] = getMax(ny,nx);
            }
        }
        Arrays.sort(value);         //오름차순 정렬
        visit[y][x] = value[3]+1;   //상,하,좌,우 중 최댓값으로
        return visit[y][x];         //길이 반환
    }
}
