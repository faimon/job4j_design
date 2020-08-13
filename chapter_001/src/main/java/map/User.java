package map;

import java.util.*;

public class User {
    private String name;
    private int children;
    private Calendar birthday;

    public User(String name, int children, Calendar birthday) {
        this.name = name;
        this.children = children;
        this.birthday = birthday;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return children == user.children &&
                Objects.equals(name, user.name) &&
                Objects.equals(birthday, user.birthday);
    }

    @Override
    public int hashCode() {
        // return Objects.hash(name, children, birthday);
        return 1;
    }

    public static void main(String[] args) {
     /*   SimpleHashMap<Integer, String> map = new SimpleHashMap<>();
        for (int i = 0; i < 1600; i++) {
            map.insert(i, Integer.toString(i));
        }
        for (int i = 0; i < 1600; i++) {
            System.out.println("value = " + map.get(i));
        } */
        User user1 = new User("Ivan", 2, new GregorianCalendar(1950, Calendar.JANUARY, 3));
        User user2 = new User("Ivan2321321", 2, new GregorianCalendar(1950, Calendar.JANUARY, 3));
        User user3 = new User("vasyan", 2, new GregorianCalendar(1950, Calendar.JANUARY, 3));
        User user4 = new User("dsfsdfdsf", 2, new GregorianCalendar(1950, Calendar.JANUARY, 3));
        SimpleHashMap<User, String> map = new SimpleHashMap<>();
        map.insert(user1, "first");
        map.insert(user2, "second");
        map.insert(user3, "third");
        map.insert(user4, "four");
        map.delete(user3);
        System.out.println(map.get(user1));
        System.out.println(map.get(user2));
        System.out.println(map.get(user3));
        System.out.println(map.get(user4));
    }
}
