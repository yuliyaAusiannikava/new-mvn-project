package util;

import errors.CarNotFoundException;
import model.Car;
import model.Person;
import org.junit.Test;

public class PersonsTest {
    @Test
    public void driveTest(){
        Person p1 = new Person();
        p1.setName("John");
        Car car1 = new Car();
        car1.setModel("BMW X7");
        p1.setCar(car1);

        try {
            PersonsUtil.drive(p1);
        } catch (CarNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Test(expected = CarNotFoundException.class)
    public void driveTest1() throws CarNotFoundException {
        Person p1 = new Person();
        p1.setName("John");
        Car car1 = new Car();
        p1.setCar(car1);


        PersonsUtil.drive(p1);

    }
}
