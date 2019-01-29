/*
 This class is used to validate the file name according to the timestap format (YYYY.MM.DD HH.MM.SS)
 */
package game;

import java.util.regex.Pattern;

/**
 *
 * @author Mahy
 */
public class FileNameMatcher {

    private final static Pattern DATE_PATTERN = Pattern.compile("^\\d{4}.\\d{2}.\\d{2}\\s\\d{2}.\\d{2}.\\d{2}$");

    public  static boolean matches(String date) {
        return DATE_PATTERN.matcher(date).matches();
    }
}
