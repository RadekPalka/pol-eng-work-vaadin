package com.example;

import java.util.ArrayList;
import java.util.List;

public class Flashcard {
    private final String polishWord;
    private final List<String> englishWords;

    public Flashcard(String polishWord, List<String> englishWords){
        this.polishWord = polishWord;
        this.englishWords = englishWords;
    }

    public String getPolishWorld() {
        return polishWord;
    }

    public ArrayList<String> getEnglishWords() {
        return new ArrayList<>(englishWords);
    }
}
