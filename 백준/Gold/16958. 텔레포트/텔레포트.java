import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, M, T;
	static int[][] city;
	static int[][] distance;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()); 
		
		N = stoi(st.nextToken());
		T = stoi(st.nextToken());
		
		city = new int[N + 1][3];
		distance = new int[N + 1][N + 1];
		
		for(int i = 1 ; i <= N ; ++i) {
			st = new StringTokenizer(br.readLine());
			city[i][0] = stoi(st.nextToken());
			city[i][1] = stoi(st.nextToken());
			city[i][2] = stoi(st.nextToken());
		}
		
		for(int i = 1 ; i <= N ; ++i) {
			for(int j = 1 ; j <= N ; ++j) {
				if(i == j) continue;
				int dist = getDistance(i, j);
				
				if(city[i][0] == 1 && city[j][0] == 1) {
					dist = dist > T ? T : dist;
				}
				
				distance[i][j] = dist;
				distance[j][i] = dist;
			}
		}
		
		for(int mid = 1 ; mid <= N ; ++mid) {
			for(int from = 1 ; from <= N ; ++from) {
				for(int to = 1 ; to <= N ; ++to) {
					if(from == to) continue;
					if(distance[from][to] > distance[from][mid] + distance[mid][to]) {
						distance[from][to] = distance[from][mid] + distance[mid][to];
					}
				}
			}
		}
		
		M = stoi(br.readLine());
		
		for(int i = 0 ; i < M ; ++i) {
			st = new StringTokenizer(br.readLine());
			int from = stoi(st.nextToken());
			int to = stoi(st.nextToken());
			
			System.out.println(distance[from][to]);
		}
	}
	
	private static int getDistance(int a, int b) {
		return Math.abs(city[a][1] - city[b][1]) + Math.abs(city[a][2] - city[b][2]);
	}
	
	private static int stoi(String s) {
		return Integer.parseInt(s);
	}
}
