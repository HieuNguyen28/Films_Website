package com.fpoly.Model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@SuppressWarnings("ALL")
@Entity
@Table(name="USERS")
@NamedQuery(name="User.findAll", query="SELECT u FROM User u")
public class User implements Serializable {
    @Id
    @Column(name = "ID")
    private String userName;

    @Column(name = "ADMIN")
    private boolean admin;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "FULLNAME")
    private String fullName;

    @Column(name = "PASSWORD")
    private String password;

    //bi-directional many-to-one association to Favorite
    @OneToMany(mappedBy = "user")
    private List<Favorite> favorites;

    //bi-directional many-to-one association to Share
    @OneToMany(mappedBy = "user")
    private List<Share> shares;

    public User() {
    }

    public User(String userName, boolean admin, String email, String fullName, String password, List<Favorite> favorites,
                List<Share> shares) {
        this.userName = userName;
        this.admin = admin;
        this.email = email;
        this.fullName = fullName;
        this.password = password;
        this.favorites = favorites;
        this.shares = shares;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Favorite> getFavorites() {
        return this.favorites;
    }

    public void setFavorites(List<Favorite> favorites) {
        this.favorites = favorites;
    }

    public Favorite addFavorite(Favorite favorite) {
        getFavorites().add(favorite);
        favorite.setUser(this);

        return favorite;
    }

    public Favorite removeFavorite(Favorite favorite) {
        getFavorites().remove(favorite);
        favorite.setUser(null);

        return favorite;
    }

    public List<Share> getShares() {
        return this.shares;
    }

    public void setShares(List<Share> shares) {
        this.shares = shares;
    }

//    @Override
//    public String toString() {
//        return "User{" +
//                "userName='" + userName + '\'' +
//                ", admin=" + admin +
//                ", email='" + email + '\'' +
//                ", fullName='" + fullName + '\'' +
//                ", password='" + password + '\'' +
//                ", favorites=" + favorites +
//                ", shares=" + shares +
//                '}';
//    }
}

