public class Smatphone implements VideoPlayer, MusicPlayer {

    @Override
    public void playMusic() {
        System.out.println("Playing music");
    }
    @Override
    public void stopMusic() {
        System.out.println("Stopping music");
    }

    @Override
    public void pauseMusic() {
        System.out.println("Pausing music");
    }

    @Override
    public void playVideo() {
        System.out.println("Playing video");
    }
    @Override
    public void stopVideo() {
        System.out.println("Stopping video");
    }

    @Override
    public void pauseVideo() {
        System.out.println("Pausing video");
    }
}
