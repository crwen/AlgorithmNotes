import java.util.HashMap;

class WordDictionary {

    private class Node {
        private boolean isWord;
        private HashMap<Character, Node> next;
        public Node(boolean isWord) {
            this.isWord = isWord;
            next = new HashMap<>();
        }
        public Node() {
            this(false);
        }
    }

    private Node root;


    /** Initialize your data structure here. */
    public WordDictionary() {
        this.root = new Node();
    }

    /** Adds a word into the data structure. */
    public void addWord(String word) {
        Node cur = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (cur.next.get(c) == null) {
                // 如果没有
                cur.next.put(c, new Node());
            }
            cur = cur.next.get(c);
        }
        if (!cur.isWord) {
            cur.isWord = true;
        }
    }

    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {

        return match(root, word, 0);
    }


    private boolean match(Node node, String word, int index){

        if(index == word.length())
            return node.isWord;

        char c = word.charAt(index);

        if(c != '.'){
            if(node.next.get(c) == null)
                return false;
            return match(node.next.get(c), word, index + 1);
        }
        else{
            for(char nextChar: node.next.keySet())
                if(match(node.next.get(nextChar), word, index + 1))
                    return true;
            return false;
        }
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */