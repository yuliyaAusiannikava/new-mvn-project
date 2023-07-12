package abs;

public interface Drawable extends Printable {
    void draw();

}

class Triangle implements Drawable{

    @Override
    public void draw() {
        System.out.println("/\\");
        System.out.println("/ \\");
        System.out.println("____");
    }

    @Override
    public void print() {

    }
}

class Tester{
    public static void main(String[] args) {
        new Triangle().draw();
        new Triangle().printDefault();
    }
}
