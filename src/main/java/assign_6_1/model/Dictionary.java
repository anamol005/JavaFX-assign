package assign_6_1.model;

import java.util.HashMap;

public class Dictionary {

    private HashMap<String, String> words;

    public Dictionary() {
        words = new HashMap<>();
    }

    public void addWord(String word, String meaning) {
        words.put(word.toLowerCase(), meaning);
    }

    public String getMeaning(String word) {
        return words.get(word.toLowerCase());
    }
}
