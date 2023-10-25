package telegrambot.codeconundrum;

import java.util.Map;

public class Place extends Source {
    String description;

    public Place(String name, String description) {
        this.name = name;
        this.description = description;
    }

    @Override
    public String toString() {
        String out = name + "\n" + description;
        for (Map.Entry<String, Information> answer : answers.entrySet()) {
            out += "\n" + answer.getValue().toString();
        }
        return out;
    }
}
