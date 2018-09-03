package leetCode200;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class P208ImplementTrie {
	// Ç°×ºÊ÷
}

class Trie {
	TrieNode root;

	/** Initialize your data structure here. */
	public Trie() {
		root = new TrieNode('$', new HashMap<>());
	}

	/** Inserts a word into the trie. */
	public void insert(String word) {
		char[] ch = word.toCharArray();

		TrieNode curr = root;
		Map<Character, TrieNode> childs = curr.childs;
		for (int i = 0; i < word.length(); i++) {
			childs.putIfAbsent(ch[i], new TrieNode(ch[i], new HashMap<>()));
			curr = childs.get(ch[i]);
			childs = curr.childs;
		}
		childs.putIfAbsent('#', new TrieNode('#', null));
	}

	/** Returns if the word is in the trie. */
	public boolean search(String word) {
		char[] ch = word.toCharArray();
		TrieNode curr = root;
		Map<Character, TrieNode> childs = curr.childs;

		for (int i = 0; i < word.length(); i++) {
			TrieNode child;
			if ((child = childs.get(ch[i])) != null) {
				childs = child.childs;
			} else {
				return false;
			}
		}
		if (childs.containsKey('#'))
			return true;
		else
			return false;
	}

	/**
	 * Returns if there is any word in the trie that starts with the given
	 * prefix.
	 */
	public boolean startsWith(String prefix) {
		char[] ch = prefix.toCharArray();
		TrieNode curr = root;
		Map<Character, TrieNode> childs = curr.childs;

		for (int i = 0; i < prefix.length(); i++) {
			TrieNode child;
			if ((child = childs.get(ch[i])) != null) {
				childs = child.childs;
			} else {
				return false;
			}
		}
		return true;
	}

	class TrieNode {
		char var;
		Map<Character, TrieNode> childs;

		public TrieNode(char var, Map<Character, TrieNode> childs) {
			super();
			this.var = var;
			this.childs = childs;
		}

		boolean equals(TrieNode other) {
			return this.var == other.var && Objects.equals(childs, other.childs);
		}

		@Override
		public int hashCode() {
			// TODO Auto-generated method stub
			return Objects.hash(var, childs);
		}

	}
}