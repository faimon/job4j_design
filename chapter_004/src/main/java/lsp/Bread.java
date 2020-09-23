package lsp;

import java.util.Calendar;

public class Bread extends Food {
    public Bread(String name, Calendar expireDate, Calendar createDate, int price, int discount) {
        super(name, expireDate, createDate, price, discount);
    }
}
