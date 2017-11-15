package net.wls.learn.spring.javaconf;

public class TextEditor {
    private SpellChecker spellChecker;

    public TextEditor(SpellChecker spellChecker) {
        System.out.println("text editor creation");
        this.spellChecker = spellChecker;
    }

    public void spellCheck() {
        spellChecker.spellCheck();
    }
}
