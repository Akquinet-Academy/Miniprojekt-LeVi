package telegrambot.codeconundrum;

public class Case {
    Person culprit;
    Information motive;
    Information means;
    Information opportunity;

    public Case() {
        createSuspects();
    }

    void createSuspects() {
        Person larry = new Person("Larry der Lausige Lint", false);
    }
}
