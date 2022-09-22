package data;

public class ViewPlaylist {
    private int songId;
    private String songName;
    private int playlistId;

    public ViewPlaylist(int songId, String songName, int playlistId) {
        this.songId = songId;
        this.songName = songName;
        this.playlistId = playlistId;
    }


    public int getSongId() {
        return songId;
    }

    public void setSongId(int songId) {
        this.songId = songId;
    }

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public int getPlaylistId() {
        return playlistId;
    }

    public void setPlaylistId(int playlistId) {
        this.playlistId = playlistId;
    }
}
