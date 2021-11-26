package hw3.hash;

import java.util.IdentityHashMap;
import java.util.List;
import java.util.Map;

public class OomageTestUtility {
    public static boolean haveNiceHashCodeSpread(List<Oomage> oomages, int M) {
        Map<Integer, Integer> hcs = new IdentityHashMap<>();
        int len = oomages.size();
        for (Oomage o : oomages) {
            int oHashCode = o.hashCode();
            int bucketNum = (oHashCode & 0x7FFFFFFF) % M;
            if (!hcs.containsKey(bucketNum)) {
                hcs.put(bucketNum, 1);
            } else {
                int oldV = hcs.get(bucketNum);
                hcs.replace(bucketNum, oldV + 1);
            }
        }
        for (int K : hcs.keySet()) {
            int V = hcs.get(K);
            if (V < len / 50 || V > len / 2.5) {
                return false;
            }
        }
        return true;
    }
}
