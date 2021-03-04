/*
https://leetcode.com/problems/snapshot-array/
*/
import java.util.HashMap;
import java.util.Map;

class SnapshotArray {

    private Map<Integer, Integer> curr;
    private Map<Integer, Map<Integer, Integer>> snaps;

    public SnapshotArray(int length) {
        curr = new HashMap<>();
        snaps = new HashMap<>();
    }

    public void set(int index, int val) {
        curr.put(index, val);
    }

    public int snap() {
        int snapId = snaps.size();
        snaps.put(snapId, curr);
        curr = new HashMap<>(curr);
        return snapId;
    }

    public int get(int index, int snap_id) {
        Map<Integer, Integer> values = snaps.get(snap_id);
        if(values.containsKey(index))
            return snaps.get(snap_id).get(index);
        return 0;
    }
}

/**
 * Your SnapshotArray object will be instantiated and called as such:
 * SnapshotArray obj = new SnapshotArray(length);
 * obj.set(index,val);
 * int param_2 = obj.snap();
 * int param_3 = obj.get(index,snap_id);
 */