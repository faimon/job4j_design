package io;

import java.nio.file.Path;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PredicateFactory {
    private static final String FULL_MATCH = "-f";
    private static final String REGEX = "-r";
    private static final String MASK = "-m";

    public static boolean getBoolRsl(String typeSearch, String name, Path file, Pattern reg) {
        boolean rsl = false;
        if (typeSearch.equals(FULL_MATCH)) {
            rsl = file.getFileName().toString().equals(name);
        } else if (typeSearch.equals(REGEX)) {
            Matcher m = reg.matcher(file.getFileName().toString());
            rsl = m.matches();
        } else if (typeSearch.equals(MASK)) {
            String fileName = name.replace("*", "");
            rsl = file.getFileName().toString().contains(fileName);
        }
        return rsl;
    }
}
