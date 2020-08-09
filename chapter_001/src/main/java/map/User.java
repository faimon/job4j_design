package map;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

public class User {
    private String name;
    private int children;
    private Calendar birthday;

    public User(String name, int children, Calendar birthday) {
        this.name = name;
        this.children = children;
        this.birthday = birthday;
    }

    public static void main(String[] args) {
        User user1 = new User("Ivan", 2, new GregorianCalendar(1950, Calendar.JANUARY, 3));
        User user2 = new User("Ivan", 2, new GregorianCalendar(1950, Calendar.JANUARY, 3));
        Map<User, Object> map = new HashMap<>();
        map.put(user1, "first");
        map.put(user2, "second");
        System.out.println(map);
        System.out.println(user1.equals(user2));

    }
}
