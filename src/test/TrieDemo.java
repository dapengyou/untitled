package test;

/**
 * @date 创建时间: 2019/3/18
 * @author  lady_zhou
 * @Description  trie 树
 */
class Trie {
    private TrieNode root = new TrieNode('/'); // 存储无意义字符

    // 往 TrieDemo 树中插入一个字符串
    public void insert(String words) {
        TrieNode p = root;
        char[] text = words.toCharArray();
        for (int i = 0; i < text.length; ++i) {
            int index = text[i] - 'a';
            if (p.children[index] == null) {
                TrieNode newNode = new TrieNode(text[i]);
                p.children[index] = newNode;
            }
            p = p.children[index];
        }
        p.isEndingChar = true;
    }

    // 在 TrieDemo 树中查找一个字符串
    public boolean find(String words) {
        TrieNode p = root;
        char[] pattern = words.toCharArray();
        for (int i = 0; i < pattern.length; ++i) {
            int index = pattern[i] - 'a';
            if (p.children[index] == null) {
                return false; // 不存在 pattern
            }
            p = p.children[index];
        }
//        if (p.isEndingChar == false) return false; // 不能完全匹配，只是前缀
//        else return true; // 找到 pattern
        return p.isEndingChar;
    }

    public class TrieNode {
        public char data;
        public TrieNode[] children = new TrieNode[26];
        public boolean isEndingChar = false;

        public TrieNode(char data) {
            this.data = data;
        }
    }
}

public class TrieDemo {
    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("title");
        trie.insert("hi");
        trie.insert("hello");
        trie.insert("with");
        trie.insert("name");

       boolean isFind = trie.find("hello");
        if(isFind){
             System.out.println("匹配到了");
        }else{
             System.out.println("未匹配到");
        }

    }
}
