package com.mussatto.model;

import javax.persistence.*;

@Entity
@Table(name = "USERCONNECTION")
public class UserConnection {

    @Id
    private UserConnectionPK primaryKey = new UserConnectionPK();

    @Column(name = "ACCESSTOKEN")
    private String accessToken;
    @Column(name = "DISPLAYNAME")
    private String displayName;
    @Column(name = "EXPIRETIME")
    private Long expireTime;
    @Column(name = "IMAGEURL")
    private String imageUrl;
    @Column(name = "PROFILEURL")
    private String profileUrl;
    @Column(name = "RANK")
    private int rank;
    @Column(name = "REFRESHTOKEN")
    private String refreshToken;
    @Column(name = "SECRET")
    private String secret;


    public String getUserId() {
        return primaryKey.getUserId();
    }

    public void setUserId(String userId) {
        primaryKey.setUserId(userId);
    }

    protected UserConnectionPK getId() {
        return primaryKey;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public Long getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(Long expireTime) {
        this.expireTime = expireTime;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getProfileUrl() {
        return profileUrl;
    }

    public void setProfileUrl(String profileUrl) {
        this.profileUrl = profileUrl;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    public UserConnectionPK getPrimaryKey() {
        return primaryKey;
    }

    public void setPrimaryKey(UserConnectionPK primaryKey) {
        this.primaryKey = primaryKey;
    }

}
