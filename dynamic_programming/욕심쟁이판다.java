package dynamic_programming;

import java.io.*;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class ��������Ǵ� {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int n;           //�Է� �迭 ũ��
    static int dy[] = {0,1,0,-1};
    static int dx[] = {1,0,-1,0};
    static int arr[][];     //�ԷµǴ� �迭
    static int visit[][];   //visit[1][1] - (1,1)���� �����ϴ� �ִ���
    static int ans = 0;     //�ִ��α���
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
    //getMax(1,1) - (1,1)���� ����ϴ� �ִ��� ���� ��ȯ
    static int getMax(int y, int x){
        if(visit[y][x]>0) return visit[y][x];
        int value[] = new int[4];   //��,��,��,�쿡�� �� ���� ��ȯ
        for(int i=0;i<4;i++){
            int ny = y+dy[i]; int nx = x+dx[i];
            if(ny>=0&&ny<n&&nx>=0&&nx<n) {
                if(arr[ny][nx] > arr[y][x])
                    value[i] = getMax(ny,nx);
            }
        }
        Arrays.sort(value);         //�������� ����
        visit[y][x] = value[3]+1;   //��,��,��,�� �� �ִ�����
        return visit[y][x];         //���� ��ȯ
    }
}
