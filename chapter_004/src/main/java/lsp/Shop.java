package lsp;

import java.util.ArrayList;
import java.util.List;

public class Shop implements Storage {
    private final List<Food> shop;

    public Shop() {
        shop = new ArrayList<>();
    }

    @Override
    public void save(Food food) {
        if (food != null) {
            shop.add(food);
        }
    }

    @Override
    public boolean checkPercentExpire(int percent) {
        return percent >= 25 && percent <= 75;
    }

    @Override
    public List<Food> getAllFood() {
        return shop;
    }
}
