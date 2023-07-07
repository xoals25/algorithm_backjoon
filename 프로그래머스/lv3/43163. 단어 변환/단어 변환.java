class Solution {
    int answer = Integer.MAX_VALUE;

    public int solution(String begin, String target, String[] words) {
        boolean[] visited = new boolean[words.length];
        dfs(0, 0, begin, target, words, visited);

        return answer == Integer.MAX_VALUE ? 0 : answer;
    }

    private void dfs(int idx, int count, String begin, String target, String[] words, boolean[] visited) {
        if (idx >= words.length) {
            return;
        }

        if (begin.equals(target)) {
            answer = Math.min(answer, count);
            return;
        }


        for (int i = 0; i < words.length; i++) {
            if (visited[i] || answer <= count || !ckWord(begin, words[i])) {
                continue;
            }

            visited[i] = true;
            dfs(i, count + 1, words[i], target, words, visited);
            visited[i] = false;
        }
    }

    private boolean ckWord(String begin, String target) {
        int differentCount = 0;
        for (int i = 0; i < begin.length(); i++) {
            if (begin.charAt(i) != target.charAt(i)) {
                differentCount++;

                if (differentCount >= 2) {
                    return false;
                }
            }
        }

        return true;
    }
}