import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.List;

class Solution {
    public String simplifyPath(String path) {
        Deque<String> stack = new ArrayDeque<>();
        String[] tokens = path.split("/");

        for (String token : tokens) {
            if (token.equals("") || token.equals(".")) {
                continue;
            } else if (token.equals("..")) {
                if (stack.peek() != null) {
                    stack.pop();
                }
            } else {
                stack.push(token);
            }
        }
        List<String> list = new ArrayList<>(stack);
        Collections.reverse(list);
        return "/" + String.join("/", list);
    }
}