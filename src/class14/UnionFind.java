package class14;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;

public class UnionFind<E> {
    public static class Node<E> {
        E value;

        Node(E val) {
            value = val; // 5 -> Node(5)
        }
    }

    HashMap<E, Node<E>> nodes = new HashMap<>();
    HashMap<Node<E>, Node<E>> parent = new HashMap<>();
    HashMap<Node<E>, Integer> size = new HashMap<>();

    UnionFind(E[] list) {
        for (E e : list) {
            Node<E> cur = new Node<>(e);
            nodes.put(e, cur);
            parent.put(cur, cur);
            size.put(cur, 1);
        }
    }

    Node<E> find(E a) {
        Deque<Node<E>> stack = new LinkedList<>();
        Node<E> cur = nodes.get(a);
        while (parent.get(cur) != cur) {
            stack.push(cur);
            cur = parent.get(cur);
        }

        while (!stack.isEmpty()) {
            Node<E> pop = stack.pop();
            parent.put(pop,cur);
        }
        return cur;
    }

    boolean isSameSet(E a, E b) {
        return find(a) == find(b);
    }

    Node<E> union(E a, E b){
        Node<E> fa = find(a);
        Node<E> fb = find(b);
        if (fa != fb) {
            int sizea = size.get(nodes.get(a));
            int sizeb = size.get(nodes.get(b));
            int newSize = sizea + sizeb;
            Node<E> newHead = sizea >= sizeb ? fa : fb;
            Node<E> smallHead = newHead == fa ? fb : fa;
            size.put(newHead,newSize);
            parent.put(smallHead,newHead);
            size.remove(smallHead);
            return newHead;
        }
        else return fa;
    }

}
