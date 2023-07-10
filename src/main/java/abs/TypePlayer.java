package abs;

public class TypePlayer extends Player implements Playable {
    @Override
    public void play() {
        System.out.println("Start type record composition");
    }

    @Override
    public void play(int numberOfSongs) {
    }

    @Override
    public void stop() {
        System.out.println("Stop type record composition");

    }
}
