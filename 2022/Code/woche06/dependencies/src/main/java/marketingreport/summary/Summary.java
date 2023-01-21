package marketingreport.summary;

public class Summary {
    private final String text;

    public Summary(String name, int size) {
        text = String.format("Segment '%s' enthält %d Einträge",name, size);
    }

    public String getText() {
        return text;
    }
}
