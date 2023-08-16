package enums;
//импорт всех статических методов и полей
import static enums.Constants.*;

//импорт конкретный метод или поле, класс и т.п.
import static java.lang.Math.PI;
import static java.lang.Math.cos;


public class Test {
    public static void main(String[] args) {
         cos(2);
        double x = PI + Constants.PI;
        Math.random();
        Math.random();
        System.out.println(Math.random());

        random(100);

        //Constants.ONE;


        Problem problem1 = new Problem("No Access to https//....");
        problem1.setSeverity(Severity.BLOCKER);
        problem1.resolve();

    }

    static int random(int bound){
        int x = (int) (Math.random()) * bound;
        return x;
    }


}
