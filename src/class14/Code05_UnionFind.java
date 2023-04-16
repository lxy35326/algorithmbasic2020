
package class14;

import java.util.HashMap;
import java.util.List;
import java.util.Stack;

// 课上讲的并查集实现
// 请务必看补充的Code06_UnionFind
// 那是数组实现的并查集，并且有测试链接
// 可以直接通过
// 这个文件的并查集是用map实现的
// 但是笔试或者平时用的并查集一律用数组实现
// 所以Code06_UnionFind更具实战意义
// 一定要看！
public class Code05_UnionFind {

	public static class Node<V> {
		V value;

		public Node(V v) {
			value = v;
		}
	}

	public static class UnionFind<V> {
		public HashMap<V, Node<V>> nodes;
		public HashMap<Node<V>, Node<V>> parents;
		public HashMap<Node<V>, Integer> sizeMap;

		public UnionFind(List<V> values) {
			nodes = new HashMap<>();
			parents = new HashMap<>();
			sizeMap = new HashMap<>();
			for (V cur : values) {
				Node<V> node = new Node<>(cur);
				nodes.put(cur, node);
				parents.put(node, node);
				sizeMap.put(node, 1);
			}
		}

		// 给你一个节点，请你往上到不能再往上，把代表返回
		public Node<V> findFather(Node<V> cur) {
			Stack<Node<V>> path = new Stack<>();
			while (cur != parents.get(cur)) {
				path.push(cur);
				cur = parents.get(cur);
			}
			while (!path.isEmpty()) {
				parents.put(path.pop(), cur);
			}
			return cur;
		}

		public boolean isSameSet(V a, V b) {
			return findFather(nodes.get(a)) == findFather(nodes.get(b));
		}

		public void union(V a, V b) {
			Node<V> aHead = findFather(nodes.get(a));
			Node<V> bHead = findFather(nodes.get(b));
			if (aHead != bHead) {
				int aSetSize = sizeMap.get(aHead);
				int bSetSize = sizeMap.get(bHead);
				Node<V> big = aSetSize >= bSetSize ? aHead : bHead;
				Node<V> small = big == aHead ? bHead : aHead;
				parents.put(small, big);
				sizeMap.put(big, aSetSize + bSetSize);
				sizeMap.remove(small);
			}
		}

		public int sets() {
			return sizeMap.size();
		}

	}
}

//package class14;
//
//import java.util.HashMap;
//import java.util.List;
//import java.util.Stack;
//
//// 课上讲的并查集实现
//// 请务必看补充的Code06_UnionFind
//// 那是数组实现的并查集，并且有测试链接
//// 可以直接通过
//// 这个文件的并查集是用map实现的
//// 但是笔试或者平时用的并查集一律用数组实现
//// 所以Code06_UnionFind更具实战意义
//// 一定要看！
//public class Code05_UnionFind {
//
//	// 课上讲的时候
//	// 包了一层
//	// 其实不用包一层哦
//	public static class UnionFind<V> {
//		public HashMap<V, V> father;
//		public HashMap<V, Integer> size;
//
//		public UnionFind(List<V> values) {
//			father = new HashMap<>();
//			size = new HashMap<>();
//			for (V cur : values) {
//				father.put(cur, cur);
//				size.put(cur, 1);
//			}
//		}
//
//		// 给你一个节点，请你往上到不能再往上，把代表返回
//		public V findFather(V cur) {
//			Stack<V> path = new Stack<>();
//			while (cur != father.get(cur)) {
//				path.push(cur);
//				cur = father.get(cur);
//			}
//			while (!path.isEmpty()) {
//				father.put(path.pop(), cur);
//			}
//			return cur;
//		}
//
//		public boolean isSameSet(V a, V b) {
//			return findFather(a) == findFather(b);
//		}
//
//		public void union(V a, V b) {
//			V aFather = findFather(a);
//			V bFather = findFather(b);
//			if (aFather != bFather) {
//				int aSize = size.get(aFather);
//				int bSize = size.get(bFather);
//				if (aSize >= bSize) {
//					father.put(bFather, aFather);
//					size.put(aFather, aSize + bSize);
//					size.remove(bFather);
//				} else {
//					father.put(aFather, bFather);
//					size.put(bFather, aSize + bSize);
//					size.remove(aFather);
//				}
//			}
//		}
//
//		public int sets() {
//			return size.size();
//		}
//
//	}
//}
//>>>>>>> 5e910b1c49a590b7d1a94c8e9004274af4fea7fd
