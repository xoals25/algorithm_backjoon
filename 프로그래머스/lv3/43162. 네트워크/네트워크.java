import java.util.Stack;

class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        
        boolean[] visited = new boolean[n];
        
        for (int i = 0; i < computers.length; i++) {
            if (visited[i]) {
                continue;
            }
            
            dfs(i, computers, visited);
            answer++;
        }
        
        return answer;
    }
    
    private void dfs(int computer, int[][] computers, boolean[] visited) {
        if (visited[computer]) {
            return;
        }
        
        visited[computer] = true;
        
        for (int i = 0; i < computers.length; i++) {
            if (visited[i] || computers[computer][i] == 0) {
                continue;
            }
            
            dfs(i, computers, visited);
        }
    }
}