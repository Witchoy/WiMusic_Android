package java.witchoy.wimusic_android.model;

import java.io.Serializable;

public class Track implements Serializable {
    private int _id;
    private String _title;
    private String _artist;
    private String _album;
    private String _genre;
    private int _duration;

    public Track() {
        _id = 0;
        _title = "";
        _artist = "";
        _album = "";
        _genre = "";
        _duration = 0;
    }

    public Track(int id, String title, String artist, String album, String genre, int duration) {
        _id = id;
        _title = title;
        _artist = artist;
        _album = album;
        _genre = genre;
        _duration = duration;
    }

    public int getId() {
        return _id;
    }
    public void setId(int id) {
        _id = id;
    }
    public String getTitle() {
        return _title;
    }
    public void setTitle(String title) {
        _title = title;
    }
    public String getArtist() {
        return _artist;
    }
    public void setArtist(String artist) {
        _artist = artist;
    }
    public String getAlbum() {
        return _album;
    }
    public void setAlbum(String album) {
        _album = album;
    }
    public String getGenre() {
        return _genre;
    }
    public void setGenre(String genre) {
        _genre = genre;
    }
    public int getDuration() {
        return _duration;
    }
    public void setDuration(int duration) {
        _duration = duration;
    }

    public String toString() {
        return _title + " - " + _artist;
    }
}
