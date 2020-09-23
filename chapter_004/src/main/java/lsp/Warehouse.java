package lsp;

import java.util.ArrayList;
import java.util.List;

public class Warehouse implements Storage {
    private final List<Food> warehouse;

    public Warehouse() {
        warehouse = new ArrayList<>();
    }

    @Override
    public void save(Food food) {
        if (food != null) {
            warehouse.add(food);
        }
    }

    @Override
    public boolean checkPercentExpire(int percent) {
        return percent < 25;
    }

    @Override
    public List<Food> getAllFood() {
        return warehouse;
    }
}
