import java.util.*;

class Solution {
    public int[] solution(String[] park, String[] routes) {
        int[] start = getStartPosition(park);
        
        int H = park.length;
        int W = park[0].length();
        
        for (String route: routes) {
            char direction = route.charAt(0);
            int num = route.charAt(2) - '0';
            
            if (direction == 'E') {
                if (start[1] + num > W - 1) {
                    continue;
                }
                
                start[1] += num;
                
                for (int j = start[1] - num + 1; j <= start[1]; j++) {
                    if (park[start[0]].charAt(j) == 'X') {
                        start[1] -= num;
                        break;
                    };
                }     
            } else if (direction == 'W') {
                if (start[1] - num < 0) {
                    continue;
                }
                
                start[1] -= num;
                
                for (int j = start[1]; j <= start[1] + num; j++) {
                    if (park[start[0]].charAt(j) == 'X') {
                        start[1] += num;
                        break;
                    };
                }
            } else if (direction == 'S') {
                if (start[0] + num > H - 1) {
                    continue;
                }
                
                start[0] += num;
                
                for (int j = start[0] - num; j <= start[0]; j++) {
                    if (park[j].charAt(start[1]) == 'X') {
                        start[0] -= num;
                        break;
                    };
                }
            } else {
                if (start[0] - num < 0) {
                    continue;
                }
                
                start[0] -= num;
                
                for (int j = start[0]; j <= start[0] + num; j++) {
                    if (park[j].charAt(start[1]) == 'X') {
                        start[0] += num;
                        break;
                    };
                }
            }
        }

        return start;
    }

    private int[] getStartPosition(String[] park) {
        for (int i = 0; i < park.length; i++) {
            for (int j = 0; j < park[i].length(); j++) {
                char c = park[i].charAt(j);

                if ('S' == c) {
                    return new int[]{i, j};
                }
            }
        }

        return new int[]{0, 0};
    }
}