package data;

public class Songs {
    private int songId;
    private String songName;
    private String genre;
    private String artistName;
    private String duration;
    private String releaseDate;


    public Songs(int songId, String songName, String genre, String artistName, String duration, String releaseDate) {
        this.songId = songId;
        this.songName = songName;
        this.genre = genre;
        this.artistName = artistName;
        this.duration = duration;
        this.releaseDate = releaseDate;

    }
    public Songs(String songName) {
        this.songName = songName;
    }
    public Songs() {
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

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getArtistName() {
        return artistName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

}
