package Flowers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public enum Color {
    white,
    black,
    red,
    yellow,
    purple,
    blue,
    beige,
    other;
    private static final Logger logger = LogManager.getLogger();

    public static Color getTypeByOrdinal(int ordinal) {
        if (ordinal < 0 || ordinal >= Color.values().length) {
            logger.error("IllegalArgumentException (You entered Illegal argument!)");
        }
        for (Color t : Color.values()) {
            if (t.ordinal() == ordinal) {
                return t;
            }
        }
        return null;
    }
}
