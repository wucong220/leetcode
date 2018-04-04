package leetCode100;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class P126WordLadderII_T {

	//https://leetcode.com/problems/word-ladder-ii/discuss/40475/My-concise-JAVA-solution-based-on-BFS-and-DFS
	public List<List<String>> findLadders(String start, String end, List<String> wordList) {
		   HashSet<String> dict = new HashSet<String>(wordList);
		   List<List<String>> res = new ArrayList<List<String>>();         
		   HashMap<String, ArrayList<String>> nodeNeighbors = new HashMap<String, ArrayList<String>>();// Neighbors for every node
		   HashMap<String, Integer> distance = new HashMap<String, Integer>();// Distance of every node from the start node
		   ArrayList<String> solution = new ArrayList<String>();

		   dict.add(start);          
		   bfs(start, end, dict, nodeNeighbors, distance);                 
		   dfs(start, end, dict, nodeNeighbors, distance, solution, res);   
		   return res;
		}

		// BFS: Trace every node's distance from the start node (level by level).
		private void bfs(String start, String end, Set<String> dict, HashMap<String, ArrayList<String>> nodeNeighbors, HashMap<String, Integer> distance) {
		  for (String str : dict)
		      nodeNeighbors.put(str, new ArrayList<String>());

		  Queue<String> queue = new LinkedList<String>();
		  queue.offer(start);
		  distance.put(start, 0);

		  while (!queue.isEmpty()) {
		      int count = queue.size();
		      boolean foundEnd = false;
		      for (int i = 0; i < count; i++) {
		          String cur = queue.poll();
		          int curDistance = distance.get(cur);                
		          ArrayList<String> neighbors = getNeighbors(cur, dict);

		          for (String neighbor : neighbors) {
		              nodeNeighbors.get(cur).add(neighbor);
		              if (!distance.containsKey(neighbor)) {// Check if visited
		                  distance.put(neighbor, curDistance + 1);
		                  if (end.equals(neighbor))// Found the shortest path
		                      foundEnd = true;
		                  else
		                      queue.offer(neighbor);
		                  }
		              }
		          }

		          if (foundEnd)
		              break;
		      }
		  }

		// Find all next level nodes.    
		private ArrayList<String> getNeighbors(String node, Set<String> dict) {
		  ArrayList<String> res = new ArrayList<String>();
		  char chs[] = node.toCharArray();

		  for (char ch ='a'; ch <= 'z'; ch++) {
		      for (int i = 0; i < chs.length; i++) {
		          if (chs[i] == ch) continue;
		          char old_ch = chs[i];
		          chs[i] = ch;
		          if (dict.contains(String.valueOf(chs))) {
		              res.add(String.valueOf(chs));
		          }
		          chs[i] = old_ch;
		      }

		  }
		  return res;
		}

		// DFS: output all paths with the shortest distance.
		private void dfs(String cur, String end, Set<String> dict, HashMap<String, ArrayList<String>> nodeNeighbors, HashMap<String, Integer> distance, ArrayList<String> solution, List<List<String>> res) {
		    solution.add(cur);
		    if (end.equals(cur)) {
		       res.add(new ArrayList<String>(solution));
		    } else {
		       for (String next : nodeNeighbors.get(cur)) {            
		            if (distance.get(next) == distance.get(cur) + 1) {
		                 dfs(next, end, dict, nodeNeighbors, distance, solution, res);
		            }
		        }
		    }           
		   solution.remove(solution.size() - 1);
		}
		
		
		
//		
//	static public List<Set<String>> findWords(String target, String endWord, Set<String> wordList) {
//		List<Set<String>> ret = new ArrayList<>();
//		Set<String> ret1 = new HashSet<>();
//		Set<String> ret2 = new HashSet<>(wordList);
//		boolean flag = false;
//		char chs[] = target.toCharArray();
//		
//		for (char ch = 'a'; ch <= 'z'; ch++) {
//			for (int i = 0; i < chs.length; i++) {
//				if (chs[i] == ch)
//					continue;
//				char old_ch = chs[i];
//				chs[i] = ch;
//				if (ret2.contains(String.valueOf(chs))) {
//					ret1.add(String.valueOf(chs));
//					if(String.valueOf(chs).equals(endWord))flag=true;
//					ret2.remove(String.valueOf(chs));
//				}
//				chs[i] = old_ch;
//			}
//			//System.out.println(ret2);
//
//		}
//		ret.add(ret1);
//		ret.add(ret2);
//		if (flag)
//			ret.add(new HashSet<String>(1));
//		return ret;
//	}
//
//	static public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
//		boolean flag = false;
//		List<List<String>> ret = new ArrayList<>();
//		Queue<String> q = new LinkedList<>();
//		Queue<Set<String>> qw = new LinkedList<>();
//		Queue<List<String>> retp = new LinkedList<>();
//		q.offer(beginWord);
//		qw.offer(new HashSet<String>(wordList));
//		retp.offer(new ArrayList<String>(Arrays.asList(beginWord)));
//		while (!q.isEmpty()) {
//			String beginWord1 = q.poll();
//			Set<String> wordList1 = qw.poll();
//			List<String> retplist = retp.poll();
//			List<Set<String>> nextStep = findWords(beginWord1, endWord, wordList1);
//			if (nextStep.size() > 2) {
//				flag = true;
//				retplist.add(endWord);
//				ret.add(retplist);
//				
//			}
//			if (!flag) {
//				Set<String> nextbw = nextStep.get(0);
//				System.out.println(nextbw);
//				Set<String> nextwl = nextStep.get(1);
//				for (Iterator<String> i= nextbw.iterator();i.hasNext() ; ) {
//					String string =i.next();
//					List<String> retplistt = new ArrayList<>(retplist);
//					q.offer(string);
//					retplistt.add(string);
//					retp.offer(retplistt);
//					qw.offer(nextwl);
//				}
//			}
//		}
//		return ret;
//	}
//	// 感觉这道题用深度优先搜索就逃不出TLE。我觉得我应该考虑尝试使用一下我从也没有用过的广度优先搜索，利用一个队列实现。
//
//	public static void main(String[] args) {
//		String beginWord = "cet";
//		String endWord = "ism";
//		List<String> wordList = Arrays.asList(
//
//				"kid", "tag", "pup", "ail", "tun", "woo", "erg", "luz", "brr", "gay", "sip", "kay", "per", "val", "mes",
//				"ohs", "now", "boa", "cet", "pal", "bar", "die", "war", "hay", "eco", "pub", "lob", "rue", "fry", "lit",
//				"rex", "jan", "cot", "bid", "ali", "pay", "col", "gum", "ger", "row", "won", "dan", "rum", "fad", "tut",
//				"sag", "yip", "sui", "ark", "has", "zip", "fez", "own", "ump", "dis", "ads", "max", "jaw", "out", "btu",
//				"ana", "gap", "cry", "led", "abe", "box", "ore", "pig", "fie", "toy", "fat", "cal", "lie", "noh", "sew",
//				"ono", "tam", "flu", "mgm", "ply", "awe", "pry", "tit", "tie", "yet", "too", "tax", "jim", "san", "pan",
//				"map", "ski", "ova", "wed", "non", "wac", "nut", "why", "bye", "lye", "oct", "old", "fin", "feb", "chi",
//				"sap", "owl", "log", "tod", "dot", "bow", "fob", "for", "joe", "ivy", "fan", "age", "fax", "hip", "jib",
//				"mel", "hus", "sob", "ifs", "tab", "ara", "dab", "jag", "jar", "arm", "lot", "tom", "sax", "tex", "yum",
//				"pei", "wen", "wry", "ire", "irk", "far", "mew", "wit", "doe", "gas", "rte", "ian", "pot", "ask", "wag",
//				"hag", "amy", "nag", "ron", "soy", "gin", "don", "tug", "fay", "vic", "boo", "nam", "ave", "buy", "sop",
//				"but", "orb", "fen", "paw", "his", "sub", "bob", "yea", "oft", "inn", "rod", "yam", "pew", "web", "hod",
//				"hun", "gyp", "wei", "wis", "rob", "gad", "pie", "mon", "dog", "bib", "rub", "ere", "dig", "era", "cat",
//				"fox", "bee", "mod", "day", "apr", "vie", "nev", "jam", "pam", "new", "aye", "ani", "and", "ibm", "yap",
//				"can", "pyx", "tar", "kin", "fog", "hum", "pip", "cup", "dye", "lyx", "jog", "nun", "par", "wan", "fey",
//				"bus", "oak", "bad", "ats", "set", "qom", "vat", "eat", "pus", "rev", "axe", "ion", "six", "ila", "lao",
//				"mom", "mas", "pro", "few", "opt", "poe", "art", "ash", "oar", "cap", "lop", "may", "shy", "rid", "bat",
//				"sum", "rim", "fee", "bmw", "sky", "maj", "hue", "thy", "ava", "rap", "den", "fla", "auk", "cox", "ibo",
//				"hey", "saw", "vim", "sec", "ltd", "you", "its", "tat", "dew", "eva", "tog", "ram", "let", "see", "zit",
//				"maw", "nix", "ate", "gig", "rep", "owe", "ind", "hog", "eve", "sam", "zoo", "any", "dow", "cod", "bed",
//				"vet", "ham", "sis", "hex", "via", "fir", "nod", "mao", "aug", "mum", "hoe", "bah", "hal", "keg", "hew",
//				"zed", "tow", "gog", "ass", "dem", "who", "bet", "gos", "son", "ear", "spy", "kit", "boy", "due", "sen",
//				"oaf", "mix", "hep", "fur", "ada", "bin", "nil", "mia", "ewe", "hit", "fix", "sad", "rib", "eye", "hop",
//				"haw", "wax", "mid", "tad", "ken", "wad", "rye", "pap", "bog", "gut", "ito", "woe", "our", "ado", "sin",
//				"mad", "ray", "hon", "roy", "dip", "hen", "iva", "lug", "asp", "hui", "yak", "bay", "poi", "yep", "bun",
//				"try", "lad", "elm", "nat", "wyo", "gym", "dug", "toe", "dee", "wig", "sly", "rip", "geo", "cog", "pas",
//				"zen", "odd", "nan", "lay", "pod", "fit", "hem", "joy", "bum", "rio", "yon", "dec", "leg", "put", "sue",
//				"dim", "pet", "yaw", "nub", "bit", "bur", "sid", "sun", "oil", "red", "doc", "moe", "caw", "eel", "dix",
//				"cub", "end", "gem", "off", "yew", "hug", "pop", "tub", "sgt", "lid", "pun", "ton", "sol", "din", "yup",
//				"jab", "pea", "bug", "gag", "mil", "jig", "hub", "low", "did", "tin", "get", "gte", "sox", "lei", "mig",
//				"fig", "lon", "use", "ban", "flo", "nov", "jut", "bag", "mir", "sty", "lap", "two", "ins", "con", "ant",
//				"net", "tux", "ode", "stu", "mug", "cad", "nap", "gun", "fop", "tot", "sow", "sal", "sic", "ted", "wot",
//				"del", "imp", "cob", "way", "ann", "tan", "mci", "job", "wet", "ism", "err", "him", "all", "pad", "hah",
//				"hie", "aim", "ike", "jed", "ego", "mac", "baa", "min", "com", "ill", "was", "cab", "ago", "ina", "big",
//				"ilk", "gal", "tap", "duh", "ola", "ran", "lab", "top", "gob", "hot", "ora", "tia", "kip", "han", "met",
//				"hut", "she", "sac", "fed", "goo", "tee", "ell", "not", "act", "gil", "rut", "ala", "ape", "rig", "cid",
//				"god", "duo", "lin", "aid", "gel", "awl", "lag", "elf", "liz", "ref", "aha", "fib", "oho", "tho", "her",
//				"nor", "ace", "adz", "fun", "ned", "coo", "win", "tao", "coy", "van", "man", "pit", "guy", "foe", "hid",
//				"mai", "sup", "jay", "hob", "mow", "jot", "are", "pol", "arc", "lax", "aft", "alb", "len", "air", "pug",
//				"pox", "vow", "got", "meg", "zoe", "amp", "ale", "bud", "gee", "pin", "dun", "pat", "ten", "mob");
//
//		System.out.println(findLadders(beginWord, endWord, wordList));
//	}
//
//	// Time Limit Exceeded
//	static public Integer maxLevel;
//
//	static public List<List<String>> findLadders1(String beginWord, String endWord, List<String> wordList, int level) {
//		List<List<String>> ret = new ArrayList<>();
//		if (maxLevel != null && level > maxLevel)
//			return ret;
//		List<List<String>> nextStep = findWords(beginWord, endWord, wordList);
//		if (nextStep.size() == 3) {
//			maxLevel = level;
//			ret.add(new ArrayList<String>(Arrays.asList(beginWord, endWord)));
//			return ret;
//
//		}
//		System.out.println(nextStep);
//		for (String s : nextStep.get(0)) {
//
//			for (List<String> ls : findLadders1(s, endWord, nextStep.get(1), level + 1)) {
//				ls.add(0, beginWord);
//				ret.add(ls);
//			}
//		}
//
//		return ret;
//	}
//
//	static public List<List<String>> findLadders1(String beginWord, String endWord, List<String> wordList) {
//		List<List<String>> ret = findLadders1(beginWord, endWord, wordList, 0);
//		for (Iterator iterator = ret.iterator(); iterator.hasNext();) {
//			List<String> list = (List<String>) iterator.next();
//			if (list.size() > maxLevel + 2)
//				iterator.remove();
//		}
//
//		return ret;
//	}

}
