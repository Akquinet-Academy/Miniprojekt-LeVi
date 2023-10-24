package telegrambot.codeconundrum;

public class Case {
    Person culprit;
    Information motive = new Information();
    Information means;
    Information opportunity;

    public Case() {
        createSuspects();
    }

    void createSuspects() {
        Person larry = new Person("Larry Lint", false);
        Person rita = new Person("Rita Codecrunch", false);
        Person sam = new Person("Sam Phishmaster", false);
        Person maggie = new Person("Maggie Clickson", false);
        Person hubert = new Person("Hubert Norton", true);
    }

}
