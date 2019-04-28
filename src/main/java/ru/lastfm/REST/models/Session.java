package ru.lastfm.REST.models;



public class Session {
    private Integer subscriber;
    private String name;
    private String key;

    public Session(){}

    public Session(Integer subscriber, String name, String key) {
        this.subscriber = subscriber;
        this.name = name;
        this.key = key;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Integer getSubscriber() {
        return subscriber;
    }

    public void setSubscriber(Integer subscriber) {
        this.subscriber = subscriber;
    }

    @Override
    public String toString() {
        return "Session{" +
                "name='" + name + '\'' +
                ", key='" + key + '\'' +
                ", subscriber=" + subscriber +
                '}';
    }
}
