package generics;
import model.Person;
import org.junit.Assert;
import org.junit.Test;


public class StorageTest {

    @Test
    public void storage1Test(){
        Storage<Person> personStorage = new Storage<>();
        personStorage.add(new Person(12, "Bob", "Ivanov", 33));
        personStorage.add(new Person(22, "Mike", "Ivanov", 34));
        personStorage.add(new Person(34, "John", "Ivanov", 21));

        Assert.assertTrue(personStorage.size() == 3);
    }

    @Test(expected = NumberFormatException.class)
    public void storage2Test(){
        Storage<Number> numbers = new Storage<>();
        numbers.add(3.44);//boxing: double -> 3.44 -> new Double(3.44) -> (Number)
        numbers.add(new Long(123));

        numbers.add(new Double("123, 123"));

    }

    @Test
    public void storage3Test(){
        Storage<String> strs = new Storage<>();
        strs.add("123");
        strs.add("Test");
        strs.add(new String(" "));

        String s = strs.get(strs.size() + 1);
        Assert.assertNull(s);


    }
}
