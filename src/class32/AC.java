package class32;

import class23.N;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AC {
    static class Node {
        Node[] next;
        Node fail;
        boolean endUse;
        String end;

        public Node() {
            endUse = false;
            end = null;
            fail = null;
            next = new Node[26];
        }
    }

    static class ACAutomation {
        Node root;

        ACAutomation() {
            root = new Node();
        }

        void insert(String s) {
            char[] str = s.toCharArray();
            Node cur = root;
            int index = 0;
            for (int i = 0; i < str.length; i++) {
                index = str[i] - 'a';
                if (cur.next[index] == null) {
                    cur.next[index] = new Node();
                }
                cur = cur.next[index];
            }
            cur.end = s;
        }

        void build() {
            Queue<Node> queue = new LinkedList<>();
            queue.offer(root);
            Node cfail = null;
            Node cur = null;
            while (!queue.isEmpty()) {
                cur = queue.poll();
                for (int i = 0; i < 26; i++) {
                    if (cur.next[i] != null) {
                        cur.next[i].fail = root;
                        cfail = cur.fail;
                        while (cfail != null) {
                            if (cfail.next[i] != null) {
                                /////???????????????????????????????????????????
                                cur.next[i].fail = cfail.next[i];
                                break;
                            }
                            cfail = cfail.fail;
                        }
                        queue.add(cur.next[i]);
                    }
                }
            }

//            Queue<Node> queue = new LinkedList<>();
//            queue.add(root);
//            Node cur = null;
//            Node cfail = null;
//            while (!queue.isEmpty()) {
//                // 某个父亲，cur
//                cur = queue.poll();
//                for (int i = 0; i < 26; i++) { // 所有的路
//                    // cur -> 父亲  i号儿子，必须把i号儿子的fail指针设置好！
//                    if (cur.next[i] != null) { // 如果真的有i号儿子
//                        cur.next[i].fail = root;
//                        cfail = cur.fail;
//                        while (cfail != null) {
//                            if (cfail.next[i] != null) {
//                                cur.next[i].fail = cfail.next[i];
//                                break;
//                            }
//                            cfail = cfail.fail;
//                        }
//                        queue.add(cur.next[i]);
//                    }
//                }
//            }
        }


        public List<String> containsWords(String content) {
            char[] article = content.toCharArray();
            int len = article.length;
            List<String> ans = new LinkedList<>();
            Node cur = root;
            Node follow = null;
            for (int i = 0; i < len; i++) {
                int index = article[i] - 'a';
                // 如果当前字符在这条路上没配出来，就随着fail方向走向下条路径
                while (cur.next[index] == null && cur != root) {
                    //如果匹配不下去了且当前不是根结点，就往fail跳。 直到当前是根结点，或者可以继续往下匹配了
                    cur = cur.fail;
                }
                cur = cur.next[index] != null ? cur.next[index] : root;
                follow = cur;
                while (follow != root) {
                    if (follow.endUse) {
                        break;
                    }
                    if (follow.end != null) {
                        ans.add(follow.end);
                        follow.endUse = true;
                    }

                    follow = follow.fail;
                }
            }
            return ans;
        }
    }


    public static void main(String[] args) {
        ACAutomation ac = new ACAutomation();
        ac.insert("dhe");
        ac.insert("he");
        ac.insert("abcdheks");
        // 设置fail指针
        ac.build();

        List<String> contains = ac.containsWords("abcdhekskdjfafhasldkflskdjhwqaeruv");
        for (String word : contains) {
            System.out.println(word);
        }
    }
}