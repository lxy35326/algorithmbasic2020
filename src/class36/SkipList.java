package class36;

import java.util.ArrayList;

public class SkipList<K extends Comparable<K>, V> {
    int size;
    SkipNode<K, V> root = new SkipNode<>(null, null);
    static final float PROBABILITY = 0.5f;
    int maxLevel;

    {
        root.next.add(null);
        maxLevel = 0;
        size = 0;
    }

    private SkipNode<K, V> mostRightLessNodeInLevel(SkipNode<K, V> node, K key, int level) {
        SkipNode<K, V> cur = node.next.get(level), ans = node;
        while (cur != null) {
            if (cur.isKeyLess(key)) {
                ans = cur;
                cur = cur.next.get(level);
            } else break;
        }
        return ans;
    }

    private SkipNode<K, V> mostRightLessNodeInTree(K key) {
        if (size == 0) return null;
        if (key == null) return null;
        SkipNode<K, V> mostRight = root;
        //mostRight一定不为空
        int level = maxLevel;
        while (level >= 0) {
            mostRight = mostRightLessNodeInLevel(mostRight, key, level--);
        }
        return mostRight;
    }

    public boolean containsKey(K key) {
        if (key == null) return false;
        SkipNode<K, V> mostRight = mostRightLessNodeInTree(key);
        SkipNode<K, V> kvSkipNode = mostRight.next.get(0);
        return kvSkipNode != null && kvSkipNode.isKeyEqual(key);
    }

    static class SkipNode<K extends Comparable<K>, V> {
        ArrayList<SkipNode<K, V>> next = new ArrayList<>();
        K key;
        V value;

        SkipNode(K key, V value) {
            this.key = key;
            this.value = value;
        }

        boolean isKeyLess(K other) {
            return other != null && (key == null || key.compareTo(other) < 0);
        }

        boolean isKeyEqual(K other) {
            return other == null && key == null || key != null && other != null && key.compareTo(other) == 0;
        }
    }

    public void put(K key, V value) {
        if (key == null) return;

        SkipNode<K,V> mostRight = mostRightLessNodeInTree(key);
        SkipNode<K,V> ans = mostRight.next.get(0);
        if (ans != null && ans.isKeyEqual(key)) {
            ans.value = value;
        } else {
            size++;
            int level = 0;
            while (Math.random() < PROBABILITY) {
                level++;
            }
            SkipNode<K, V> newNode = new SkipNode<>(key, value);
            for (int i = 0; i < level; i++) {
                newNode.next.add(null);
            }
            while (level > maxLevel) {
                maxLevel++;
                root.next.add(null);
            }
            int temp = maxLevel;
            ans = root;
            while (temp >= 0) {
                ans = mostRightLessNodeInLevel(ans,key,temp);
                if (temp <= level) {
                    newNode.next.set(temp,ans.next.get(temp));
                    ans.next.set(temp, newNode);
                }
                temp--;
            }
        }

    }

    public V get(K key){
        if (size == 0 || key == null) return null;
        SkipNode<K,V> right = mostRightLessNodeInTree(key);
        SkipNode<K,V> next = right.next.get(0);
        if (next != null && next.isKeyEqual(key)){
            return next.value;
        }
        return null;
    }

    public void remove(K key) {
        if (key == null || size == 0) return;
        SkipNode<K, V> right = mostRightLessNodeInTree(key);
        SkipNode<K, V> next = right.next.get(0);
        if (next == null || !next.isKeyEqual(key)) {
            return;
        }
        size--;
        int level = maxLevel;
        SkipNode<K,V> cur = root;
        while (level >= 0) {
             right = mostRightLessNodeInLevel(cur, key, level);
             next = right.next.get(level);
             if (next != null && next.isKeyEqual(key)) {
                 right.next.set(level,next.next.get(level));
             }
             if (level != 0 && right == root && right.next.get(level) == null) {
                 maxLevel--;
                 root.next.remove(level);
             }
            level--;

        }
    }
    public static void main(String[] args) {
        SkipList<Integer, Integer> integerIntegerSkipList = new SkipList<>();

    }
}
