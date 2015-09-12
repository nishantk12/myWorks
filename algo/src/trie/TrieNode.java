package trie;

public class TrieNode {
	public char value;
	public boolean isWord;
	public TrieNode[] trieNode= new TrieNode[26];
	public TrieNode(char val){ value = val; }
}
