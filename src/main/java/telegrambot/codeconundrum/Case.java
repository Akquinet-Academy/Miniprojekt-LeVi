package telegrambot.codeconundrum;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Case {
    Person culprit;
    Information motive;
    Information means;
    Information opportunity;
    HashMap<String, Person> suspects;
    HashMap<String, Place> places;

    HashMap<String, String> solution;

    public HashMap<String, Person> getSuspects() {
        return suspects;
    }

    public HashMap<String, Place> getPlaces() {
        return places;
    }

    HashMap<String, Information> clues;

    public Case() {
        createSuspects();
        createPlaces();
        createClues();
        createSolution();
        sortClues();
    }

    void sortClues() {
        for (Map.Entry<String, Information> clue : clues.entrySet()) {
            Source source = clue.getValue().getWhereToFind();
            source.addAnswers(clue.getKey(), clue.getValue());
        }
    }


    void createSolution() {
        solution = new HashMap<>();
        solution.put("Culprit", "Hubert");
        solution.put("Motive", "Annoyance");
        solution.put("Place", "Server Room");
        solution.put("Time", "Night");
    }

    void createClues() {
        HashMap<String, Information> clues = new HashMap<>();

        //Hinweise an Orten zu finden
        clues.put("Security cam", new Information("You go through the security cam footage from yesterday. Both Hubert and Sam have been to the server room.", true, places.get("Server Room")));
        clues.put("SR desktop", new Information("Rows of towering server racks hum softly under the glow of blue status lights. At one end, an unassuming workstation blinks with lines of code on its screen, offering anonymous access to the repository.", true, places.get("Server Room")));
        clues.put("Phish fotos", new Information("A collage of photos from the company's most recent team-building day at the lake fills the walls. The irony of their 'phishy' outing is not lost on you.", false, places.get("Cafeteria")));
        clues.put("Coffee cup", new Information("A lone coffee cup rests on a table, its surface adorned with the phrase 'Caffeine Hacker' in playful font. Smells like freshly brewed mischief.", false, places.get("Cafeteria")));
        clues.put("USB Stick", new Information("You spot a USB stick labeled 'Try me' left on an empty chair. As you eye this digital rabbit hole, you can't help but wonder if it's a potential social engineering attempt.", false, places.get("Cafeteria")));
        clues.put("kinder egg", new Information("You notice a collection of Kinder Surprise eggs, a rather unusual find given their banned importation.", false, places.get("Larry's desk")));
        clues.put("chaos", new Information("Larry's desk is an absolute mess, cluttered with scattered papers, tangled wires, and the unmistakable evidence of past coffee spills.", false, places.get("Larry's desk")));
        clues.put("Larry's notes", new Information("You come across a collection of handwritten notes that seem to reflect his frustration and confusion. Among them, you notice scribbles that repeatedly question, \"How can I undo the mistake?\". ", false, places.get("Larry's desk")));
        clues.put("scented candle", new Information("You can't miss a gigantic scented candle, taking up a significant portion of the workspace. Its presence is quite overwhelming, emitting a pleasant yet overpowering fragrance that permeates the surrounding area.\" ", false, places.get("Rita's desk")));
        clues.put("puzzle books", new Information("Among the items on Rita's desk, you come across a collection of puzzle books, including Sudoku and crossword puzzles. It's as if she wishes to make the office environment a tad more thrilling.", false, places.get("Rita's desk")));
        clues.put("rubik's cube", new Information("You notice a Rubik's Cube, its colorful facets partially twisted and in various states of completion.", false, places.get("Rita's desk")));
        clues.put("SE literature", new Information("On Sam's desk, you find \"The Art of Deception\" by Kevin D. Mitnick, a well-worn book on social engineering. It appears that Sam is well-versed in the art of persuasion.", false, places.get("Sam's desk")));
        clues.put("movie poster", new Information("Hanging on the wall, a framed movie poster for \"The Stanford Prison Experiment\" catches your attention.", false, places.get("Sam's desk")));
        clues.put("family photo", new Information("A family photo frame stands prominently. It captures a tender moment of Sam's family, showcasing his wife and child.", false, places.get("Sam's desk")));
        clues.put("glitter stuff", new Information("Maggie's desk is a shimmering wonderland of sparkly trinkets and glittery decorations, from iridescent pens to glistening stationery.", false, places.get("Maggie's desk")));
        clues.put("ADHD medication", new Information("You notice a small, neatly arranged container of her prescribed ADHD medication.", false, places.get("Maggie's desk")));
        clues.put("ENTER", new Information("An unusually large \"Enter\" key serves as an attention-grabbing desk accessory. Its size and prominent position make you wonder if someone might have accidentally pressed it.", false, places.get("Maggie's desk")));
        clues.put("order", new Information("Everything is meticulously arranged, from perfectly aligned pens to orderly stacked documents.", false, places.get("Hubert's desk")));
        clues.put("red herring", new Information("Amidst the remarkable neatness on Hubert's desk, a somewhat unexpected sight catches your eye: a container of red beet herring salad from Aldi.", false, places.get("Hubert's desk")));
        clues.put("fork/napkin", new Information("A lone stainless steel fork and a neatly folded paper napkin stand ready for action. Hubert doesn't seem to frequent the cafeteria too often.", false, places.get("Hubert's desk")));
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
        clues.put("SR list", new Information("Next to the door, there is a list of all authorized personell: \n\nSam Phishmaster \nHubert Norton \nRita Codecrunch", true, places.get("Server Room")));
        clues.put("Coll Sam", new Information("Hubert often stays late and is the last one to leave the building", true, suspects.get("Sam")));
        this.clues = clues;
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
        places.put("Server Room", new Place("Server Room", "You are standing in the company's server room. \uD83D\uDDA5\uFE0F"));
        places.put("Cafeteria", new Place("Cafeteria", "You are standing in the company's cafeteria. \uD83C\uDF4E"));
        places.put("Larry's desk", new Place("Larry's desk", "You are standing in front of Larry's desk. \uD83D\uDDD2\uFE0F"));
        places.put("Rita's desk", new Place("Rita's desk", "You are standing in front of Rita's desk. \uD83C\uDFB2"));
        places.put("Sam's desk", new Place("Sam's desk", "You are standing in front of Sam's desk. \uD83D\uDCDA"));
        places.put("Maggie's desk", new Place("Maggie's desk", "You are standing in front of Maggie's desk. \uD83D\uDC08"));
        places.put("Hubert's desk", new Place("Hubert's desk", "You are standing in front of Hubert's desk. \uD83C\uDF7D\uFE0F"));
        this.places = places;
    }

    public HashMap<String, String> getSolution() {
        return solution;
    }
}
