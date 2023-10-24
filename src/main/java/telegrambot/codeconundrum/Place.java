package telegrambot.codeconundrum;

public class Place {
    String name;
    String description;

    public Place(String name, String description) {
        this.name = name;
        this.description = description;
    }

    @Override
    public String toString() {
        return name + "\n" + description;
    }
}
