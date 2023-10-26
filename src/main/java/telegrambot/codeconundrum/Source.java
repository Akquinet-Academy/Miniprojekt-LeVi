package telegrambot.codeconundrum;

import java.util.HashMap;
import java.util.Map;

public abstract class Source {
    String name;

    HashMap<String, Information> answers = new HashMap<>();


    @Override
    public String toString() {
        String out = name + "\n";
        for (Map.Entry<String, Information> answer : answers.entrySet()) {
            out += "\n" + answer.getValue().toString();
        }
        return out;
    }

    public void addAnswers(String key, Information value) {
        answers.put(key, value);
    }
}
