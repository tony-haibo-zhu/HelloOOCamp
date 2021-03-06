package FirstLesson;

import org.junit.Test;

import static org.hamcrest.core.IsSame.sameInstance;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

public class ParkingLotTest {

    @Test
    public void should_be_able_to_pick_the_car_after_parking_it() {
        ParkingLot parkingLot = new ParkingLot(1);
        Car car = new Car();

        String token = parkingLot.park(car);

        assertThat(car, sameInstance(parkingLot.pick(token)));
    }

    @Test
    public void should_pick_the_car_when_park_it_into_the_parking_lot_with_a_car() throws Exception {
        ParkingLot parkingLot = new ParkingLot(1);
        Car car = new Car();

        String token = parkingLot.park(car);

        assertThat(car, sameInstance(parkingLot.pick(token)));
    }

    @Test
    public void should_pick_the_correct_car_after_parking_it_into_parking_lot_with_multi_cars() throws Exception {
        ParkingLot parkingLot = new ParkingLot(1);
        Car car = new Car();

        String token = parkingLot.park(car);
        Car pickCar = parkingLot.pick(token);

        assertThat(pickCar, sameInstance(car));
    }

    @Test
    public void should_return_null_when_using_incorrect_token_to_pick_car() throws Exception {
        ParkingLot parkingLot = new ParkingLot(1);
        Car car = new Car();

        parkingLot.park(car);
        Car pickCar = parkingLot.pick("wrong token");

        assertNull(pickCar);
    }

    @Test
    public void should_return_null_when_have_picked_car_once() throws Exception {
        ParkingLot parkingLot = new ParkingLot(1);
        Car car = new Car();

        String token = parkingLot.park(car);
        parkingLot.pick(token);

        assertNull(parkingLot.pick(token));
    }

    //todo add test for parking lot capacity.

    @Test
    public void should_return_null_when_parking_car_and_parking_lot_is_full() throws Exception {
        ParkingLot parkingLot = new ParkingLot(1);
        Car firstCar = new Car();
        parkingLot.park(firstCar);

        Car secondCar = new Car();

        assertNull((parkingLot.park(secondCar)));
    }
}
