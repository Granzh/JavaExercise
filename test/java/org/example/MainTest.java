package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.example.Main.invertWords;
import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    public void testOnReverseSentence() {
        String str = "Hello, word!";
        str = invertWords(str);
        "olleH, dlrow!".equals(str);
    }
    @Test
    public void testOnPunctuation() {
        String punctuation = ",.!:;";
        punctuation = invertWords(punctuation);
        ",.!:;".equals(punctuation);
    }
}