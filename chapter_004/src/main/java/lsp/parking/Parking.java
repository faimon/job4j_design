package lsp.parking;

import java.util.List;

public interface Parking {
    void park(Car car);

    List<Car> getAllCars();
}
