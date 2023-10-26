package telegrambot.codeconundrum;

import java.util.HashMap;

public abstract class Source {
    String name;

    HashMap<String, Information> answers = new HashMap<>();


    @Override
    public String toString() {
        return name;
    }

    public void addAnswers(String key, Information value) {
        answers.put(key, value);
    }

    public HashMap<String, Information> getAnswers() {
        return answers;
    }
}
