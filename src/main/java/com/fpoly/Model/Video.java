package com.fpoly.Model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="VIDEOS")
@NamedQuery(name="Video.findAll", query="SELECT v FROM Video v")
public class Video implements Serializable {

    @Id
    @Column(name="ID")
    private String videoId;

    @Column(name="ACTIVE")
    private boolean active;

    @Column(name="DESCRIPTION")
    private String description;

    @Column(name="POSTER")
    private String poster;

    @Column(name="LINK")
    private String link;

    @Column(name="TITLE")
    private String title;

    @Column(name="VIEWS")
    private int views;

    //bi-directional many-to-one association to Favorite
    @OneToMany(mappedBy="video")
    private List<Favorite> favorites;

    //bi-directional many-to-one association to Share
    @OneToMany(mappedBy="video")
    private List<Share> shares;

    public Video() {
    }

    public String getVideoId() {
        return this.videoId;
    }

    public void setVideoId(String videoId) {
        this.videoId = videoId;
    }

    public boolean getActive() {
        return this.active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPoster() {
        return this.poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public boolean isActive() {
        return active;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getViews() {
        return this.views;
    }

    public void setViews(int views) {
        this.views = views;
    }

    public List<Favorite> getFavorites() {
        return this.favorites;
    }

    public void setFavorites(List<Favorite> favorites) {
        this.favorites = favorites;
    }

    public Favorite addFavorite(Favorite favorite) {
        getFavorites().add(favorite);
        favorite.setVideo(this);

        return favorite;
    }

    public Favorite removeFavorite(Favorite favorite) {
        getFavorites().remove(favorite);
        favorite.setVideo(null);

        return favorite;
    }

    public List<Share> getShares() {
        return this.shares;
    }

    public void setShares(List<Share> shares) {
        this.shares = shares;
    }

    public Share addShare(Share share) {
        getShares().add(share);
        share.setVideo(this);

        return share;
    }

    public Share removeShare(Share share) {
        getShares().remove(share);
        share.setVideo(null);

        return share;
    }

    @Override
    public String toString() {
        return "Video{" +
                "videoId='" + videoId + '\'' +
                ", active=" + active +
                ", description='" + description + '\'' +
                ", poster='" + poster + '\'' +
                ", link='" + link + '\'' +
                ", title='" + title + '\'' +
                ", views=" + views +
                ", favorites=" + favorites +
                ", shares=" + shares +
                '}';
    }
}
