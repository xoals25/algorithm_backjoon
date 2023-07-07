class Solution {
    public int solution(int[][] sizes) {
        int prevMax = 0;
        int prevMin = 0;
        
        for (int[] size: sizes) {
            int curMax = Math.max(size[0], size[1]);
            int curMin = Math.min(size[0], size[1]);
            
            if (curMax > prevMax) {
                prevMax = curMax;
            }
            
            if (curMin > prevMin) {
                prevMin = curMin;
            }
        }
        
        
        return prevMax * prevMin;
    }
}