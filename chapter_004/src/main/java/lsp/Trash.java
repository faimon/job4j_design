package lsp;

import java.util.ArrayList;
import java.util.List;

public class Trash implements Storage {
    private final List<Food> trash;

    public Trash() {
        trash = new ArrayList<>();
    }

    @Override
    public void save(Food food) {
        if (food != null) {
            trash.add(food);
        }
    }

    @Override
    public boolean checkPercentExpire(int percent) {
        return percent >= 100;
    }

    @Override
    public List<Food> getAllFood() {
        return trash;
    }
}
