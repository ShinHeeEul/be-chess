package softeer2nd.utils;

public class StringUtils {

    private static final String NEWLINE = System.getProperty("line.separator");

    private StringUtils() {}

    public static String appendNewLine(String s) {
        return s + NEWLINE;
    }
}