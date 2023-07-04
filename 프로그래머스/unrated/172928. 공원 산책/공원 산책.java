import java.util.*;

class Solution {
    public int[] solution(String[] park, String[] routes) {
        int[] start = getStartPosition(park);
        
        Map<Character, int[]> map = new HashMap<>();
        
        map.put('E', new int[]{0, 1});
        map.put('W', new int[]{0, -1});
        map.put('S', new int[]{1, 0});
        map.put('N', new int[]{-1, 0});
        
        for (String route: routes) {
            char direction = route.charAt(0);
            int moveCount = route.charAt(2) - '0';
            
            int[] dxdy = map.get(direction);
            
            int dx = dxdy[0];
            int dy = dxdy[1];
            
            int curX = start[0];
            int curY = start[1];
            
            boolean isOk = true;
            
            for (int i = 0; i < moveCount; i++) {
                curX += dx;
                curY += dy;
                
                if (curX < 0 || curY < 0 || curX > park.length - 1 || curY > park[0].length() - 1) {
                    isOk = false;
                    break;
                }
                
                if (park[curX].charAt(curY) == 'X') {
                    isOk = false;
                    break;
                }
            }
            
            if (isOk) {
                start[0] = curX;
                start[1] = curY;
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