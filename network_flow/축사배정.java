package network_flow;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class ������ {

	static int adj[][];		//�ҿ� ���ϴ� ��� ǥ��
	static int aMatch[],bMatch[];		//�ҿ� ��簡 ����Ǿ� �ִ���
	static int visit[];		//dfs���� �湮�ߴ��� Ȯ��
	static int n,m,match;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		//�̺и�Ī
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());	//���� ��
		m = Integer.parseInt(st.nextToken());	//��� ��
		adj = new int[201][201];
		aMatch = new int[n+1];bMatch = new int[m+1];
		for(int i=1;i<=n;i++) {
			st = new StringTokenizer(br.readLine());
			int k = Integer.parseInt(st.nextToken());
			for(int j=0;j<k;j++) {
				int tmp = Integer.parseInt(st.nextToken());
				adj[i][tmp] = 1;
			}
		}
		match = 0;
		for(int i=1;i<=n;i++) {
			if(aMatch[i]==0) {
				visit = new int[n+1];
				if(dfs(i)) match++;
			}
		}
		bw.write(String.valueOf(match));
		bw.close();
	}
	//a�� ��Ī��Ű�� true,���ϸ� false
	public static boolean dfs(int a) {
		if(visit[a]==1) return false;
		visit[a] = 1;
		for(int b=1;b<=m;b++) {
			//����Ǿ� �ְ�
			//��Ī�� ���� �ȵǾ��ų� �ٸ��Ŷ� ��Ī �Ǹ�
			if(adj[a][b]==1 && (bMatch[b]==0||dfs(bMatch[b]))) {
				aMatch[a] = b;
				bMatch[b] = a;
				return true;
			}
		}
		//��Ī ����
		return false;
	}

}
