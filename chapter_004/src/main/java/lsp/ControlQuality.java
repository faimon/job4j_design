package lsp;

import java.util.Calendar;
import java.util.List;

public class ControlQuality {
    private final List<Storage> storage;

    public ControlQuality(List<Storage> storage) {
        this.storage = storage;
    }

    public void distributeToStorage(Food food, Calendar current, Calendar created) {
        for (Storage store : storage) {
            if (store.checkPercentExpire(percentExpire(food, current, created))) {
                store.save(food);
                break;
            }
        }
    }

    private int percentExpire(Food food, Calendar currentDate, Calendar createdDate) {
        long expiredDate = food.getExpireDate().getTimeInMillis();
        long allDays = expiredDate - createdDate.getTimeInMillis();
        long daysAfter = currentDate.getTimeInMillis() - createdDate.getTimeInMillis();
        return (int) (daysAfter * 100 / allDays);
    }
}
