package generics;

public class GenericObject <T> {
    private T value;

    public GenericObject(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }
}

class GenericTest{
    public static void main(String[] args) {
        GenericObject<String> gen = new GenericObject<String>("ABC");

        String val = gen.getValue();

        GenericObject<Integer> gen2 = new GenericObject<Integer>(123);

        int val2 = gen2.getValue();
        gen2.setValue(54);//54 -> new Integer(54)
        gen2.setValue(new Integer(123));
        int i = gen2.getValue().intValue();
        Double d1 = 10.5;
        Double d2 = new Double(80);

        GenericObject<Boolean> gen3 = new GenericObject<>(true);
        gen3.getValue();



    }
}
