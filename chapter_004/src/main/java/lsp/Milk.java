package lsp;

import java.util.Calendar;

public class Milk extends Food {
    public Milk(String name, Calendar expireDate, Calendar createDate, int price, int discount) {
        super(name, expireDate, createDate, price, discount);
    }
}
