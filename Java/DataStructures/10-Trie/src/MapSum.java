import java.util.HashMap;

class MapSum {

    private class Node {
        private int value;
        private HashMap<Character, Node> next;
        public Node(int value) {
            this.value = value;
            next = new HashMap<>();
        }
        public Node() {
            this(0);
        }
    }

    private Node root;

    /** Initialize your data structure here. */
    public MapSum() {
        root = new Node();
    }
    
    public void insert(String key, int val) {
        Node cur = root;
        for (int i = 0; i < key.length(); i++) {
            char ch = key.charAt(i);
            if (cur.next.get(ch) == null) {
                // 如果没有
                cur.next.put(ch, new Node());
            }
            cur = cur.next.get(ch);
        }
        cur.value = val;
    }
    
    public int sum(String prefix) {
        Node cur = root;
        for (int i = 0; i < prefix.length(); i++) {
            char ch = prefix.charAt(i);
            if (cur.next.get(ch) == null)
                return 0;
            cur = cur.next.get(ch);
        }
        return sum(cur);
    }

    private int sum(Node node) {
        int res = node.value;
        for (char ch : node.next.keySet()) {
            res += sum(node.next.get(ch));
        }
        return res;
    }
}

/**
 * Your MapSum object will be instantiated and called as such:
 * MapSum obj = new MapSum();
 * obj.insert(key,val);
 * int param_2 = obj.sum(prefix);
 */