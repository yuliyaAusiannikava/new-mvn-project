package generics;

public class RawObject {

    private Object o;

    public Object getO() {
        return o;
    }

    public void setO(Object o) {
        this.o = o;
    }
}

class Test{
    public static void main(String[] args) {
        RawObject ro = new RawObject();
        ro.setO("ABC");
        ro.setO(123);
        ro.setO(new Test());
    }
}
