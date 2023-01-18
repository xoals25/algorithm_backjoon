class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int[] people = new int[n + 2];
        int answer = n;
        
        for (int l: lost) {
            people[l]--;
        }
        
        for (int r: reserve) {
            people[r]++;
        }
        
        for (int i = 1; i < people.length; i++) {
            if (people[i] == -1) {
                if (people[i - 1] == 1) {
                    people[i - 1]--;
                    people[i]++;
                } else if (people[i + 1] == 1) {
                    people[i + 1]++;
                    people[i]++;
                } else {
                    answer--;
                }
            }
        }
        
        return answer;
    }
}