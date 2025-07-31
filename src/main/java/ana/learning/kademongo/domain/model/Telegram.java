package ana.learning.kademongo.domain.model;

import jakarta.persistence.Id;

import java.time.LocalDate;

public class Telegram {

    @Id
    public String id;
    public String headline;
    public String content;
    public String author;
    public LocalDate date;
    public String media;

    public Telegram() {
    }

    public Telegram(String headline, LocalDate date) {
        this.headline = headline;
        this.date = date;
    }

    @Override
    public String toString() {
        return "Telegram{" +
                ", date=" + date +
                ", headline='" + headline + '\'' +
                ", content='" + content + '\'' +
                ", author='" + author + '\'' +
                ", media='" + media + '\'' +
                "ID='" + id + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getHeadline() {
        return headline;
    }

    public void setHeadline(String headline) {
        this.headline = headline;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getMedia() {
        return media;
    }

    public void setMedia(String media) {
        this.media = media;
    }
}
