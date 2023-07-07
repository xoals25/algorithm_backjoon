class Solution {
    public int solution(int[][] sizes) {
        int prevMax = 0;
        int prevMin = 0;
        
        for (int[] size: sizes) {
            int curMax = Math.max(size[0], size[1]);
            int curMin = Math.min(size[0], size[1]);
            
            prevMax = Math.max(curMax, prevMax);
            prevMin = Math.max(curMin, prevMin);
        }
        
        return prevMax * prevMin;
    }
}