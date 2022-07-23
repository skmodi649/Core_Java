import java.util.Dictionary;
import java.util.Hashtable;
import java.util.Scanner;

public class Opengenus_DictionaryClass {
    public static void main(String[] args){
        Dictionary<String, String> dictionary = new Hashtable<>();
        dictionary.put("Map", "Pictorial representation of an area");
        dictionary.put("gender", "sexual orientation of a person");
        dictionary.put("book", "A collection of pages clubbed together for a particular subject");
        dictionary.put("computer", "An electronic device used for computational and high end purposes");
        dictionary.put("cricket", "An insect");

        System.out.println("Enter the word to be searched: ");
        Scanner sc = new Scanner(System.in);
        String word = sc.next();
        String meaning = dictionary.get(word);
        if(meaning.isEmpty())
            System.out.println("Not Found!");
        else
            System.out.println(meaning);
    }
}
