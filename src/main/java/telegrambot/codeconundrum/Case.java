package telegrambot.codeconundrum;

import java.util.HashMap;

public class Case {
    Person culprit;
    Information motive;
    Information means;
    Information opportunity;
    HashMap<String, Person> suspects;
    HashMap<String, Place> places;
    HashMap<String, Information> clues;

    public Case() {
        createSuspects();
        createPlaces();
        createClues();
        createSolution();
        sortClues();
    }

    void sortClues() {
    }


    void createSolution() {
        HashMap<String, String> solution = new HashMap<>();
        solution.put("Culprit", "Hubert");
        solution.put("Motive", "Annoyance");
        solution.put("Place", "Server Room");
        solution.put("Time", "Night");
    }

    void createClues() {
        HashMap<String, Information> clues = new HashMap<>();
        //clues.put("", new Information("", false));

        //Hinweise an Orten zu finden


        //Hinweise im Gespräch mit Personen zu finden
        clues.put("Motive Larry", new Information("The internet is my home - and I mean, all of the internet. Thank God for the Tor browser...", false, suspects.get("Larry")));
        clues.put("Coll Larry", new Information("Sam bragged at lunch the other day how he manipulates people with his social engineering skills.", false, suspects.get("Larry")));
        clues.put("Motive Rita", new Information("The project has become so boring. At least we have a new riddle to solve now, huh?", false, suspects.get("Rita")));
        clues.put("Coll Rita", new Information("Larry is always the first one to enter the office in the morning. Does he sleep here?", false, suspects.get("Rita")));
        clues.put("Motive Sam", new Information("It's my responsibility to train my colleagues so that they recognize phishing attacks and I do use some unorthodox methods. But I would never hurt the company of course!", false, suspects.get("Sam")));
        // Coll Sam down below
        clues.put("Motive Maggie", new Information("I love, love, LOVE everything that blinks! And cats! Have you seen this cute video? Don't you worry about the popup ads, just click them away.", false, suspects.get("Maggie")));
        clues.put("Coll Maggie", new Information("Rita never wants to come along for lunch, she disappears for an hour and reappears back at her desk.", false, suspects.get("Maggie")));
        // Motive Hubert down below
        clues.put("Coll Hubert", new Information("Maggie seems to be really nervous recently. What is she hiding?", false, suspects.get("Hubert")));

        //Hinweise für die Auflösung
        clues.put("Motive Hubert", new Information("All these commits are so annoying, such chaos! I just want to work on my code in peace, I'm glad someone took initiative.", true, suspects.get("Hubert")));
        clues.put("SR list", new Information("Next to the door, there is a list of all authorized personell: \nSam Phishmaster \nHubert Norton \nRita Codecrunch", true, places.get("Server Room")));
        clues.put("Coll Sam", new Information("Hubert often stays late and is the last one to leave the building", true, suspects.get("Sam")));
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
