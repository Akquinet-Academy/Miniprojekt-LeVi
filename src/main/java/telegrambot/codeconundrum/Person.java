package telegrambot.codeconundrum;

import java.util.HashMap;

public class Person extends Source {
    HashMap<String, Information> answers;

    boolean isCulprit;

    public Person(String name, boolean isCulprit) {
        this.name = name;
        this.isCulprit = isCulprit;
    }

    public boolean isCulprit() {
        return isCulprit;
    }
}
