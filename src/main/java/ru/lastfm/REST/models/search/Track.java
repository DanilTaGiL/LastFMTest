package ru.lastfm.REST.models.search;

import ru.lastfm.REST.models.Image;

import java.util.Arrays;
import java.util.Objects;

public class Track {
    private String name;
    private String artist;
    private String url;
    private String streamable;
    private Integer listeners;
    private Image[] image;
    private String mbid;

    public Track(){}

    public Track(String name, String artist, String url, String streamable, Integer listeners, Image[] image, String mbid) {
        this.name = name;
        this.artist = artist;
        this.url = url;
        this.streamable = streamable;
        this.listeners = listeners;
        this.image = image;
        this.mbid = mbid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getStreamable() {
        return streamable;
    }

    public void setStreamable(String streamable) {
        this.streamable = streamable;
    }

    public Integer getListeners() {
        return listeners;
    }

    public void setListeners(Integer listeners) {
        this.listeners = listeners;
    }

    public Image[] getImage() {
        return image;
    }

    public void setImage(Image[] image) {
        this.image = image;
    }

    public String getMbid() {
        return mbid;
    }

    public void setMbid(String mbid) {
        this.mbid = mbid;
    }

    @Override
    public String toString() {
        return "Track{" +
                "name='" + name + '\'' +
                ", artist='" + artist + '\'' +
                ", url='" + url + '\'' +
                ", streamable='" + streamable + '\'' +
                ", listeners=" + listeners +
                ", image=" + Arrays.toString(image) +
                ", mbid='" + mbid + '\'' +
                '}' + "\n";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Track track = (Track) o;
        return Objects.equals(name, track.name) &&
                Objects.equals(artist, track.artist) &&
                Objects.equals(url, track.url) &&
                Objects.equals(streamable, track.streamable) &&
                Objects.equals(listeners, track.listeners) &&
                Objects.equals(mbid, track.mbid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, artist, url, streamable, listeners, mbid);
    }
}