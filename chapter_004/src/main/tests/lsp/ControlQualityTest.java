package lsp;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class ControlQualityTest {
    @Test
    public void WhenMilkInTrash() {
        List<Storage> store = new ArrayList<>();
        store.add(new Warehouse());
        store.add(new Trash());
        store.add(new Shop());
        ControlQuality controlQuality = new ControlQuality(store);
        Calendar expireDate = Calendar.getInstance();
        expireDate.set(2020, Calendar.MARCH, 30);
        Calendar createdDate = Calendar.getInstance();
        createdDate.set(2020, Calendar.MARCH, 10);
        Milk milk = new Milk("Простоквашино", expireDate, createdDate, 100, 0);
        Calendar current = Calendar.getInstance();
        current.set(2020, Calendar.APRIL, 5);
        controlQuality.distributeToStorage(milk, current, createdDate);
        assertThat(store.get(1).getAllFood().get(0), is(milk));
    }

    @Test
    public void WhenMilkInShop() {
        List<Storage> store = new ArrayList<>();
        store.add(new Warehouse());
        store.add(new Trash());
        store.add(new Shop());
        ControlQuality controlQuality = new ControlQuality(store);
        Calendar expireDate = Calendar.getInstance();
        expireDate.set(2020, Calendar.MARCH, 30);
        Calendar createdDate = Calendar.getInstance();
        createdDate.set(2020, Calendar.MARCH, 10);
        Milk milk = new Milk("Простоквашино", expireDate, createdDate, 100, 0);
        Calendar currentDate = Calendar.getInstance();
        currentDate.set(2020, Calendar.MARCH, 20);
        controlQuality.distributeToStorage(milk, currentDate, createdDate);
        assertThat(store.get(2).getAllFood().get(0), is(milk));
    }

    @Test
    public void WhenMilkInWarehouse() {
        List<Storage> store = new ArrayList<>();
        store.add(new Warehouse());
        store.add(new Trash());
        store.add(new Shop());
        ControlQuality controlQuality = new ControlQuality(store);
        Calendar expireDate = Calendar.getInstance();
        expireDate.set(2020, Calendar.MARCH, 30);
        Calendar createdDate = Calendar.getInstance();
        createdDate.set(2020, Calendar.MARCH, 10);
        Milk milk = new Milk("Простоквашино", expireDate, createdDate, 100, 0);
        Calendar currentDate = Calendar.getInstance();
        currentDate.set(2020, Calendar.MARCH, 11);
        controlQuality.distributeToStorage(milk, currentDate, createdDate);
        assertThat(store.get(0).getAllFood().get(0), is(milk));
    }
}