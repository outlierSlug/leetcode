import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Deque<Integer> stack = new ArrayDeque<>();  // holds the surviving asteroids in a single pass of the array

        for (int a : asteroids) {
            boolean alive = true;

            // Only an incoming left-moving asteroid can collide with a right-moving asteroid on top
            while (!stack.isEmpty() && a < 0 && stack.peek() > 0) {
                int diff = a + stack.peek();
                if (diff < 0) {
                    // Incoming is larger: destroy top, keep fighting
                    stack.pop();
                } else if (diff > 0) {
                    // Top is larger: destroy incoming
                    alive = false;
                    break;
                } else {
                    // Equal size: destroy both
                    stack.pop();
                    alive = false;
                    break;
                }
            }

            // If the incoming asteroid survived, push it onto the stack
            if (alive) {
                stack.push(a);
            }
        }

        // Convert the stack to an int[] (pops top first, so fill back to front)
        int[] result = new int[stack.size()];
        for (int i = stack.size() - 1; i >= 0; i--) {
            result[i] = stack.pop();
        }
        return result;
    }
}