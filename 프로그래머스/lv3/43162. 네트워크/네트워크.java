import java.util.Queue;
import java.util.LinkedList;

class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;

        boolean[] visited = new boolean[n];
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < computers.length; i++) {
            if (visited[i]) {
                continue;
            }

            queue.offer(i);
            answer++;

            while(!queue.isEmpty()) {
                int cur = queue.poll();

                if (visited[cur]) {
                    continue;
                }

                visited[cur] = true;

                int[] computer = computers[cur];

                for (int j = 0; j < computer.length; j++) {
                    if (visited[j] || computer[j] == 0){
                        continue;
                    }

                    queue.offer(j);
                }
            }
        }


        return answer;
    }
}
