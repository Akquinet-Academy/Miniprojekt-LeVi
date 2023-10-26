package telegrambot.codeconundrum;

import java.util.HashMap;
import java.util.Map;

public abstract class Source {
    String name;

    HashMap<String, Information> answers = new HashMap<>();

    public void addAnswers(String key, Information value) {
        answers.put(key, value);
    }
}
