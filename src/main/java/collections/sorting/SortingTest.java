package collections.sorting;

import lombok.AllArgsConstructor;
import lombok.Data;
import model.Car;
import model.Person;

import java.util.*;

public class SortingTest {
    public static void main(String[] args) {

        Person p1 = new Person(123, "Mike", "Jackson", 40);
        Person p2 = new Person(21, "John", "Jameson", 35);
        Person p3 = new Person(243, "Bob", "Tailor", 77);
        Person p4 = new Person(555, "Alex", "Smith", 23);
        Person p5 = new Person(667, "Alexis", "Fry", 14);
        Person p6 = new Person(2145, "Mary", "Jane", 2);

        Car c1 = new Car(33, "BMW 3");
        Car c2 = new Car(17, "Acura");
        Car c3 = new Car(99, "Audi");
        Car c4 = new Car(15, "BMW 4");
        Car c5 = new Car(23, "BMW 5");
        Car c6 = new Car(333, "BMW 6");

        p1.setCar(c1);
        p2.setCar(c2);
        p3.setCar(c3);
        p4.setCar(c4);
        p5.setCar(c5);
        p6.setCar(c6);



        List<Person> persons = Arrays.asList(p1, p2, p3, p4, p5, p6);

        //1st via Comparable

        System.out.println(persons);
        Collections.shuffle(persons);
        System.out.println(persons);
        Collections.sort(persons);
        System.out.println(persons);

        List<String> strs = Arrays.asList("BB", "AAA", "AA", "Y", "CC");
        Collections.sort(strs);
        System.out.println(strs);

        List<Car> cars = Arrays.asList(new Car(), new Car());
        Collections.sort(cars);

        //2nd via Comparator
        Collections.sort(persons, new PersonsByCarsIDComparator());
        System.out.println(persons);

        Collections.sort(persons, new PersonsByAgeComparator());
        System.out.println(persons);

        Pizza pizza1 = new Pizza('s', "Cheese Pizza", 2000, true);
        Pizza pizza2 = new Pizza('m', "Veggie", 2000, false);
        Pizza pizza3 = new Pizza('s', "Pepperoni", 1900, true);
        Pizza pizza4 = new Pizza('l', "Pepperoni", 2900, true);

        List<Pizza> pizzas = Arrays.asList(pizza1, pizza2, pizza3, pizza4);
        Collections.sort(pizzas);
        System.out.println(pizzas);

        Collections.sort(pizzas, PizzaByNameComparator.BY_NAME);




    }
}

class PersonsByCarsIDComparator implements Comparator<Person>{

    @Override
    public int compare(Person o1, Person o2) {
        System.out.println("PersonsByCarsIDComparator -> compare");
        return o1.getCar().compareTo(o2.getCar());
    }
}

class PersonsByCarsModelComparator implements Comparator<Person>{

    @Override
    public int compare(Person o1, Person o2) {
        System.out.println("PersonsByCarsModelComparator -> compare");
        return o1.getCar().getModel().compareTo(o2.getCar().getModel());
    }
}




class PersonsByAgeComparator implements Comparator<Person>{
private boolean asc = true;
public PersonsByAgeComparator(boolean asc){
    this.asc = asc;
}

public PersonsByAgeComparator(){

}

    @Override
    public int compare(Person o1, Person o2) {
    return asc?
        new Integer(o1.getAge()).compareTo(o2.getAge())
            :
            new Integer(o2.getAge()).compareTo(o1.getAge());
    }
}

@Data
@AllArgsConstructor
class Pizza implements Comparable<Pizza>, Comparator<Pizza>{
    private char size; // can be s, m, l
    private String name;
    private long kcal;
    private boolean isThin;


    @Override
    public int compareTo(Pizza o) {
        return Long.valueOf(kcal).compareTo(o.kcal);
    }

    @Override
    public int compare(Pizza o1, Pizza o2) {
        return o1.name.compareTo(o2.name);
    }
}

class  PizzaByNameComparator implements Comparator<Pizza>{

    public static PizzaByNameComparator BY_NAME = new PizzaByNameComparator();

    @Override
    public int compare(Pizza o1, Pizza o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
