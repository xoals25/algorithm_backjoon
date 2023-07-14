import java.util.Arrays;
import java.util.Stack;

class Solution {
    int[] X = {0, 0, 1, -1};
    int[] Y = {1, -1, 0, 0};

    public int solution(String[] maps) {
        int[] start = getStartPosition('S', maps);
        int[] lever = getStartPosition('L', maps);

        int leverCount = dfs('L', start, maps);

        if (leverCount == 0) {
            System.out.println("Test1");
            return -1;
        }
        

        int exitCount = dfs('E', lever, maps);

        if (exitCount == 0) {
            System.out.println("Test2");
            
            return -1;
        }

        System.out.println("exitCount " + exitCount);

        return leverCount + exitCount;
    }

    private int dfs(char find, int[] start, String[] maps) {
        int[][] visited = new int[maps.length][maps[0].length()];

        for (int[] ints : visited) {
            Arrays.fill(ints, maps.length * maps.length);
        }

        visited[start[0]][start[1]] = 0;

        int answer = 0;

        Stack<Node> st = new Stack<>();
        st.push(new Node(start[0], start[1], answer));

        while (!st.isEmpty()) {
            Node cur = st.pop();

            
            if (maps[cur.x].charAt(cur.y) == find) {
                if (answer == 0) {
                    answer = cur.count;
                } else {
                    answer = Math.min(answer, cur.count);
                }
            }

            for (int i = 0; i < 4; i++) {
                int x = cur.x + X[i];
                int y = cur.y + Y[i];
                int count = cur.count + 1;
                
                if (x < 0 || x >= maps.length || y < 0 || y >= maps[0].length() || maps[x].charAt(y) == 'X' || count >= visited[x][y]) {
                    continue;
                }
                
                st.push(new Node(x, y, Math.min(visited[x][y], count)));
                visited[x][y] = Math.min(visited[x][y], count);
            }
        }

        return answer;
    }

    private int[] getStartPosition(char find, String[] maps) {
        for (int i = 0; i < maps.length; i++) {
            for (int j = 0; j < maps[i].length(); j++) {
                if (maps[i].charAt(j) == find) {
                    return new int[]{i, j};
                }
            }
        }

        return null;
    }
}

class Node {
    int x;
    int y;
    int count;

    public Node(int x, int y, int count) {
        this.x = x;
        this.y = y;
        this.count = count;
    }
}