package lab9;

import java.util.*;

/**
 *  A hash table-backed Map implementation. Provides amortized constant time
 *  access to elements via get(), remove(), and put() in the best case.
 *
 *  @author Xueyi Wang
 */
public class MyHashMap<K, V> implements Map61B<K, V> {

    private static final int DEFAULT_SIZE = 16;
    private static final double MAX_LF = 0.75;

    private ArrayMap<K, V>[] buckets;
    private int size;
    private int maxSize;
    private Set<K> keys;

    private int loadFactor() {
        return size / buckets.length;
    }

    public MyHashMap() {
        buckets = new ArrayMap[DEFAULT_SIZE];
        this.clear();
    }

    /* Removes all of the mappings from this map. */
    @Override
    public void clear() {
        this.size = 0;
        maxSize = DEFAULT_SIZE;
        keys = new TreeSet<>();
        for (int i = 0; i < this.buckets.length; i += 1) {
            this.buckets[i] = new ArrayMap<>();
        }
    }

    /** Computes the hash function of the given key. Consists of
     *  computing the hashcode, followed by modding by the number of buckets.
     *  To handle negative numbers properly, uses floorMod instead of %.
     */
    private int hash(K key) {
        if (key == null) {
            return 0;
        }

        int numBuckets = buckets.length;
        return Math.floorMod(key.hashCode(), numBuckets);
    }

    /* Returns the value to which the specified key is mapped, or null if this
     * map contains no mapping for the key.
     */
    @Override
    public V get(K key) {
        int hashCode = hash(key);
        return buckets[hashCode].get(key);
    }

    /* Associates the specified value with the specified key in this map. */
    @Override
    public void put(K key, V value) {
        int hashCode = hash(key);
        if (get(key) == null) {
            size += 1;
        }
        buckets[hashCode].put(key, value);
        keys.add(key);
        if (loadFactor() > MAX_LF) {
            resize();
        }
    }

    private void resize() {
        maxSize = maxSize * 2;
        ArrayMap<K, V>[] newBuckets = new ArrayMap[maxSize];
        for (int i = 0; i < maxSize; i += 1) {
            newBuckets[i] = new ArrayMap<>();
        }
        Iterator<K> bucketIterator = iterator();
        while (bucketIterator.hasNext()) {
            K key = bucketIterator.next();
            int newHashCode = newHash(key);
            V val = get(key);
            newBuckets[newHashCode].put(key, val);
        }
        buckets = newBuckets;
    }

    private int newHash(K key) {
        if (key == null) {
            return 0;
        }
        int numBuckets = maxSize;
        return Math.floorMod(key.hashCode(), numBuckets);
    }

    /* Returns the number of key-value mappings in this map. */
    @Override
    public int size() {
        return size;
    }

    //////////////// EVERYTHING BELOW THIS LINE IS OPTIONAL ////////////////

    /* Returns a Set view of the keys contained in this map. */
    @Override
    public Set<K> keySet() {
        return keys;
    }

    /* Removes the mapping for the specified key from this map if exists.
     * Not required for this lab. If you don't implement this, throw an
     * UnsupportedOperationException. */
    @Override
    public V remove(K key) {
        throw new UnsupportedOperationException();
    }

    /* Removes the entry for the specified key only if it is currently mapped to
     * the specified value. Not required for this lab. If you don't implement this,
     * throw an UnsupportedOperationException.*/
    @Override
    public V remove(K key, V value) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Iterator<K> iterator() {
        return new HashMapIterator(maxSize);
    }

    private class HashMapIterator<K> implements Iterator<K> {
        private int wizPos;
        private K[] keyAll;

        public HashMapIterator(int length) {
            wizPos = 0;
            getKey();
        }

        public boolean hasNext() {
            return wizPos < size;
        }

        private void getKey() {
            keyAll = (K[]) keySet().toArray();
        }

        public K next() {
            K returnItem = keyAll[wizPos];
            wizPos += 1;
            return returnItem;
        }
    }

    public static void main (String args[]) {
        int[] a = new int[]{1,2,3};
        System.out.println(a.length);
    }
}
