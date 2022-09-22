package data;

public class Playlist {
    private int playlistId;
    private String playlistName;

    public Playlist( String playlistName) {
        this.playlistName = playlistName;
    }

    public Playlist(int playlistId, String playlistName) {
        this.playlistId = playlistId;
        this.playlistName = playlistName;
    }


    public int getPlaylistId() {
        return playlistId;
    }

    public void setPlaylistId(int playlistId) {
        this.playlistId = playlistId;
    }

    public String getPlaylistName() {
        return playlistName;
    }

    public void setPlaylistName(String playlistName) {
        this.playlistName = playlistName;
    }
}
