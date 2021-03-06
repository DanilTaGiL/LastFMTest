package ru.lastfm.REST.models.search;

import ru.lastfm.REST.models.Image;

import java.util.Arrays;
import java.util.Objects;

public class Album {
    private String name;
    private String artist;
    private String url;
    private String streamable;
    private Image[] image;
    private String mbid;

    public Album(){}

    public Album(String name, String artist, String url, String streamable, Image[] image, String mbid) {
        this.name = name;
        this.artist = artist;
        this.url = url;
        this.streamable = streamable;
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
        return "Album{" +
                "name='" + name + '\'' +
                ", artist='" + artist + '\'' +
                ", url='" + url + '\'' +
                ", streamable='" + streamable + '\'' +
                ", image=" + Arrays.toString(image) +
                ", mbid='" + mbid + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Album album = (Album) o;
        return Objects.equals(name, album.name) &&
                Objects.equals(artist, album.artist) &&
                Objects.equals(url, album.url) &&
                Objects.equals(streamable, album.streamable) &&
                Objects.equals(mbid, album.mbid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, artist, url, streamable, mbid);
    }
}