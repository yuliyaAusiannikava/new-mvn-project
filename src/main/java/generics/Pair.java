package generics;

public interface Pair <K, V> {
    K getKey();
    V getValue();

    default void print(){
        System.out.println(getKey() + " : " + getValue());
    }


}

class Assoc<K, V> implements Pair<K, V>{
    private K key;
    private V value;


    @Override
    public K getKey() {
        return key;
    }

    @Override
    public V getValue() {
        return value;
    }

    public Assoc(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public void setValue(V value) {
        this.value = value;
    }
}

class PairTest{
    public static void main(String[] args) {
        Assoc<String, String> assoc1 = new Assoc<>("Main", "Главный");
        Assoc<String, String> assoc2 = new Assoc<>("Cat", "Кот");
        Assoc<String, String> assoc3 = new Assoc<>("Dog", "Пёсик");


        System.out.println(assoc2.getValue());

        Storage<Assoc<String, String>> assocs = new Storage<>();
        assocs.add(assoc1);
        assocs.add(assoc2);
        assocs.add(assoc3);

        System.out.println(assocs.get(2).getValue());

        //EN
        Assoc<Integer, String> assocIntStr1 = new Assoc<>(1, "One");
        Assoc<Integer, String> assocIntStr2 = new Assoc<>(2, "Two");
        Assoc<Integer, String> assocIntStr3 = new Assoc<>(3, "Three");

        Storage<Assoc<Integer, String>> assocsIntStr1 = new Storage<>();
        assocsIntStr1.add(assocIntStr1);
        assocsIntStr1.add(assocIntStr2);
        assocsIntStr1.add(assocIntStr3);


        //RU
        Assoc<Integer, String> assocIntStrRu1 = new Assoc<>(1, "Один");
        Assoc<Integer, String> assocIntStrRu2 = new Assoc<>(2, "Два");
        Assoc<Integer, String> assocIntStrRu3 = new Assoc<>(3, "Три");

        Storage<Assoc<Integer, String>> assocsIntStrRu1 = new Storage<>();
        assocsIntStrRu1.add(assocIntStrRu1);
        assocsIntStrRu1.add(assocIntStrRu2);
        assocsIntStrRu1.add(assocIntStrRu3);

        Assoc<String, Storage<Assoc<Integer, String>>> global1 = new Assoc<>("EN", assocsIntStr1);
        Assoc<String, Storage<Assoc<Integer, String>>> global2 = new Assoc<>("RU", assocsIntStrRu1);
        Storage<Assoc<String, Storage<Assoc< Integer, String>>>> globalStorage = new Storage<>();
        globalStorage.add(global1);
        globalStorage.add(global2);
    }
}
