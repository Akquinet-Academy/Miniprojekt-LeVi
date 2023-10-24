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
        Person larry = new Person("Larry Lint", false);
    }

    void createPlaces() {
        Place serverRoom = new Place("Server Room", "You are standing in the company's server room.");
        Place cafeteria = new Place("Cafeteria", "You are standing in the company's cafeteria.");
        Place larrysDesk = new Place("Larry's desk", "You are standing in front of Larry's desk.");
        Place ritasDesk = new Place("Larry's desk", "You are standing in front of Rita's desk.");
        Place samsDesk = new Place("Larry's desk", "You are standing in front of Sam's desk.");
        Place maggiesDesk = new Place("Larry's desk", "You are standing in front of Maggie's desk.");
        Place hubertsDesk = new Place("Larry's desk", "You are standing in front of Hubert's desk.");
    }


}
