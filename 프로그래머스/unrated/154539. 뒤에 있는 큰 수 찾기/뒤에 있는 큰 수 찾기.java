import java.util.Stack;

class Solution {
    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
    
        Stack<Integer> st = new Stack<>();
        
        for (int i = 0; i < numbers.length; i++) {
            if (st.isEmpty()) {
                st.push(i);
                continue;
            }
            
            while (!st.isEmpty() && numbers[st.peek()] < numbers[i]) {
                int index = st.pop();
                
                answer[index] = numbers[i];
            }
            
            st.push(i);
        }
        
        while(!st.isEmpty()) {
            int index = st.pop();
            
            answer[index] = -1;
        }
        
        return answer;
    }
}