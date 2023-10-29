import java.util.Stack;

class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;

        Stack<Integer> deliveryStack = new Stack<>();
        Stack<Integer> pickupStack = new Stack<>();

        for (int i = 0; i < n; i++) {
            if (deliveries[i] != 0) {
                deliveryStack.push(i);                
            }

            if (pickups[i] != 0) {
                pickupStack.push(i);  
            }
        }

        int deliveryLength = 0;
        int pickupLength = 0;
        int deliveryCap = cap;
        int pickupCap = cap;

        while (!deliveryStack.isEmpty() || !pickupStack.isEmpty()) {
            deliveryLength = !deliveryStack.isEmpty() ? deliveryStack.peek() + 1 : deliveryLength;

            while (!deliveryStack.isEmpty()) {
                int delivery = deliveryStack.pop();

                if (deliveryCap - deliveries[delivery] > 0) {
                    deliveryCap -= deliveries[delivery];
                    continue;
                } 
                
                if (deliveryCap - deliveries[delivery] == 0) {
                    deliveryCap = 0;
                    break;
                }
                
                deliveries[delivery] -= deliveryCap;
                deliveryStack.push(delivery);
                deliveryCap = 0;
                break;
            }

            pickupLength = !pickupStack.isEmpty() ? pickupStack.peek() + 1 : pickupLength;

            while (!pickupStack.isEmpty()) {
                int pickup = pickupStack.pop();

                if (pickupCap - pickups[pickup] > 0) {
                    pickupCap -= pickups[pickup];
                    continue;
                }
                
                if (pickupCap - pickups[pickup] == 0) {
                    pickupCap = 0;
                    break;
                }
                
                pickups[pickup] -= pickupCap;
                pickupStack.push(pickup);
                pickupCap = 0;
                break;
            }

            answer += 2 * Math.max(pickupLength, deliveryLength);
            pickupLength = 0;
            deliveryLength = 0;
            deliveryCap = cap;
            pickupCap = cap;
        }

        return answer;
    }
}