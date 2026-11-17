package assign_6_1.controller;

import assign_6_1.model.Dictionary;

public class DictionaryController {

    private Dictionary dictionary;

    public DictionaryController() {
        dictionary = new Dictionary();

        dictionary.addWord("apple", "A round fruit");
        dictionary.addWord("book", "A set of written pages");
        dictionary.addWord("computer", "An electronic device");
        dictionary.addWord("school", "A place where students learn");
        dictionary.addWord("water", "A clear liquid");
    }

    public String search(String word) {

        if (word.trim().isEmpty()) {
            return "Please enter a word.";
        }

        String meaning = dictionary.getMeaning(word);

        if (meaning == null) {
            return "Word not found.";
        }

        return meaning;
    }
}
