package ISP.MediaPlayer;

public class BasicMediaPlayer implements Playable{
    @Override
    public void play() {
        System.out.println("Play!");
    }

    @Override
    public void pause() {
        System.out.println("Pause!");

    }
}
