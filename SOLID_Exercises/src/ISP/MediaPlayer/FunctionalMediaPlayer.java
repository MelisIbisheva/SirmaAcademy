package ISP.MediaPlayer;

public class FunctionalMediaPlayer implements FunctionalPlayable{
    @Override
    public void next() {
        System.out.println("Next song!");
    }

    @Override
    public void previous() {
        System.out.println("Previous song!");

    }

    @Override
    public void shuffle() {
        System.out.println("Songs have shuffled");
    }

    @Override
    public void play() {
        System.out.println("Play!");

    }

    @Override
    public void pause() {
        System.out.println("Pause!");

    }
}
