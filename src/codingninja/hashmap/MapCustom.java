package codingninja.hashmap;

import java.util.ArrayList;

public class MapCustom<K, V> {

    private ArrayList<MapNode<K, V>> buckets;
    private int count;
    private int numBuckets;

    public MapCustom() {
        buckets = new ArrayList<>();
        numBuckets = 20;
        for (int i = 0; i < numBuckets; i++) buckets.add(i, null);
    }

    public int getCount() {
        return count;
    }

    private int getHashCode(K key) {
        int hashKey = key.hashCode();
        return hashKey % numBuckets;
    }

    void print() {
        System.out.println(buckets);
    }

    public V search(K key) {
        System.out.print("search: ");
        int bucketIndex = getHashCode(key);
        MapNode<K, V> head = buckets.get(bucketIndex);
        while (head != null) {
            if (head.key.equals(key))
                return head.value;
            head = head.next;
        }
        return null;
    }

    public V delete(K key) {
        System.out.print("DELETE: ");
        try {
            int bucketIndex = getHashCode(key);
            MapNode<K, V> head = buckets.get(bucketIndex);
            MapNode<K, V> prev = null;
            while (head != null) {
                if (head.key.equals(key)) {
                    if (prev == null) {
                        buckets.set(bucketIndex, head.next);
                    } else {
                        prev.next = head.next;
                    }
                    return head.value;
                }
                prev = head;
                head = head.next;
            }
            return null;
        } finally {
            print();
        }
    }

    public void insert(K key, V value) {
        int bucketIndex = getHashCode(key);
        MapNode<K, V> head = buckets.get(bucketIndex);
        while (head != null) {
            //  check if key is present then update it
            if (head.key.equals(key)) {
                head.value = value;
                print();
                return;
            }
            head = head.next;
        }
        //  otherwise add new key value in list.
        head = buckets.get(bucketIndex);
        MapNode<K, V> newNode = new MapNode<>(key, value);
        newNode.next = head;
        buckets.set(bucketIndex, newNode);
        count++;
        print();
    }
}
