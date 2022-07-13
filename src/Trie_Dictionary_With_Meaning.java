import java.util.HashMap;
import java.util.Scanner;

class Trie{
    public boolean endOfWord = false;
    public String meaning;
    public HashMap<Character,Trie> children = new HashMap<>();
}

public class Trie_Dictionary_With_Meaning {
    // Function to create a new trie node
    Trie getNewNode(){
        Trie node = new Trie();
        node.endOfWord = false;
        return node;
    }

    // Functions to insert new word with its meaning
    // in the dictionary built using trie data structure
    void insert(Trie root, String word, String meaning){
        if(root == null)
            getNewNode();

        Trie temp = root;
        for(int i = 0 ; i < word.length() ; i++){
            char x = word.charAt(i);

            // Making a new node in case there is no path
            if(temp.children.containsKey(x))
                temp = temp.children.get(x);

            temp.children.put(x, getNewNode());
        }
        // Mark end of word and store the meaning
        temp.endOfWord = true;
        temp.meaning = meaning;
    }

    // Function to search a word in the trie and return its meaning
    String getWordMeaning(Trie root, String word){
        if(root == null)
            return "";
        Trie temp = root;

        // Searching for a word in trie
        for(int i = 0 ; i < word.length() ; i++){
            temp = temp.children.get(word.charAt(i));
            if(temp == null)
                return "";
        }

        // if it is the end of valid word stored beforehand then
        // simply return its meaning
        if(temp.endOfWord)
            return temp.meaning;

        return "";
    }

    public static void main(String[] args){
        Trie root = null;

        // Let's build the dictionary

        Trie_Dictionary_With_Meaning obj = new Trie_Dictionary_With_Meaning();

        obj.insert(root, "Math", "A subject that deals in numbers");
        obj.insert(root, "map", "Diagrammatic representation of a particular area");
        obj.insert(root, "schedule", "A plan designed to execute a particular task");
        obj.insert(root, "book", "A written or printed work consisting of pages");
        System.out.println("Enter the word to be searched: ");
        String str = sc.next();
        System.out.println(obj.getWordMeaning(root, str));
    }
}
