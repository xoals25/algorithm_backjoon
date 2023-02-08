import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    static long INF = 2_000_000_000 * 8 + 1;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        Point[] point = new Point[8];
        point[0] = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        
        st = new StringTokenizer(br.readLine(), " ");
        point[7] = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        
        for (int i = 1; i < 7; i += 2) {
            st = new StringTokenizer(br.readLine(), " ");
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            point[i] = new Point(x1, y1);
            point[i + 1] = new Point(x2, y2);
        }
        
        long[][] times = new long[8][8];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (i != j) {
                    times[i][j] = INF;
                }
            }
        }
        
        for (int i = 0; i < 8; i++) {
            for (int j = i + 1; j < 8; j++) {
                times[i][j] = times[j][i] = Math.abs(point[i].x - point[j].x) + Math.abs(point[i].y - point[j].y);
                if (j % 2 == 0) {
                    times[i][j] = times[j][i] = Math.min(times[i][j], times[i][j - 1] + 10);
                }
            }
        }
        
        for (int k = 0; k < 8; k++) {
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    if (times[i][k] != INF && times[k][j] != INF) {
                        times[i][j] = Math.min(times[i][j], times[i][k] + times[k][j]);
                    }
                }
            }
        }
        
        bw.write(times[0][7] + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}

class Point {
    int x;
    int y;
    
    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

