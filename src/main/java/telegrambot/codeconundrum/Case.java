package telegrambot.codeconundrum;

import java.util.HashMap;

public class Case {
    Person culprit;
    Information motive;
    Information means;
    Information opportunity;
    HashMap<String, Person> suspects;
    HashMap<String, Place> places;

    public Case() {
        createSuspects();
        createPlaces();
        createSolution();
    }

    void createSolution() {
        this.culprit = suspects.get("Hubert");
        this.motive = new Information("All these commits are so annoying, such chaos! I just want to work on my code in peace, I'm glad someone took initiative.", true, culprit);
        this.means = new Information("Next to the door, there is a list of all authorized personell: ", true, places.get("Server Room"));
        this.opportunity = new Information("Hubert often stays late and is the last one to leave the building", true, suspects.get("Sam"));
    }

    void createSuspects() {
        HashMap<String, Person> suspects = new HashMap<>();
        suspects.put("Larry", new Person("Larry Lint", false));
        suspects.put("Rita", new Person("Rita Codecrunch", false));
        suspects.put("Sam", new Person("Sam Phishmaster", false));
        suspects.put("Maggie", new Person("Maggie Clickson", false));
        suspects.put("Hubert", new Person("Hubert Norton", true));
        this.suspects = suspects;
    }

    void createPlaces() {
        HashMap<String, Place> places = new HashMap<>();
        places.put("Server Room", new Place("Server Room", "You are standing in the company's server room."));
        places.put("Cafeteria", new Place("Cafeteria", "You are standing in the company's cafeteria."));
        places.put("Larry's desk", new Place("Larry's desk", "You are standing in front of Larry's desk"));
        places.put("Rita's desk", new Place("Rita's desk", "You are standing in front of Rita's desk"));
        places.put("Sam's desk", new Place("Sam's desk", "You are standing in front of Sam's desk"));
        places.put("Maggie's desk", new Place("Maggie's desk", "You are standing in front of Maggie's desk"));
        places.put("Hubert's desk", new Place("Hubert's desk", "You are standing in front of Hubert's desk"));
        this.places = places;
    }


}
