package model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Person implements Cloneable {
    private int id;
    private String name;
    private String lastName;
    private int age;
    private Cat cat;
    private Car car;

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Person person = (Person) o;
//        return id == person.id;
//    }


    public Person(int id, String name, String lastName, int age) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return id == person.id && age == person.age && Objects.equals(name, person.name)
                && Objects.equals(lastName, person.lastName) && Objects.equals(cat, person.cat);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, lastName, age, cat);
    }

    @Override
    public Person clone() {
        Person clone = null;
        try {
            clone = (Person) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return clone;
    }
}
