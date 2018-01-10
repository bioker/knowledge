package net.wls.learn.spring.innerbean;

public class SpellChecker {

    private String name;

    public SpellChecker() {

    }

    public SpellChecker(String name) {
        this.name = name;
        System.out.println("spell checker " + name + " creation");
    }

    public void spellCheck() {
        System.out.println("spell check " + name + " calling");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
