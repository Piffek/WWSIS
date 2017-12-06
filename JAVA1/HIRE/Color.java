import java.util.Objects;

public enum Color {
    RED("red"),
    GREEN("green"),
    BLUE("blue");

    Color(String colorName) {
        this.colorName = colorName;
    }

    String colorName;

    public static Color parse(String string) {
        for (Color color : Color.values()) {
            if (Objects.equals(color.colorName, string)) {
                return color;
            }
        }
        return RED;
    }
}