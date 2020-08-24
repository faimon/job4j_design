package log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UsageLog4j {
    private static final Logger LOG = LoggerFactory.getLogger(UsageLog4j.class.getName());

    public static void main(String[] args) {
        String name = "Petr Arsentev";
        int age = 33;
        char ch = 'a';
        boolean rsl = false;
        double num = 1.25;
        long longNum = 44444444;
        float lp = (float) 3.14;
        byte aa = 1;
        short bb = 127;
        LOG.debug("byte = {}", aa);
        LOG.debug("short = {}", bb);
        LOG.debug("float = {}", lp);
        LOG.debug("Boolean = {}", rsl);
        LOG.debug("Double = {}", num);
        LOG.debug("long = {}", longNum);
        LOG.debug("Char = {}", ch);
        LOG.debug("User info name : {}, age : {}", name, age);
    }
}
