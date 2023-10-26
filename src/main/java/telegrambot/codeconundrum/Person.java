package telegrambot.codeconundrum;


public class Person extends Source {

    boolean isCulprit;
    String motive;
    String suspicion;

    public Person(String name, boolean isCulprit) {
        this.name = name;
        this.isCulprit = isCulprit;
        String firstname = name.split(" ")[0];
        this.motive = "Motive " + firstname;
        this.suspicion = "Coll " + firstname;
    }

    public boolean isCulprit() {
        return isCulprit;
    }

    @Override
    public String toString() {
        String out = "<b>" + name + "</b>\n";
        out += "\n<b>Tell me about your role in the project!</b>\n\n";
        out += answers.get(motive).toString() + "\n";
        out += "\n<b>Did you notice anyone acting suspiciously?</b>\n\n";
        out += answers.get(suspicion).toString();
        return out;
    }
}
