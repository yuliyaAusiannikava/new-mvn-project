package abs;

// 100% абстрактный класс
public interface Playable {


    // public abstract by default - неявное создание метода
    void play();

    //явное создание метода
    public abstract void stop();

    //by default the field is public and static final (constant)
    double PI = 3.14;

    public static final double X = 0.99;

}
