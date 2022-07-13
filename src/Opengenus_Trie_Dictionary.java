import java.util.HashMap;
import java.util.Scanner;

class TrieNode {
    public TrieNode parent;
    public Boolean endOfWord = false; //Does this Node mark the end of a particular word?
    public HashMap<Character,TrieNode> children = new HashMap<Character,TrieNode>();
}

public class Opengenus_Trie_Dictionary {
    private HashMap<Character,TrieNode> roots = new HashMap<Character,TrieNode>();
    private static int n;

    /**
     * Search through the dictionary for a word.
     * @param string The word to search for.
     * @return Whether or not the word exists in the dictionary.
     */
    public boolean search(String string) {
        if (roots.containsKey(string.charAt(0))) {
            if (string.length()==1) {
                return true;
            }
            return searchFor(string.substring(1),roots.get(string.charAt(0)));
        } else {
            return false;
        }
    }

    /**
     * Insert a word into the dictionary.
     * @param word The word to insert.
     */
    public void insert(String word) {
        if (!roots.containsKey(word.charAt(0))) {
            roots.put(word.charAt(0), new TrieNode());
        }

        insertWord(word.substring(1),roots.get(word.charAt(0)));
    }


    //Adds a new word to the trie tree.
    private void insertWord(String word, TrieNode node) {
        final TrieNode nextChild;
        if (node.children.containsKey(word.charAt(0))) {
            nextChild = node.children.get(word.charAt(0));
        } else {
            nextChild = new TrieNode();
            node.children.put(word.charAt(0), nextChild);
        }

        if (word.length() == 1) {
            nextChild.endOfWord = true;
            return;
        } else {
            insertWord(word.substring(1),nextChild);
        }
    }


    //Recursive method that searches through the Trie Tree to find the value.
    private boolean searchFor(String string, TrieNode node) {
        if (string.length()==0) {
            if (node.endOfWord) {
                return true;
            } else {
                return false;
            }
        }

        if (node.children.containsKey(string.charAt(0))) {
            return searchFor(string.substring(1),node.children.get(string.charAt(0)));
        } else {
            return false;
        }
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        // Let's add some words in the dictionary
        System.out.println("Enter the number of words to be inserted in the dictionary: ");
        n = sc.nextInt();
        System.out.println("Enter the words one by one: ");
        Opengenus_Trie_Dictionary obj = new Opengenus_Trie_Dictionary();
        for(int i = 1 ; i <= n ; i++){
            String word = sc.next();
            obj.insert(word);
        }
        System.out.println("All words have been inserted!");
        System.out.println("Enter the word to be searched: ");
        String str = sc.next();
        if(obj.search(str))
            System.out.println("Present!");
        else
            System.out.println("Not Present!");
    }
}
