package org.example;

public class Main {
    public static void main(String[] args) {
        String str = "Hello, world!";
        System.out.println(invertWords(str));
    }

    public static String invertWords(String str) {
        final String splitPattern = "(?<=\\W)|(?=\\W)";
        String[] wordsAndPunctuation = str.split(splitPattern);
        StringBuilder invertedSentence = new StringBuilder();
        for (String wordOrPunctuation : wordsAndPunctuation) {
            if (isPunctuation(wordOrPunctuation)) {
                invertedSentence.append(wordOrPunctuation);
            } else {
                StringBuilder invertedWord = new StringBuilder(wordOrPunctuation);
                invertedSentence.append(invertedWord.reverse());
            }
        }
        return invertedSentence.toString();
    }
    private static boolean isPunctuation (String character) {
        return !character.matches("\\w+");
    }
}