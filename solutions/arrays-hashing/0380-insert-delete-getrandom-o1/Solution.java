import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

class RandomizedSet {
    private final Map<Integer, Integer> map;
    private final List<Integer> list;
    private final Random rand;

    public RandomizedSet() {
        this.map = new HashMap<>();
        this.list = new ArrayList<>();
        this.rand = new Random();
    }
    
    public boolean insert(int val) {
        if (map.containsKey(val)) return false;

        // Append the value to the list and map
        list.add(val);
        map.put(val, list.size() - 1);
        return true;
    }
    
    public boolean remove(int val) {
        if (!map.containsKey(val)) return false;

        // Move the last element in the list to the index of the value to remove
        int idx = map.get(val);
        int lastVal = list.get(list.size() - 1);
        list.set(idx, lastVal);
        list.remove(list.size() - 1);
        map.put(lastVal, idx);
        map.remove(val);  // must come after put
        return true;
    }
    
    public int getRandom() {
        int idx = rand.nextInt(list.size());
        return list.get(idx);
    }
}