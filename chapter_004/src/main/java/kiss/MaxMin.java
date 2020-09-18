package kiss;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class MaxMin {
    private <T> T findValue(List<T> value, Comparator<T> comparator, Predicate<Integer> predicate) {
        if (value.size() == 0) {
            return null;
        }
        int comparatorValue;
        T rsl = value.get(0);
        for (T t : value) {
            comparatorValue = comparator.compare(t, rsl);
            if (predicate.test(comparatorValue)) {
                rsl = t;
            }
        }
        return rsl;
    }

    public <T> T max(List<T> value, Comparator<T> comparator) {
        return findValue(value, comparator, val -> val > 0);
    }

    public <T> T min(List<T> value, Comparator<T> comparator) {
        return findValue(value, comparator, val -> val < 0);
    }
}
