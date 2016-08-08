package tree;

import java.util.Arrays;

class TrieNode {
    // Initialize your data structure here.
    boolean isLeaf;
    TrieNode[] children;
    
    public TrieNode() {
        isLeaf = false;
        children = new TrieNode[26];
        Arrays.fill(children, null);
    }
    
    public TrieNode getChild(char c) {
    	return children[c - 'a'];
    }
    
    public void addChild(char c) {
    	if(this.getChild(c) == null) {
    		this.children[c - 'a'] = new TrieNode();
    	}
    }
}

public class Trie {
	private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
    	TrieNode n = root;
        for(int i = 0; i < word.length(); i++) {
        	n.addChild(word.charAt(i));
        	n = n.getChild(word.charAt(i));
        }
        n.isLeaf = true;
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        TrieNode n = root;
        for(int i = 0; i < word.length(); i++) {
        	if(n.getChild(word.charAt(i)) == null)
        		return false;
        	n = n.getChild(word.charAt(i));
        }
        return n.isLeaf;
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
    	TrieNode n = root;
        for(int i = 0; i < prefix.length(); i++) {
        	if(n.getChild(prefix.charAt(i)) == null)
        		return false;
        	n = n.getChild(prefix.charAt(i));
        }
        return true;
    }
    
    
    public static void main(String[] args) {
    	Trie t = new Trie();
    	t.insert("cat");
    	t.insert("can");
    	t.insert("cow");
    	t.insert("dog");
    	t.insert("don");
    	
    	System.out.println(t.search("don"));
    	System.out.println(t.search("dawn"));
    	System.out.println(t.startsWith("cap"));
    }
}
