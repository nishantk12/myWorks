package trie;

public class Trie {
	public TrieNode root = null;
	public Trie(TrieNode root){
		this.root = root;
	}
	
	public void insert(String word){
		if(root == null) return;
		if(word.length() == 0) return;
		for(int i=0;i<word.length();i++){
			char c = word.charAt(i);
			if(root.trieNode[c-'a']!=null){
				root = root.trieNode[c-'a'];
			}else{
				TrieNode temp = new TrieNode(c);
				root.trieNode[c-'a'] = temp;
				root = root.trieNode[c-'a'];
			}
			if(i==word.length()-1){
				root.isWord=true;
			}
		}
	}
	
	public boolean search(String word){
		if(root == null || word == null) return false;
		if(word.length() == 0) return false;
		for(int i=0;i<word.length();i++){
			char c = word.charAt(i);
			if(root.trieNode[c-'a'] != null){
				root = root.trieNode[c-'a'];
			}else{
				return false;
			}
			if(i==word.length()-1 && root.isWord==false){
				return false;
			}
		}
		return true;
	}
}
