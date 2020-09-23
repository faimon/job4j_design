package lsp;

import java.util.List;

public interface Storage {
    void save(Food food);

    boolean checkPercentExpire(int percent);

    List<Food> getAllFood();
}
