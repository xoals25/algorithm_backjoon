import java.util.Arrays;
import java.util.Queue;
import java.util.LinkedList;

class Solution {
    int[] X = {0, 0, 1, -1};
    int[] Y = {1, -1, 0, 0};

    public int solution(String[] maps) {
        int[] start = getStartPosition('S', maps);
        int[] lever = getStartPosition('L', maps);
        
        int leverCount = bfs('L', start, maps);
        
        if (leverCount == 0) {
            return -1;
        }
        
        int exitCount = bfs('E', lever, maps);
        
        if (exitCount == 0) {
            return -1;
        }
        
        return leverCount + exitCount;
    }
    
    private int bfs(char find, int[] start, String[] maps) {
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(start[0], start[1], 0));
        
        boolean[][] visited = new boolean[maps.length][maps[0].length()];
        visited[start[0]][start[1]] = true;
        
        int answer = 0;
        
        while(!q.isEmpty()) {
            Node cur = q.poll();
            
            if (maps[cur.x].charAt(cur.y) == find) {
                return cur.count;
            }
            
            for (int i = 0; i < 4; i++) {
                int x = cur.x + X[i];
                int y = cur.y + Y[i];
                
                if (x < 0 || y < 0 || x >= maps.length || y>= maps[0].length() || maps[x].charAt(y) == 'X' || visited[x][y]) {
                    continue;
                }
                
                visited[x][y] = true;
                q.offer(new Node(x, y, cur.count + 1));
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