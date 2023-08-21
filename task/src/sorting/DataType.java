package sorting;

public enum DataType {
    WORD,
    LINE,
    LONG;

    public String getName() {
        return this.name().toLowerCase();
    }
}
