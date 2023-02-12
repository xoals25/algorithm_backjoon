import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));;
    public static int N;

    public static void main(String[] args) throws Exception {
        N = Integer.parseInt(br.readLine());

        int[][] schedules = initSchedule();

        Arrays.sort(schedules, ((x, y) -> x[0] - y[0]));

        PriorityQueue<int[]> pq = new PriorityQueue<>((x, y) -> x[1] - y[1]);
        pq.offer(schedules[0]);

        for (int i = 1; i < N; i++) {
            int beforeEndTime = pq.peek()[1];
            int nowStartTime = schedules[i][0];

            if (beforeEndTime <= nowStartTime) {
                pq.poll();
            }

            pq.offer(schedules[i]);
        }


        System.out.println(pq.size());
        br.close();
    }

    public static int[][] initSchedule() throws Exception {
        int[][] schedules = new int[N][2];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            schedules[i][0] = Integer.parseInt(st.nextToken());
            schedules[i][1] = Integer.parseInt(st.nextToken());
        }

        return schedules;
    }
}