import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		ArrayList<Double>[] list = new ArrayList[n];
		for (int i = 0; i < n; i++) {
			list[i] = new ArrayList<>();
		}
		
		double[][] board = new double[n][n];

		double[] x = new double[n];
		double[] y = new double[n];
		
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			x[i] = Double.parseDouble(st.nextToken());
			y[i] = Double.parseDouble(st.nextToken());
		}
		
		//두 별 사이 거리만큼
		for(int i = 0; i<n; i++) {
			for(int j = i+1; j<n ; j++) {
				double cost = Math.sqrt((x[i]-x[j])*(x[i]-x[j]) + (y[i]-y[j])*(y[i]-y[j]));
				board[i][j] = cost;
				board[j][i] = cost;
			}
		}
		
		boolean[] vis = new boolean[n];
		double[] minEdge = new double[n];
		PriorityQueue<double[]> pq = new PriorityQueue<>(new Comparator<double[]>() {
			@Override
			public int compare(double[] o1, double[] o2) {
				return Double.compare(o1[1], o2[1]);
			}
		});
		
		Arrays.fill(minEdge, Double.MAX_VALUE);
		
		minEdge[0] = 0;
		pq.offer(new double[] {0,minEdge[0]});
		
		int minVertex = 0;
		int cnt = 0;
		double result = 0, min = 0;
		
		double[] cur;
		while(!pq.isEmpty()) {
			cur = pq.poll();
			minVertex = (int)cur[0];
			min = cur[1];
			
			if(vis[minVertex]) continue;
			
			vis[minVertex] = true;
			result += min;
			if(++cnt == n) break;
			
			for(int i = 0; i<n; i++) {
				if(!vis[i] && minEdge[i] > board[minVertex][i]) {
					minEdge[i] = board[minVertex][i];
					pq.offer(new double[] {i, minEdge[i]});
				}
			}
		}
		
		System.out.printf("%.2f",result);
	}
}
