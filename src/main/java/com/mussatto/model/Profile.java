package com.mussatto.model;

import javax.persistence.*;

@Entity
@Table(name = "profile")
public class Profile {

    private Long id;
    private User user;
    private UserConnection userConnection;

    public Profile() {
    }

    public Profile(User user, UserConnection userConnection) {
        this.user = user;
        this.userConnection = userConnection;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @OneToOne
    @JoinColumn(name = "local_user_id")
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @OneToOne
    @JoinColumns({@JoinColumn(name = "userId", referencedColumnName = "userId"),
            @JoinColumn(name = "providerId", referencedColumnName = "providerId"),
            @JoinColumn(name = "providerUserId", referencedColumnName = "providerUserId")}
    )
    public UserConnection getUserConnection() {
        return userConnection;
    }

    public void setUserConnection(UserConnection userConnection) {
        this.userConnection = userConnection;
    }
}
