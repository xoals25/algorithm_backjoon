import java.util.*;

class Solution {
    int[] X = {0, 0, 1, -1};
    int[] Y = {1, -1, 0, 0};
    
    public int[] solution(String[] maps) {
        List<Integer> list = new ArrayList<>();
        
        boolean[][] visited = new boolean[maps.length][maps[0].length()];
        
        for (int i = 0; i < maps.length; i++) {
            String map = maps[i];
            
            for (int j = 0; j < map.length(); j++) {
                if (maps[i].charAt(j) == 'X' || visited[i][j]) {
                    continue;
                }
                
                list.add(dfsForSum(i, j, maps, visited));
            }
        }
        
        if (list.size() == 0) {
            return new int[]{-1};
        }
        
        int[] answer = new int[list.size()];
        
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        
        Arrays.sort(answer);
        
        return answer;
    }
    
    private int dfsForSum(int x, int y, String[] maps, boolean[][] visited) {
        int sum = 0;        
        
        Stack<int[]> stack = new Stack<>();
        stack.push(new int[]{x, y});
        
        while (!stack.isEmpty()) {
            int[] prev = stack.pop();
            
            int prevX = prev[0];
            int prevY = prev[1];
            
            
            if (visited[prevX][prevY]) {
                continue;
            }
            
            visited[prevX][prevY] = true;
            
            sum += maps[prevX].charAt(prevY) - '0';
            
            for (int i = 0; i < 4; i++) {
                int curX = X[i] + prevX;
                int curY = Y[i] + prevY;
                
                if (curX < 0 
                    || curY < 0 
                    || curX >= maps.length 
                    || curY >= maps[curX].length() 
                    || maps[curX].charAt(curY) == 'X' 
                    || visited[curX][curY]) {
                    
                    continue;
                }
                
                stack.push(new int[]{curX, curY});
            }
        }
        
        return sum;
    }
}