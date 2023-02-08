import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int N, M, T;
	static int[][] city;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()); 
		
		N = stoi(st.nextToken());
		T = stoi(st.nextToken());
		
		city = new int[N + 1][3];
		
		for(int i = 1 ; i <= N ; ++i) {
			st = new StringTokenizer(br.readLine());
			city[i][0] = stoi(st.nextToken());
			city[i][1] = stoi(st.nextToken());
			city[i][2] = stoi(st.nextToken());
		}
		
		M = stoi(br.readLine());
		
		for(int i = 0 ; i < M ; ++i) {
			st = new StringTokenizer(br.readLine());
			int a = stoi(st.nextToken());
			int b = stoi(st.nextToken());
			int distance = 0;
			
			if(city[a][0] == 1 && city[b][0] == 1) {
				distance = getDistance(a, b);
			} else if(city[a][0] == 1) {
				int bToTelpo = getNearestTelpo(b);
				distance = Math.min(bToTelpo + T, getDistance(a, b));
			} else if(city[b][0] == 1) {
				int aToTelpo = getNearestTelpo(a);
				distance = Math.min(aToTelpo + T, getDistance(a, b));
			} else {
				int bToTelpo = getNearestTelpo(b);
				int aToTelpo = getNearestTelpo(a);
				distance = Math.min(bToTelpo + aToTelpo + T, getDistance(a, b));
			}
			System.out.println(distance);
		}
	}
	
	private static int getNearestTelpo(int point) {
		int min = Integer.MAX_VALUE;
		
		for(int i = 1 ; i <= N ; ++i) {
			if(city[i][0] == 0) continue;
			int dist = getDistance(point, i);
			min = min > dist ? dist : min;
		}

		return min;
	}

	private static int getDistance(int a, int b) {
		int dist = Math.abs(city[a][1] - city[b][1]) + Math.abs(city[a][2] - city[b][2]);
		if(city[a][0] == 1 && city[b][0] == 1) dist = dist > T ? T : dist;
		return dist;
	}
	
	private static int stoi(String s) {
		return Integer.parseInt(s);
	}
}
