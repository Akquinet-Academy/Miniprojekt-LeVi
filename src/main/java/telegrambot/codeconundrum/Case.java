package telegrambot.codeconundrum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Case {
    Person culprit;
    Information motive;
    Information means;
    Information opportunity;
    ArrayList<Person> suspects;
    ArrayList<Place> places;

    public Case() {
        createSuspects();
        createPlaces();
        this.culprit = suspects.stream().filter(Person::isCulprit).findFirst().orElse(null);
        this.motive = new Information("Ich bin genervt von den ständigen Commits, so ein Chaos! Gut, dass mal jemand aufgeräumt hat.", true, culprit);
    }

    void createSuspects() {
        ArrayList<Person> suspects = new ArrayList<>();
        Person larry = new Person("Larry Lint", false);
        Person rita = new Person("Rita Codecrunch", false);
        Person sam = new Person("Sam Phishmaster", false);
        Person maggie = new Person("Maggie Clickson", false);
        Person hubert = new Person("Hubert Norton", true);
        Collections.addAll(suspects, larry, rita, sam, maggie, hubert);
        this.suspects = suspects;
    }

    void createPlaces() {
        ArrayList<Place> places = new ArrayList<>();
        Place serverRoom = new Place("Server Room", "You are standing in the company's server room.");
        Place cafeteria = new Place("Cafeteria", "You are standing in the company's cafeteria.");
        Place larrysDesk = new Place("Larry's desk", "You are standing in front of Larry's desk.");
        Place ritasDesk = new Place("Larry's desk", "You are standing in front of Rita's desk.");
        Place samsDesk = new Place("Larry's desk", "You are standing in front of Sam's desk.");
        Place maggiesDesk = new Place("Larry's desk", "You are standing in front of Maggie's desk.");
        Place hubertsDesk = new Place("Larry's desk", "You are standing in front of Hubert's desk.");
        Collections.addAll(places, serverRoom, cafeteria, larrysDesk, ritasDesk, samsDesk, maggiesDesk, hubertsDesk);
        this.places = places;
    }


}
