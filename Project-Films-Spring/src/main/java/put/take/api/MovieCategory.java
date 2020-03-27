package put.take.api;

public enum MovieCategory {
    DRAMA ("DRAMA"),
    COMEDY ("COMEDY"),
    FAMILY ("FAMILY"),
    ACTION ("ACTION"),
    SCI_FI ("SCI-FI"),
    CLASSIC ("CLASSIC");

    private final String name;
    MovieCategory(String name) {
        this.name = name;
    }
    public String toString() {
        return name;
    }
}
