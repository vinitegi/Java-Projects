public class Main {
    public static void main(String[] args) {
        Smatphone celular = new Smatphone();
        playMusic(celular);
        playVideo(celular);
        stopMusic(celular);
        stopVideo(celular);
        pauseMusic(celular);
        pauseVideo(celular);

    }

    public static void playVideo(VideoPlayer videoPlayer) {
        videoPlayer.playVideo();
    }
    public static void stopVideo(VideoPlayer videoPlayer) {
        videoPlayer.stopVideo();
    }
    public static void pauseVideo(VideoPlayer videoPlayer) {
        videoPlayer.pauseVideo();
    }

    public static void playMusic(MusicPlayer musicplayer) {
        musicplayer.playMusic();
    }
    public static void stopMusic(MusicPlayer musicplayer) {
        musicplayer.stopMusic();
    }
    public static void pauseMusic(MusicPlayer musicplayer) {
        musicplayer.pauseMusic();
    }
}
