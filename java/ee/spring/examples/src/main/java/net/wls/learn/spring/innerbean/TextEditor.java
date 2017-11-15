package net.wls.learn.spring.innerbean;

public class TextEditor {

    private String name;
    private SpellChecker spellChecker;

    public TextEditor() {

    }

    public TextEditor(String name) {
        System.out.println("text editor " + name + " creation");
        this.name = name;
    }

    public SpellChecker getSpellChecker() {
        return spellChecker;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setSpellChecker(SpellChecker spellChecker) {
        System.out.println("set spell checker for text editor " + name);
        this.spellChecker = spellChecker;
    }

    public void spellCheck() {
        spellChecker.spellCheck();
    }

}
