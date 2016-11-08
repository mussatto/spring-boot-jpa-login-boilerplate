package com.mussatto.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class UserConnectionPK implements Serializable {

    @Column(name = "USERID")
    private String userId;
    @Column(name = "PROVIDERID")
    private String providerId;
    @Column(name = "PROVIDERUSERID")
    private String providerUserId;

    UserConnectionPK() {
    }

    public UserConnectionPK(String userId, String providerId, String providerUserId) {
        this.userId = userId;
        this.providerId = providerId;
        this.providerUserId = providerUserId;
    }

    String getUserId() {
        return userId;
    }

    void setUserId(String userId) {
        this.userId = userId;
    }

    private String getProviderId() {
        return providerId;
    }

    public void setProviderId(String providerId) {
        this.providerId = providerId;
    }

    private String getProviderUserId() {
        return providerUserId;
    }

    public void setProviderUserId(String providerUserId) {
        this.providerUserId = providerUserId;
    }

    public boolean equals(Object o) {
        if (o instanceof UserConnectionPK) {
            UserConnectionPK other = (UserConnectionPK) o;
            return other.getProviderId().equals(getProviderId())
                    && other.getProviderUserId().equals(getProviderUserId())
                    && other.getUserId().equals(getUserId());
        } else {
            return false;
        }
    }

    public int hashCode() {
        return getUserId().hashCode() + getProviderId().hashCode()
                + getProviderUserId().hashCode();
    }

}