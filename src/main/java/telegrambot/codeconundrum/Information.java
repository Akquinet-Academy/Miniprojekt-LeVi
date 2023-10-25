package telegrambot.codeconundrum;

public class Information {
    String description;
    boolean isCaseRelevant;
    Source whereToFind;

    public Information(String description, boolean isCaseRelevant, Source whereToFind) {
        this.description = description;
        this.isCaseRelevant = isCaseRelevant;
        this.whereToFind = whereToFind;
    }

    public Source getWhereToFind() {
        return whereToFind;
    }

    @Override
    public String toString() {
        return description;
    }
}
