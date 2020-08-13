package analyze;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class AnalyzeTest {
    @Test
    public void whenAddedUser() {
        Analyze.User user1 = new Analyze.User(1, "Ivan");
        Analyze.User user2 = new Analyze.User(2, "Ivan1");
        Analyze.User user3 = new Analyze.User(3, "Ivan2");
        List<Analyze.User> prev = List.of(user1, user2, user3);
        Analyze.User user4 = new Analyze.User(4, "Vasya");
        List<Analyze.User> current = List.of(user1, user2, user3, user4);
        Analyze.Info rsl = Analyze.diff(prev, current);
        Analyze.Info excepted = new Analyze.Info(1, 0, 0);
        assertThat(rsl, is(excepted));
    }

    @Test
    public void whenNoChanges() {
        Analyze.User user1 = new Analyze.User(1, "Ivan");
        Analyze.User user2 = new Analyze.User(2, "Ivan1");
        Analyze.User user3 = new Analyze.User(3, "Ivan2");
        List<Analyze.User> prev = List.of(user1, user2, user3);
        List<Analyze.User> current = List.of(user1, user2, user3);
        Analyze.Info rsl = Analyze.diff(prev, current);
        Analyze.Info excepted = new Analyze.Info(0, 0, 0);
        assertThat(rsl, is(excepted));
    }

    @Test
    public void whenOneChange() {
        Analyze.User user1 = new Analyze.User(1, "Ivan");
        Analyze.User user2 = new Analyze.User(2, "Ivan1");
        Analyze.User user3 = new Analyze.User(3, "Ivan2");
        List<Analyze.User> prev = Arrays.asList(user1, user2, user3);
        Analyze.User user4 = new Analyze.User(1, "Sasha");
        List<Analyze.User> current = List.of(user4, user2, user3);
        Analyze.Info rsl = Analyze.diff(prev, current);
        Analyze.Info excepted = new Analyze.Info(0, 1, 0);
        assertThat(rsl, is(excepted));
    }

    @Test
    public void whenAddedUserAndDelete() {
        Analyze.User user1 = new Analyze.User(1, "Ivan");
        Analyze.User user2 = new Analyze.User(2, "Ivan1");
        Analyze.User user3 = new Analyze.User(3, "Ivan2");
        List<Analyze.User> prev = List.of(user1, user2, user3);
        Analyze.User user4 = new Analyze.User(4, "Vasya");
        List<Analyze.User> current = List.of(user1, user3, user4);
        Analyze.Info rsl = Analyze.diff(prev, current);
        Analyze.Info excepted = new Analyze.Info(1, 0, 1);
        assertThat(rsl, is(excepted));
    }

    @Test
    public void whenAddedUserAndDeleteAndChange() {
        Analyze.User user1 = new Analyze.User(1, "Ivan");
        Analyze.User user2 = new Analyze.User(2, "Ivan1");
        Analyze.User user3 = new Analyze.User(3, "Ivan2");
        List<Analyze.User> prev = List.of(user1, user2, user3);
        Analyze.User user4 = new Analyze.User(4, "Vasya");
        Analyze.User user5 = new Analyze.User(3, "Andrei");
        List<Analyze.User> current = List.of(user1, user5, user4);
        Analyze.Info rsl = Analyze.diff(prev, current);
        Analyze.Info excepted = new Analyze.Info(1, 1, 1);
        assertThat(rsl, is(excepted));
    }
}